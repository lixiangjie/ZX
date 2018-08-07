#替换内容程序
#替换最底层的子菜单内容

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

def query(conn, cursor, targetID):
    sql = "SELECT id,title,status from documents where status = " + targetID
    cursor.execute(sql)
    result = cursor.fetchall()
    print(result)
    cursor.close
    return result

def writeToTempFile(sqlSet, tempFilePath, aimsList, begin_ID):
    if os.path.isdir(tempFilePath) or not os.path.isfile(tempFilePath):
        return False
    else:
        try:
            f = open(tempFilePath, "r+", encoding = "utf-8" )
            data = f.read()

            content = ''
            num = 0
            for i in range(len(sqlSet)):
                temp = data.replace(str(aimsList[ 0 ] ), begin_ID + str( sqlSet[ i ][ 0 ] ) ).replace(str(aimsList[ 1 ] ), str( sqlSet[ i ][ 1 ] ) )
                content = content + temp

            f.seek(0)
            f.truncate()
            f.write(content)
            f.flush()
            f.close()

            return True
        except Exception as e:
            print("文件写入异常！")
            print("异常信息为：" + str(e))

def TempFileToEndFile(endFilePath, tempFilePath):
    if os.path.isdir(endFilePath) or not os.path.isfile(endFilePath) or not os.path.isdir(tempFilePath) or os.path.isfile(tempFilePath):
        return False
    else:
        try:
            endFile = open(endFilePath, "r+", encoding = "utf-8" )
            data = endFile.read()
            
            for oneFile in os.listdir(tempFilePath):
                fileName = os.path.basename(oneFile).split('.')[0]
                #目标路径下存在data中的文件名，则读出文件内容替换data中的文件名
                lxjFileName = "lxj" + fileName
                if lxjFileName in data:
                    oneFile = open(os.path.join(tempFilePath, oneFile), "r", encoding = "utf-8" )
                    oneFileData = oneFile.read()
                    data = data.replace(lxjFileName, oneFileData )
                else:
                    print("无目标！")
                    continue
                
            endFile.seek(0)
            endFile.truncate()
            endFile.write(data)
            endFile.flush()
            endFile.close()

            return True
        except Exception as e:
            print("文件内容传递异常！")
            print("异常信息为：" + str(e) )

def copyFile(beginFilePath, tempFilePath, targetID):
    if not os.path.isdir(tempFilePath) or not os.path.isfile(beginFilePath):
        return False
    else:
        try:
            shutil.copy(str(beginFilePath), str(os.path.join(tempFilePath, targetID + ".html" )) )
            return True
        except Exception as e:
            print("文件复制异常！")
            print("异常信息为：" + str(e))

def main():
    beginFilePath = "C:\\Users\\lxj\\Desktop\\test2\\menu-li.html"
    tempFilePath = "C:\\Users\\lxj\\Desktop\\test2\\menu-li"
    endFilePath = "C:\\Users\\lxj\\Desktop\\test2\\delete.html"
    beginFilePath = beginFilePath.replace("\\", "/")
    tempFilePath = tempFilePath.replace("\\", "/")
    endFilePath = endFilePath.replace("\\", "/")
    aimsList = ['ID', '内容']
    begin_ID = "begin_"
    
    conn, cursor = connDB()

    a = 242
    b = 248
    targetID = []
    for i in range(b-a+1):
        targetID.append(str(a+i))

    for i in range(len(targetID)):
        copyFile(beginFilePath, tempFilePath, targetID[i])

    for i in range(len(targetID)):
        sqlSet = query(conn, cursor, targetID[i])  #二维数组
        writeResult = writeToTempFile(sqlSet, tempFilePath + "/" + str(targetID[i]) + ".html" , aimsList, begin_ID)

    print(writeResult)
    endResult = TempFileToEndFile(endFilePath, tempFilePath)

if __name__ == "__main__":
    main()
