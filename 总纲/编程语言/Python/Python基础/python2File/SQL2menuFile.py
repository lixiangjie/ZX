#自动生成指定目标菜单下的文件并填充数据库内容

"""
待解决问题：
1. 错误回滚；
2. 遍历多层菜单（SQL迭代查询）优化


IPO模式：
输入：文件三个路径、目标ID、目标文件的新名称、替换内容
处理：自动生成指定目标菜单下的文件并填充数据库内容
输出：目标菜单下的对应文件


大致思路：
1. 初始路径oldRoot中含有一个模板文件--test.html；
2. 在数据库中查询指定target的个数与起始ID；
3. 在过度路径中，采用(新名称_ID)的方式，更改对应个数的文件名；
4. 读取数据库中，映射ID的内容，改写关联文件；
5. 移动文件到最终路径。


四个函数：
1. 文件查询
2. 文件复制与改名
3. 改写文件内容
4. 移动文件
"""

import pymysql
import re
import shutil
import os
import random
import traceback
import datetime

# connection SQL
def connDB():
    try:
        conn = pymysql.connect(
                host = "localhost",
                user = "root",
                password = "123456789",
                db = "wisdomcomputerroom-PythonFile",
                charset = "utf8"
            )
        cursor = conn.cursor()
        return conn, cursor
    except:
        print("数据库初始化链接异常！")
        traceback.print_exc()
        err2file(traceback.format_exc())

# Err2File记录错误信息到文件
def err2file(string):
    try:
        with open("log_SQL2menuFile.txt", "a+", encoding = "utf-8") as f:
            f.write(string)            # 写入异常string
            f.write("Time: " + str(datetime.datetime.now()) + "\n\n")   # 写入异常log的时间，并换两行
            f.flush()
    except Exception as e:
        print("Error信息写入日志文件异常！")
        print("异常信息为：" + str(e))
        

# SQL query
def query(conn, cursor, sql):
    try:
        cursor.execute(sql)
        result = cursor.fetchall()
        return result
    except:
        print("数据库查询SQL异常！")
        traceback.print_exc()
        err2file(traceback.format_exc())
        

# 复制目标文件--跨文件夹复制
# 模板文件、过渡路径、数据和复制文件的映射ID、复制文件数量、复制新文件的名称
def copyFileOtherPath(beginFile, newPath, file_num, copyCount, newName):
    if not os.path.isfile(beginFile) or not os.path.isdir(newPath):
        print("文件路径错误！")
        return False
    else:
        try:
            nameList = os.path.basename(beginFile).split(".")
            newFileName = newName + str(file_num) + "." + nameList[1]
            count = 0
            for i in range(copyCount):
                shutil.copy( str(os.path.join(beginFile)), str(os.path.join(newPath, newFileName)) )
                count += 1
            return count
        except:
            print("复制目标文件异常！")
            traceback.print_exc()
            err2file(traceback.format_exc())

# 将数据库中的内容写入文件
# 查询结果集、过渡路径、替换内容列表
def writeToFile(sqlSet, newPath, aimsList):
    if not os.path.isdir(newPath) or os.path.isfile(newPath):
        print("文件路径错误！")
        return False
    else:
        try:
            for oneFile in os.listdir(newPath):
                if os.path.isfile(os.path.join(newPath, oneFile)):

                    fileList = os.path.basename(oneFile).split(".")
                    nameList = fileList[0].split("_")
                    fileID = nameList[1]    # 获取文件的ID号，与数据库中的ID对应（映射关系）              

                    # 获得文件的完整路径
                    filePath = os.path.join(newPath, oneFile)

                    # 打开文件
                    with open(filePath, "r+", encoding = "utf-8" ) as f:
                        data = f.read()   # type(data) == str   data是文件中的内容
                        
                        # 向文件对应的位置替换对应的SQL数据
                        for i in range(len(sqlSet)):
                            if fileID == str(sqlSet[ i ][0]):
                                data = data.replace( aimsList[0], sqlSet[i][1] ).replace( aimsList[1], sqlSet[i][2] )   # 两次replace替换
                            else:
                                continue
                            
                        f.seek(0)     #文件指针定位到position0，从开始处删除文件内容，否则文件是定位到数据最后，从最后开始删除
                        f.truncate()   #清空文件
                        f.write(data)   #写入数据
                        f.flush()       #刷新文件内部缓冲区

                else:
                    print(str(os.path.join(newPath, oneFile)) + "---不是文件！")
                    continue
            return "文件写入完成！"
        except:
            print("文件写入异常！")
            traceback.print_exc()
            err2file(traceback.format_exc())


