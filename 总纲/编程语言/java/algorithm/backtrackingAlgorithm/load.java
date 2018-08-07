package backtrackingAlgorithm;

import java.util.Scanner;

/**
 * @ClassName: 回溯---装载问题
 * @Description: 问题描述： 有一批共有 n个集装箱要装上两艘载重量分别为 c1 和 c2 的轮船，其中集装箱 i的重量为
 *               w[i]，且重量之和小于(c1 + c2)。
 * 
 *               问题：要求一个合理的装载方案可将这 n个集装箱装上这两艘轮船。
 * 
 *               例如：当n=3,c1=c2=50,且w=[10,40,40]时，可将集装箱1和集装箱2装上一艘轮船，而将集装箱3装在第二艘轮船；
 *               如果w=[20,40,40],则无法将这3个集装箱都装上轮船。
 * 
 *               思路： 1.首先将第一艘轮船尽可能装满。 2.将剩余的集装箱装上第二艘轮船。
 *               将第一艘轮船尽可能的装满等价于选取全体集装箱的子集，使该子集中集装箱的重量之和最接近 c1 因此，装载问题等价于一个特殊的
 *               0-1 背包问题，是一棵子集树。
 * 
 *               设计： 用回溯法解装载问题时，用子集树表示其解空间显然是最合适的。
 *               可行性约束函数可剪去不满足约束条件(w1load1+w2load2+...+wiloadi)<= c1的子树。
 *               在子集树的第j+1层的节点Z处，用cw记当前的装载重量，即cw=(w1load1+w2load2+...+wjloadj)，
 *               当cw>c1时，以节点Z为根的子树中所有节点都不满足约束条件，因而该子树中解均为不可行解，故可将该子树剪去。
 * 
 * @author:
 * @date: 2017年5月12日 下午4:26:03
 */

public class load {
	private int num;// 集装箱数 num
	private int[] weight;// 集装箱重量数组
	private int capacity;// 第一艘轮船的载重量
	private int nowW;// 当前载重量
	private int bestW;// 当前最优载重量
	private int remainW;// 剩余集装箱重量
	private int[] nowway;// 当前解nowway
	private int[] bestWay;// 当前最优解

	/*
	 * @Description: 回溯
	 * @Title: backtrace
	 * @param i
	 * @return_type: void
	 * @throws:
	 */
	public void backtrace(int i) {

		// 1.到达叶节点
		if (i > num - 1) { // i此时的值=叶节点+1
			if (nowW > bestW) {
				for (int j = 0; j < num; j++) {
					bestWay[j] = nowway[j];
					bestW = nowW;
				}
				return;
			}
		}
		remainW -= weight[i];

		// 2.搜索左子树
		if (nowW + weight[i] < capacity) { // load[i =1
			nowway[i] = 1;
			nowW += weight[i];
			backtrace(i + 1);
			nowW -= weight[i];
		}

		// 3.搜索右子树
		if (nowW + remainW > bestW) {
			nowway[i] = 0;
			backtrace(i + 1);
		}
		remainW += weight[i];
	}

	public static void main(String[] args) {
		// 输入
		System.out.print("输入货物数量：");
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();// 存储输入的数值

		load load = new load();
		load.num = Integer.parseInt(s1);// 将输入的数值设置为集装箱总数
		load.weight = new int[load.num];// 创建集装箱数量的数组
		load.nowway = new int[load.num];
		load.bestWay = new int[load.num];

		// 输出
		System.out.println("随机产生输出货物的重量数组：");
		for (int i = 0; i < load.num; i++) {
			load.weight[i] = (int) (100 * Math.random());
			System.out.print(load.weight[i] + " ");
		}

		// 输入
		System.out.println();
		System.out.print("输入第一艘船的最大装载量：");
		String s2 = scanner.nextLine();
		load.capacity = Integer.parseInt(s2);// 将输入的数值设置为第一艘船的装载量
		for (int i = 0; i < load.num; i++) {
			load.remainW += load.weight[i];
		}
		load.backtrace(0);

		// 输出
		System.out.print("当前最优选择:");
		for (int i = 0; i < load.num; i++){
			System.out.print(load.bestWay[i] + " ");
		}			
		System.out.println();
		System.out.println("第一艘船最优载重量：" + load.bestW);
	}
}
