# 文件处理
import re
import os
import shutil
import time
import random

# 更改含有数字递增的文件名
# 参数：文件路径、要更改字符串
def changeFileNumName(path, fileName, begin_num):
    if not os.path.isdir(path):
        return False
    else:
        try:
            count = 0
            for x in os.listdir(path):
                nameList = os.path.basename(x).split('.')
                if fileName in nameList[0]:
                    newName = fileName + str(begin_num) + '.' + nameList[1]            # 确定新名字，完全重命名目标文件
                    os.rename(str(os.path.join(path,x)), str(os.path.join(path,newName)))
                    begin_num +=1
                    count +=1
                else:
                    continue
            print("更改" + str(count) + "个文件！" )
            return count
        except Exception as e:
            print("更改文件名异常！")
            print("异常信息为：" + str(e))
            return False

# 删除文件或清空文件夹
def deleteFile(path, fileName):
    if not os.path.isdir(path):
        print("文件路径错误！")
        return False
    else:
        try:
            if fileName == None:
                shutil.rmtree(path)       # 删除整个文件夹及其子文件所有内容
                os.mkdir(path)             # 新建同名文件夹
                result = "清空文件夹" + path + "成功！"
                return result
            else:
                if os.path.isfile(os.path.join(path, fileName)):
                    os.remove(os.path.join(path, fileName))
                    result = "删除文件" + os.path.join(path, fileName) + "成功！"
                    return result
                else:
                    print(str(os.path.join(path, fileName)) + "--不是文件！")
                    return False

        except Exception as e:
            print("删除文件异常！")
            print("异常信息为：" + str(e))

# 复制目标文件--在同一个文件夹下（考虑跨文件夹复制）
# 参数：文件路径、新字符串、复制个数
def copyFile(path, newName, count):
    if not os.path.isdir(path):
        print("文件路径错误！")
        return False
    else:
        try: 
            num = 1
            for x in os.listdir(path):
                nameList = os.path.basename(x).split('.')
                if os.path.isfile(os.path.join(path, x)):           # 判断x是否是文件或文件夹-os.path.join(path, x)形成了完整的文件路径，再对完整的文件路径判断
                    if newName == None:
                        temp = nameList[0]
                    else:
                        temp = newName
                    for i in range(count):
                        shutil.copy(str(os.path.join(path, x)), str(os.path.join(path, temp + str(num) + "." + nameList[1] )))
                        num += 1
                else:
                    print(str(os.path.join(path, x)) + "--不是文件！")
                    continue
            print("复制目标文件:" + str(num-1) + "个！" )
            return num-1
        except Exception as e:
            print("复制目标文件异常！")
            print("异常信息为：" + str(e))
            return False
        

# 复制目标文件--跨文件夹复制
# 旧路径、新路径、起始后缀、复制数量、复制新文件的名称(为None则采用原文件+1的命名方式)
def copyFileOtherPath(oldRootPath, newRootPath, file_num, count, newName):
    if not os.path.isdir(oldRootPath) or not os.path.isdir(newRootPath):
        print("文件路径错误！")
        return False
    else:
        try:
            num = 0
            for x in os.listdir(oldRootPath):
                nameList = os.path.basename(x).split(".")
                if os.path.isfile(os.path.join(oldRootPath, x)):
                    
                        # 新文件名为None,则以原文件+1命名
                        if newName == None:
                            temp = nameList[0]
                        else:
                            # 以新文件名+1命名
                            temp = newName

                        for i in range(count):                           
                            newFileName = temp + str(file_num) + "." + nameList[1]

                            file_num += 1        # 放在continue后，一旦前面的文件存在，后面不存在的文件也无法执行。

                            # 新的路径下查看新的文件是否已经存在
                            if newFileName in os.listdir(newRootPath):
                                print(os.path.basename(newFileName) + "在目标路径:" + newRootPath + "中存在！" )
                                continue             # 跳出当前循环的<剩余>语句，进入下一循环
                            else:                        
                                shutil.copy(str(os.path.join(oldRootPath, x)), str(os.path.join(newRootPath, newFileName) ))
                                num += 1

                else:
                    print(str(os.path.join(oldRootPath, x)) + "---不是文件！")
                    continue
            print("目标文件复制:" + str(num) + "个！")
            return num
        except Exception as e:
            print("复制目标文件异常！")
            print("异常信息为：" + str(e))
            return False


