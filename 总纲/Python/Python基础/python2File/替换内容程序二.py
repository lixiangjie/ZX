#替换内容程序二
#替换倒数第二层的子菜单内容

'''
IPO：
input：子菜单名称
process：将ID和title替换模板对应内容 + 追加到新文件中
output：完整的页面内容
'''

import pymysql
import os
import shutil

def connDB():
    conn = pymysql.connect(
            host = "localhost",
            user = "root",
            password = "123456789",
            db = "wisdomcomputerroom-test",
            charset = "utf8"
        )
    cursor = conn.cursor()
    return conn,cursor

#
def TempFileToEndFile(endFile, oneTarget, endContent):
    if not os.path.isfile(endFile) or os.path.isdir(endFile):
        return False
    else:
        try:
            endFile = open(endFile, "r+", encoding = "utf-8" )
            data = endFile.read()
            print(oneTarget)
            if oneTarget in data:
                data = data.replace(oneTarget, endContent)
            else:
                print("无目标！")
            
            endFile.seek(0)
            endFile.truncate()
            endFile.write(data)
            endFile.flush()
            endFile.close()

            return "写入完成！"
        except Exception as e:
            print("文件内容传递异常！")
            print("异常信息为：" + str(e) )

def queryTitle(cursor, target):
    sql = "SELECT id,title from doc_title_tree where parentTitle = " + str(target)
    cursor.execute(sql)
    result = cursor.fetchall()
    sql = "SELECT title from doc_title_tree where id = " + str(target)
    cursor.execute(sql)
    title = cursor.fetchone()
    cursor.close()
    return result, title[0]

def queryDoc(cursor, target):
    sql = "SELECT id,title from documents where status = " + str(target)
    cursor.execute(sql)
    result = cursor.fetchall()
    sql = "SELECT title from doc_title_tree where id = " + str(target)
    cursor.execute(sql)
    title = cursor.fetchone()
    cursor.close()
    return result, title[0]

#复制目标文件--跨文件夹复制
def copyFileOtherPath(beginFile, tempFilePath):
    if not os.path.isfile(beginFile):
        return False
    else:
        try:
            shutil.copy(str(os.path.join(beginFile)), str(os.path.join(tempFilePath)))
            print("目标文件复制完成！")
            return True
        except Exception as e:
            print("复制目标文件异常！")
            print("异常信息为：" + str(e))
            return False

def getEndContent(tempFilePath, queryResult, aimsList, position):
    if os.path.isfile(tempFilePath) or not os.path.isdir(tempFilePath):
        return False
    else:
        try:
            for oneFile in os.listdir(tempFilePath):
                f = open(os.path.join(tempFilePath, oneFile), "r+", encoding = "utf-8" )
                data = f.read()

            tempData = data
            endContent = ''
            
            #替换内容--三部分
            for i in range(len(queryResult)):
                temp = data.replace(str(aimsList[ 0 ] ), str(i+1) ).replace( str(aimsList[ 1 ]), "lxj" + str(queryResult[i][0])).replace(str(aimsList[ 2 ] ), queryResult[i][1] ).replace(str("PP"), position)
                endContent = endContent + temp
                data = tempData

            return endContent
        except Exception as e:
            print("获取最终内容异常！")
            print("异常信息为：" + str(e))

def main():
    beginFile = "C:\\Users\\lxj\\Desktop\\test2\\menu-lidiv.html" #模板文件
    tempFilePath = "C:\\Users\\lxj\\Desktop\\test2\\menu-lidiv"  #temp路径
    endFile = "C:\\Users\\lxj\\Desktop\\test2\\delete.html" #目标文件
    beginFile = beginFile.replace("\\", "/")
    tempFilePath = tempFilePath.replace("\\", "/")
    endFile = endFile.replace("\\", "/")
    aimsList = ['zj', 'lxjID', 'title', 'PP']   #zj对应自增ID，title对应title，lxjID对应li的ID（lxj94），PP对应子菜单的位置
    begin_ID = "begin_"
    
    conn, cursor = connDB()
    targetID = "206"
    position = "3"

    copyResult = copyFileOtherPath(beginFile, tempFilePath)

    queryResult, target = queryTitle(cursor, targetID)

    print(queryResult)
    print(target)

    endContent = getEndContent(tempFilePath, queryResult, aimsList, position)

    print(endContent)
    #endResult = TempFileToEndFile(endFile, target+targetID, endContent)

if __name__ == "__main__":
    main()