# 移动文件夹下的所有内容到新的路径
# 原目录、新目录
def moveFile(oldPath, newPath):
    if not os.path.isdir(oldPath) or not os.path.isdir(newPath):
        print("文件路径错误！")
        return False
    else:
        try:
            # 遍历目标目录下的所有文件名
            nameList = []
            for x in os.listdir(newPath):
                name = os.path.basename(x)
                nameList.append(name)

            # 移动文件的个数
            moveCount = 0
            
            for x in os.listdir(oldPath):
                if os.path.isfile(os.path.join(oldPath, x)):
                    # 判断移动的文件在目标目录中是否存在
                    if os.path.basename(x) in nameList:
                        # 存在则不移动
                        continue
                    else:
                        # 文件不存在则移动
                        shutil.move(os.path.join(oldPath, x), newPath)
                        moveCount += 1                        
                else:
                    print(os.path.join(oldPath, x) + "--不是文件！" )
                    continue
            return "移动" + str(moveCount) +"个文件完成！"
        except:
            print("移动文件异常！")
            traceback.print_exc()
            err2file(traceback.format_exc())


##### 出错回滚 #####
def main():

    # 初始参数设置
    beginFile = "./SQL2menuFile/oldRoot/test.html"    # 初始路径
    newPath = "./SQL2menuFile/newRoot"  # 过度路径
    endPath = "./SQL2menuFile/endPath"      # 最终目标路径
    aimsList = ["标题", "内容"]     # 替换内容

    conn, cursor = connDB()     # 初始化数据库

    ##### 遍历多层子菜单 #####
    # target = ['1','2','3','4','5','6','7']             
    target = ['1','2','3']
    newName = ['laws_', 'stand_', 'safe_']     # 文件前缀------新名称采用前缀 + " _ " + 后缀(数据库ID)方式(例 rL5_222 )

    try:
        for i in range(len(target)):

            sql = "SELECT DISTINCT id,title,content,status from ((  SELECT * from documents where status in (SELECT id FROM doc_title_tree WHERE parentTitle in (SELECT id FROM doc_title_tree WHERE parentTitle in (SELECT id FROM doc_title_tree WHERE parentTitle in (SELECT id FROM doc_title_tree WHERE parentTitle in (SELECT id FROM doc_title_tree WHERE id = " + "'" + target[i] + "'" + " ) ) ) ) ) "+ " UNION ALL " + "SELECT * from documents where status in (SELECT id FROM doc_title_tree WHERE parentTitle in (SELECT id FROM doc_title_tree WHERE parentTitle in (SELECT id FROM doc_title_tree WHERE parentTitle in (SELECT id FROM doc_title_tree WHERE id = " + "'" + target[i] + "'" + " ) ) ) ) "+ "UNION ALL "+ "SELECT * from documents where status in (SELECT id FROM doc_title_tree WHERE parentTitle in (SELECT id FROM doc_title_tree WHERE parentTitle in (SELECT id FROM doc_title_tree WHERE id = " + "'" + target[i] + "'"  + " ) ) ) "+ "UNION ALL " + "SELECT * from documents where status in (SELECT id FROM doc_title_tree WHERE parentTitle in (SELECT id FROM doc_title_tree WHERE id = " + "'" + target[i] + "'" + " ) )" + "UNION ALL " + "SELECT * FROM documents WHERE status in (SELECT id FROM doc_title_tree WHERE id = " + "'" + target[i] + "'" + " ) )  a "  + " ) ORDER BY a.id "   

            # 1. 文件查询--查询起始ID、复制个数
            sqlSet = query(conn, cursor, sql)
     
            # 2. 文件复制与改名
            for j in range(len(sqlSet)):
                # 初始路径、过渡路径、每条数据的ID、数据量、新名称
                copyResult = copyFileOtherPath(beginFile, newPath, int(sqlSet[ j ][0]), len(sqlSet), newName[i])
            
            # 3. 更改文件内容     
            writeResult = writeToFile(sqlSet, newPath, aimsList)

            # 4. 移动文件夹下的所有内容到别的路径中
            moveResult = moveFile(newPath, endPath)

    except:
        traceback.print_exc()
        err2file(traceback.format_exc())


if __name__ == "__main__":
    main()