# 更改文件名
# 参数: 文件路径、目标字符串、新字符串、新的起始数、更改状态(0为全部修改(以指定的newStr和begin_num命名)，1为部分修改(只替换目标str，其余不变))
def changeFileName(rootPath, changeStr, newStr, begin_num, state):
    if not os.path.isdir(rootPath) or state not in [int(0), int(1)]:
        print("文件路径或修改状态错误！")
        return False
    else:
        try:
            count = 0
            for x in os.listdir(rootPath):
                if os.path.isfile(os.path.join(rootPath, x)):

                    # print(os.path.join(rootPath, x))    #遍历目录下的所有文件
                    nameList = os.path.basename(x).split('.')

                    # state=1部分修改
                    if state == 1:
                        if changeStr in nameList[0]:
                            newName = x.replace(changeStr, newStr)   # 只修改标目字符串，其余内容不变
                            os.rename( str(os.path.join(rootPath, x)), str(os.path.join(rootPath, newName)) )   # os.path.join() 文件的绝对路径
                            count += 1
                        else:
                            continue
                    else:
                        # state=0全部修改
                        newName = x.replace(nameList[0], newStr + str(begin_num) ) 
                        os.rename( str(os.path.join(rootPath, x)), str(os.path.join(rootPath, newName)) )
                        begin_num += 1
                        count += 1
                    
                else:
                    print(str(os.path.join(rootPath, x)) + "---不是文件！")
                    continue
            print("修改文件个数为:" + str(count) + "个！")
            return count
        except Exception as e:
            print("修改文件名异常！")
            print("异常信息为：" + str(e))
            return False


# 移动文件夹下的所有内容到新的路径
# 原根目录、移动目标目录
def moveFile(oldPath, newPath):
    if not os.path.isdir(oldPath) or not os.path.isdir(newPath):
        print("文件路径错误！")
        return False
    else:
        try:
            # 获取目标目录下的所有文件名
            nameList = []
            for x in os.listdir(newPath):
                name = os.path.basename(x)
                nameList.append(name)
                
            moveNum = 0  # 移动文件的个数
            for x in os.listdir(oldPath):
                if os.path.isfile(os.path.join(oldPath, x)):

                    # 判断移动的文件在目标目录中是否存在
                    if os.path.basename(x) in nameList:
                        # 存在则不移动
                        print(os.path.basename(x) + "在目标路径:" + newPath + "中存在！" )
                        continue
                    else:
                        # 文件不存在则移动
                        shutil.move(os.path.join(oldPath, x), newPath)
                        moveNum += 1                        
                else:
                    print(os.path.join(oldPath, x) + "--不是文件！" )
                    continue
            print("移动文件个数为:" + str(moveNum) +"个！")
            return moveNum
        except Exception as e:
            print("移动文件异常！")
            print("异常信息为：" + str(e))
            return False


def main():

    '''
    # 1. 只根据起始数字递增，更改指定文件的编号
    oldRootPath = "./fileProcess/changeFileNumName"
    fileName = 'begin_'         # 文件本身名字
    begin_num = 1               # 文件新的起始编号
    result = changeFileNumName(oldRootPath, fileName, begin_num)
    '''

    '''
    # 2. 移动所有文件
    oldPath = "./fileProcess/moveFile/oldPath"
    newPath = "./fileProcess/moveFile/newPath"
    moveFile(oldPath, newPath)
    '''

    '''
    # 3. 更改文件名
    rootPath = "./fileProcess/changeFileName"
    changeStr = "lxjzj"        # 文件本身名字
    newStr = "zz"               # 新名字
    begin_num = 100         # 文件新的起始编号
    state = 1    # 0---以指定的newStr和begin_num命名；1---只替换目标str，其余不变
    result = changeFileName(rootPath, changeStr, newStr, begin_num, state)
    '''

    '''
    # 4. 删除文件
    Path = "./fileProcess/deleteFile"
    fileName = None #"test.html"
    result = deleteFile(Path, fileName)   # fileName为none时，清空path下所有文件
    print(result)
    '''

    '''
    # 5. 在当前文件夹复制指定个数的文件
    Path = "./fileProcess/copyFile/path"
    newName = "newName"
    count = 5       #count复制的个数
    result = copyFile(Path, newName, count)
    '''

    '''
    # 6. 跨文件夹复制指定个数的文件
    oldPath = "./fileProcess/copyFileOtherPath/oldPath"
    newPath = "./fileProcess/copyFileOtherPath/newPath"
    newName = "lxjzz"        # 新名字
    file_num = 4                 # 文件起始后缀
    count = 10                   # 复制个数
    result = copyFileOtherPath(oldPath, newPath, file_num, count, newName )    # newName为none时，以原文件名复制
    '''
    
if __name__ == "__main__":
    main()
