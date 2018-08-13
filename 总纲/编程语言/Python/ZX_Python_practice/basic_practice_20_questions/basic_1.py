# -*- coding: utf-8 -*-
"""
-------------------------------------------------
   File Name:   bestBaseballPlayer
   Description: 输入四个整数从大到小排序
   Author:      tebon
   Date:        2018/8/8
-------------------------------------------------
   Change Activity: 2018/8/8
-------------------------------------------------
"""
__author__ = 'tebon'

# 获取输入数值
def getInputDatas():
    inputDatas_list = list(iter(input, 'exit'))  # 输入多个数字存入list
    inputDatas = [int(data) for data in inputDatas_list]
    return inputDatas

# 数值排序
def datasSort(data_list):
    data_list.sort()
    return data_list

# 打印输出结果
def printSortResult(sortedDatasList):
    print(sortedDatasList)

if __name__ == '__main__':
    inputDatas = getInputDatas()
    sortedDatasList = datasSort(inputDatas_list)
    printSortResult(sortedDatasList)


"""
Q1：list['4','3','2','1'] 数字型字符串转数字
A1：方法改进过程：
    1.  index = 0
        result = []
        for data in list:
            result.insert(++index, int(data))
        return result
        
    2.  result = []
        for data in list:
            result.append(int(data))
        return result
        
    3.  result = [int(data) for data in list]
        return result
    
"""


