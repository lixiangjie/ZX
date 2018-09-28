#k-meas算法

'''
IPO模式：
输入：N个数据
操作：聚类算法
输出：图形化显示聚类结果

基本步骤：
1. 从N个数据对象中选择k个对象作为初始聚类中心；设定最大迭代次数；
2. 计算每个数据对象与k个中心对象的距离，并根据最小距离划分数据对象；
    即：把数据对象划分到与他们最近的中心所代表的类别中去。
3. 对应每个中心点，遍历包含的所有对象，计算包含对象所有维度的和的均值，得出新的中心点。
4. 若聚类中心改变，或迭代次数小于给定的最大迭代次数，则重复2、3；否则返回聚类结果。

'''
import numpy as np
import matplotlib.pyplot as plt

# 随机选取K个数据对象作为聚类中心
def initCenters(dataSet, k):
        numSamples, dim = dataSet.shape         # shape查看矩阵的维数(行、列)
        centers = np.zeros((k, dim))            # 创建k行、dim列填充0的数组
        # 随机地获取K个中心
        for i in range(k):
                index = int(np.random.uniform(0, numSamples))           # uniform返回0至numSamples之间的一个数字
                centers[i, : ] = dataSet[index, :]
        return centers

# 计算一个数据对象到所有聚类中心的距离
def Dist2Centers(sample, centers):
        k = centers.shape[0]            # 获取centers矩阵的行维度，即中心点的个数
        dis2centers = np.zeros(k)       # 创建含有k个0元素的一维数组
        # 计算距离
        for i in range(k):
                dis2centers[i] = np.sqrt( np.sum( np.power(sample - centers[i, :], 2) ) )       # power()第二个参数为几次方
        return dis2centers

# 决定数据对象的所属类别、更新中心点
def kmeans(dataSet, k, iterNum):
        numSamples = dataSet.shape[0]    # 数据对象的个数
        iterCount = 0
        
        # 为数据对象的聚类分配存储
        clusterAssignment = np.zeros(numSamples)

        # 聚类中心点是否更新
        clusterChanged = True

        ## step 1: initialize centers
        centers = initCenters(dataSet, k)
        while clusterChanged and iterCount < iterNum:           # and
                clusterChanged = False
                iterCount += 1
                ## step 2: for each sample
                for i in range(numSamples):
                        dis2center = Dist2Centers(dataSet[i, : ], centers)
                        minIndex = np.argmin(dis2center)                # 返回数组最小值的索引

                        ## step 3: update its belonged cluster
                        if clusterAssignment[i] != minIndex:
                                clusterChanged = True
                                clusterAssignment[i] = minIndex

                ## step 4: update centers
                for j in range(k):
                        pointsInCluster = dataSet[ np.nonzero(clusterAssignment[:] == j)[0] ]   # 返回非零元素的目录
                        centers[ j, : ] = np.mean(pointsInCluster, axis = 0)
        print("succeed!")
        return centers, clusterAssignment

# showResult
def showCluster(dataSet, k, centers, clusterAssignment):
        numSamples, dim = dataSet.shape

        mark = [ 'or', 'ob', 'og', 'om' ]

        # draw all samples
        for i in range(numSamples):
                markIndex = int(clusterAssignment[i])
                plt.plot( dataSet[ i, 0 ], dataSet[ i, 1 ], mark[markIndex] )
                
        mark = [ 'Dr', 'Db', 'Dg', 'Dm' ]

        # draw the centroids
        for i in range(k):
                plt.plot( centers[ i, 0 ], centers[ i, 1 ], mark[i], markersize = 17 )

        plt.show()

def main():
        ## step 1: load dataSet
        print("step 1: load dataSet...")
        dataSet = []
        dataSetFile = open('./testSet.txt')
        for line in dataSetFile:
                lineArray = line.strip().split('\t')
                dataSet.append( [ float( lineArray[0] ), float( lineArray[1] ) ] )

        ## step 2: clustering...
        print("step 2: clustering...")
        dataSet = np.mat(dataSet)

        k = 4   # 聚类中心点
        iterNum = 1000   #迭代次数

        # 最终聚类中心点对象、分配簇的结果
        centers_result, clusterAssignment_result = kmeans(dataSet, k, iterNum) 
        
        ## step 3: show the result
        print("step 3: show the result")
        showCluster(dataSet, k, centers_result, clusterAssignment_result)

main()
















