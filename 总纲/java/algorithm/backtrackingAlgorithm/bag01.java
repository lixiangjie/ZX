package backtrackingAlgorithm;

/**
 * @ClassName: bag01
 * @Description: 回溯法---0-1背包
 * 
 *               已知：一个旅行者有一个最多能装m公斤的背包，现在有n中物品，每件的重量分别是W1、W2、……、Wn，每件物品的价值分别为C1、C2、……、Cn
 * 
 *               问题:在不超过背包容量的情况下，怎样将物品放入背包，能获得最大的价值或收益。
 * 
 *               限制：每种物品只有一件，可以选择放或者不放 
 *               	1.放入物品的总和不能超过背包的总承重
 *                  2.保证背包中物品的总价值最大
 *               	3.当达到物品的数量上限
 * 
 *               思路：将第一种情况看做左节点，第二种情况看做右节点，第三个限制条件用于终结节点的搜索。
 *               
 *               在回溯开始之前，首先对于背包中的物品按照单位重量价值进行排序，方便于后面右子树的剪枝操作。
 *               在本代码中，省略了该排序过程，在初始化物品的重量和价值时，已经按照单位重量的价值排好了序。
 *               0-1背包问题是一个典型的子集树问题，对于背包中的每一个物品，可以选择放入（左子树）或者不放入（右子树）。
 *               依次对每个节点进行搜索，得到最优解。
 * 
 *               剪枝函数：对于左子树，如果放入物品的重量已经超过了背包的容量，则直接进行剪枝。
 *               对于右子树，是否可以直接跳过本层的物品，直接下一层的搜索操作呢？
 *               这要取决于当前背包剩余的容量，依次取背包中剩余的物品中单位重量价值最大的物品（跳过本层物品），
 *               最终能否超过此前找到的最优解，如果能够超过，则可以向右搜索，不能超过，则右节点变为死节点。
 *               对于寻找剩余物品的最高价值上界，按照背包中剩余空间依次取剩下的物品，当空间不足以取下一个
 *               物品时，则将下一个物品的单位重量价值折算到现在的剩余空间中去计算理想最高上界。
 *
 * @author:
 * @date: 2017年5月5日 下午5:14:15
 */
public class bag01 {

	// 放入物品的数量
	private int n = 5;
	// 背包容量
	private float capacity = 8;
	// 物品重量
	float[] weight = { 2.0f, 6.0f, 4.0f, 1.0f, 5.0f };
	// 物品价值
	float[] value = { 6.0f, 9.2f, 6.2f, 1.3f, 4.5f };

	// 最大价值
	private float maxValue = 0; 
	// 当前价值
	private float nowValue; 
	// 当前重量
	private float nowWeight; 
	// 设置物品是否可取的状态0-1
	private int[] way = new int[n]; 
	// 设置物品最终的取出结果
	private int[] bestWay = new int[n]; 

	/*
	 * @Description: 回溯
	 * 
	 * @Title: BackTrack
	 * 
	 * @param t（回溯层数）
	 * 
	 * @return_type: void
	 * 
	 * @throws:
	 */
	public void BackTrack(int t) {
		// 已经搜索到根节点
		if (t > n - 1) {
			if (nowValue > maxValue) { // 当前价值大于最大价值
				maxValue = nowValue; // 更新最大价值
				for (int i = 0; i < n; i++)
					bestWay[i] = way[i];
			}
			return;
		}

		// 搜索左边节点
		if (nowWeight + weight[t] <= capacity) {
			nowWeight += weight[t];
			nowValue += value[t];
			way[t] = 1; // 设置物品是否为可取的状态
			BackTrack(t + 1);

			// 还原现场，恢复之前的状态
			nowWeight -= weight[t];
			nowValue -= value[t];
			way[t] = 0;
		}

		// 不装入这个物品，直接搜索右边的节点
		if (Bound(t + 1) >= maxValue) {
			BackTrack(t + 1);
		}
	}

	/*
	 * @Description: 用于计算剩余物品的最高价值上界
	 * 
	 * @Title: Bound
	 * 
	 * @param k（回溯的层数）
	 * 
	 * @return: maxLeft（选择物品的最大价值）
	 * 
	 * @return_type: double
	 * 
	 * @throws:
	 */
	public double Bound(int k) {

		double maxLeft = nowValue;
		float leftWeight = capacity - nowWeight; // 计算剩余容量

		// 尽力依照单位重量价值次序，由高往低，装剩余的物品
		while (k <= n - 1 && leftWeight > weight[k]) {
			leftWeight -= weight[k];
			maxLeft += value[k];
			k++;
		}

		// 不能装时，用下一个物品的单位重量价值折算到剩余空间。
		if (k <= n - 1) {
			maxLeft += value[k] / weight[k] * leftWeight;
		}
		return maxLeft;
	}

	public static void main(String[] args) {

		bag01 bag01 = new bag01();
		bag01.BackTrack(0);

		System.out.println("该背包能够取到的最大价值为:" + bag01.maxValue);
		System.out.println("取出的方法为:");

		// 输出最终选择结果
		for (int i : bag01.bestWay) {
			System.out.print(i + "     ") ;
		}
		System.out.println();
		for (float j : bag01.value){
			System.out.print(j + "   ");
		}
	}
}