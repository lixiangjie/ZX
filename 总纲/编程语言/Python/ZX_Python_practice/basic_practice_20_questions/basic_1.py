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
    inputDatas = list(iter(input, 'exit'))  # 输入多个数字存入list
    inputDatas_int = []
    # index = 0
    for data in inputDatas:
        inputDatas_int.append(int(data))
        # inputDatas_int.insert(++index, int(data))
    return inputDatas_int

# 数值排序
def datasSort(data_list):
    data_list.sort()
    return data_list

# 打印输出结果
def printSortResult(sortedDatasList):
    print(sortedDatasList)

if __name__ == '__main__':
    inputDatas_list = getInputDatas()
    sortedDatasList = datasSort(inputDatas_list)
    printSortResult(sortedDatasList)


