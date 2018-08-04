package backtrackingAlgorithm;

import java.util.Arrays;

/**
 * @ClassName: traveling
 * @Description: 回溯---旅行售货员问题
 * 
 *               问题描述： 某售货员要到若干城市去推销商品，已知各城市之间的路程（旅费），他要选定一条从驻地出发，
 *               经过每个城市一遍，最后回到驻地的路线，使总的路程（总旅费）最小。
 * 
 *               问题分析：
 *               旅行售货员问题的解空间是一棵排列树。从树的根节点到任一结点的路径定义了图的一条周游路线。旅行售货员问题要在图G中找出费用最小的周游路线。
 *               问题是一个带权图。图中各边的费用（权）为正数。图的一条周游路线是包括V中的每个顶点在内的一条回路。周游路线的费用是这条路线上所有边的费用之和。
 * 
 *               算法描述： 旅行售货员问题的解空间是一棵排列树x=[1 2 3 ... n] -> 相应的排列树由x[1:n]的所有排列构成。
 *               1.在递归算法Backtrack中， 
 *               2.当i=n时，当前扩展结点是排列树的叶节点的父节点
 *               3.此时算法检测图G是否存在一条从顶点x[n-1]到顶点x[n]的边 。。。
 * 
 * @author:
 * @date: 2017年5月26日 下午3:14:06
 */
public class traveling {

	public int num;	// 图G的顶点数
	public int[] x;	// 当前解
	public int[] bestx;	// 当前最优路徑解
	public float bestc;	// 当前最优花費值--最優路線的花費
	public float cost;	// 当前费用
	public float[][] a;	// 图G的邻接矩阵

	//構造函數
	public traveling(float[][] a, int n) {
		this.num = n;
		x = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			x[i] = i;
		}
		
		System.out.println("x初始化數組：");
		for(int i=0;i<5;i++){
			System.out.println(Arrays.toString(x));
		}
		
		bestc = 10000;	
		bestx = new int[num + 1];
		cost = 0;	//費用初始為0
		this.a = a;
	}

	// 交換
	public void swap(int[] x, int i, int j) {
		int temp;
		temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}

	//回溯
	public void backtrack(int i) {
		//當i等於圖頂點的個數
		if (i == num) {
			if (a[x[num - 1]][x[num]] != -1 && a[x[num]][1] != -1 && (bestc == 10000)
					|| cost + a[x[num - 1]][x[num]] + a[x[num]][1] < bestc) {
				for (int j = 1; j <= num; j++) {
					
					//將當前結果存入最優結果
					bestx[j] = x[j];

				}
				//獲取此時的最優花費
				bestc = cost + a[x[num - 1]][x[num]] + a[x[num]][1];
			}
		} 
		
		//i不等於圖頂點的個數
		else {
			for (int j = i; j <= num; j++) {
				
				//當存在可走的路徑   並且  （路線的花費達到最優值、當前花費+下一步的花費<最優值）時，交換當前結x[]數組中對應路線的位置
				if (a[x[i - 1]][x[j]] != -1 && (bestc == 10000 || cost + a[x[i - 1]][x[j]] < bestc)) {
					swap(x, i, j);
					cost += a[x[i - 1]][x[i]];
					backtrack(i + 1);
					
					//回退
					cost -= a[x[i - 1]][x[i]];
					//回退之後重置交換之前的位置
					swap(x, i, j);
				}
			}
		}
	}

	public static void main(String[] args) {
		int num = 4;	//圖的頂點個數
		float[][] a = { { 0, 0, 0, 0, 0 }, { 0, -1, 30, 6, 4 }, { 0, 30, -1, 5, 10 }, { 0, 6, 5, -1, 20 },
				{ 0, 4, 10, 20, -1 } };// a下标从1开始，0用来凑数；-1表示不同，1表示连通
		
		System.out.println("圖的鄰階矩陣表示為：");
		for(int i=0;i<5;i++){
			System.out.println(Arrays.toString(a[i]));
		}
		
		traveling b = new traveling(a, num);
		b.backtrack(2);	//圖最少含有兩個頂點，開始回溯
		
		System.out.println("最短回路长为：" + b.bestc);
		System.out.print("最短回路为：");
		for (int i = 1; i <= num; i++) {
			System.out.print(b.bestx[i] + " ");
		}
	}
}
