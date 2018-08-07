package backtrackingAlgorithm;

/**
 * @ClassName: RecollectionSearch
 * @Description:回溯算法---马遍历问题
 * 
 * 				   问题描述： 马的遍历问题。
 *               在n*m的棋盘中，马只能走"日"字。马从位置(x,y)出发，把棋盘的每一格都走一次且只走一次。找出所有路径。
 * 
 *               问题分析：
 *               马是在棋盘的点上行走的，所以这里的棋盘是指行有N条边、列有M条边。而一个马在不出边界的情况下有8个方向可以行走(走"日"字)。
 *               如当前坐标为(x,y)，则行走后的坐标可以为: (x+1, y+2) (x+1, y-2) (x+2, y+1) (x+2,
 *               y-1) (x-1, y-2) (x-1, y+2) (x-2, y-1) (x-2, y+1)
 * 
 *               搜索的解空间是整个棋盘上的n*m个点。 约束条件是不出边界且每个点只经过一次。
 *               搜索过程是从任一点(x,y)出发，按照深度优先的原则，从8个方向中尝试一个可以走的点，直到走过棋盘上所有 n*m个点。
 *               
 *               算法将初始位置固定在棋盘左上角（a[0][0] = 1;），设置回溯层数为1，调用find()进行回溯时，
 *               将下一次的回溯层数设置为2，作为find()函数参数传递，递归时，将当前回溯层数dep赋值于新的坐标，遍历所有可能的坐标位置。
 * 
 * @author:
 * @date: 2017年5月25日 下午3:10:18
 */
public class recollectionSearch {

	public static void main(String[] args) {
		// 注意(0<=x<n && 0<=y<m)
		// 约束条件限制： 不出边界且每个点只经过一次。当n=3,m=3;n=4,y=4等时，不满足约束条件
		int n = 4;
		int m = 3;
		int x = 0;
		int y = 0;
		recollectionSearch rSearch = new recollectionSearch(n, m, x, y);
		
		//设置下一步的回溯层数从2开始
		rSearch.find(x, y, 2);
		System.out.println();
		
		System.out.println("解的总数count=" + rSearch.getCount());
	}
	
	private int n;// 棋盘行数	
	private int m;// 棋盘列数	
	private int x;// 马的起始x坐标	
	private int y;// 马的起始y坐标	
	private int[][] a;// 棋盘坐标	
	private int count;// 求解总数	
	
	public int[] nextX = { 1, 2, 2, 1, -1, -2, -2, -1 };// "日"字x坐标
	public int[] nextY = { 2, 1, -1, -2, -2, -1, 1, 2 };// "日"字y坐标

	//构造方法
	public recollectionSearch(int _n, int _m, int _x, int _y) {
		n = _n;
		m = _m;
		x = _x;
		y = _y;
		a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = 0;
			}
		}
		// 马的起点，设置回溯层数为1
		a[x][y] = 1;
		count = 0;
	}

	//寻找路径
	public void find(int x, int y, int dep) {
		int i, newX, newY;
		for (i = 0; i < 8; i++) {
			newX = x + nextX[i];
			newY = y + nextY[i];
			// 判断新坐标是否出界，是否已走过
			if (check(newX, newY) == 1) {
				
				//将当前回溯层数dep赋值于新的坐标
				a[newX][newY] = dep;
				
				//回溯层数等于最大数，到达底层，输出结果
				if (dep == n * m) {
					output();
				} else {
					// 从新坐标出发，递归下一层
					find(newX, newY, dep + 1);
				}
				// 回溯，恢复未走标志
				a[newX][newY] = 0;
			}
		}
	}

	/**
	 * 判断新坐标是否出界，是否已走过
	 * @param newX 下一坐标的x位置
	 * @param newY 下一坐标的y位置
	 * @return
	 */
	public int check(int newX, int newY) {
		if (newX >= n || newY >= m || newX < 0 || newY < 0 || a[newX][newY] != 0) {
			return 0;
		}
		return 1;
	}

	//输出结果的轨迹
	public void output() {
		count++;
		System.out.print("第" + count + "种解法：");
		for (int i = 0; i < n; i++) {
			System.out.println();
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + " ");
			}
		}
		System.out.println();
		System.out.println("---");
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
