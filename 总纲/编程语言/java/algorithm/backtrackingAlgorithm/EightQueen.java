package backtrackingAlgorithm;

import java.util.Date;

/**
 * @ClassName: EightQueen
 * @Description:回溯算法---8皇后问题 
 * 
 * 				   问题描述：在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 *               下面使用递归方法解决
 * 
 *               算法思路： 
 *               构建二维int或者short型数组，内存中模拟棋盘：
 *               chess[r][c]=0表示：r行c列没有皇后，chess[r][c]=1表示：r行c列位置有一个皇后。
 *               从第一行第一列开始逐行摆放皇后，依题意每行只能有一个皇后，遂逐行摆放，每行一个皇后即可；
 *               摆放后立即调用一个验证函数（传递整个棋盘的数据），验证合理性，安全则摆放下一个，不安全则尝试摆放这一行的下一个位置，直至摆到棋盘边界；
 *               当这一行所有位置都无法保证皇后安全时，需要回退到上一行，清除上一行的摆放记录，并且在上一行尝试摆放下一位置的皇后（回溯算法的核心）；
 *               当摆放到最后一行，并且调用验证函数确定安全后，累积数自增1，表示有一个解成功算出；
 *               验证函数中，需要扫描当前摆放皇后的左上，中上，右上方向是否有其他皇后，有的话存在危险，没有则表示安全，并不需要考虑当前位置棋盘下方的安全性，因为下面的皇后还没有摆放。
 * 
 * @author:
 * @date: 2017年6月6日 下午3:26:50
 */
public class EightQueen {

	private static final short N = 11; // 定义常量N皇后
	private static int count = 0; // 结果计数器

	public static void main(String[] args) {

		Date beginDate = new Date();

		// 初始化棋盘，全部置0
		short chess[][] = new short[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				chess[i][j] = 0;
			}
		}

		// 摆放皇后
		putQueenAtRow(chess, 0);

		Date endDate = new Date();
		System.out.println("耗时：" + String.valueOf(endDate.getTime() - beginDate.getTime()) + "毫秒");
		System.out.println("计算结果：" + count);
	}

	public static void putQueenAtRow(short[][] chess, int row) {

		// 递归终止判断：如果row=N，则说明已经成功摆放了8个皇后，输出结果，终止递归
		if (row == N) {
			count++;
			System.out.println("第" + count + "种解：");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(chess[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}

		short[][] chessTemp = chess.clone();

		// 向这一行的每一个位置尝试摆放皇后，然后检测状态，如果安全则继续执行递归函数摆放下一行皇后
		for (int i = 0; i < N; i++) {

			// 摆放这一行的皇后，之前要清理掉所有这一行摆放的记录，防止污染棋盘
			for (int j = 0; j < N; j++) {
				chessTemp[row][j] = 0;
			}
			chessTemp[row][i] = 1;

			// 防止皇后之后立即判断是否安全，不完全则清理后再次摆放
			if (isSafety(chessTemp, row, i)) {
				putQueenAtRow(chessTemp, row + 1);
			}
		}
	}

	// 验证函数验证合理性，安全则摆放下一个，不安全则尝试摆放这一行的下一个位置，直至摆到棋盘边界；
	public static boolean isSafety(short[][] chess, int row, int col) {
		// 判断中上，左上，右上是否安全
		int step = 1;
		while (row - step >= 0) {
			if (chess[row - step][col] == 1) { // 中上
				return false;
			}
			if (col - step >= 0 && chess[row - step][col - step] == 1) { // 左上
				return false;
			}
			if (col + step < N && chess[row - step][col + step] == 1) { // 右上
				return false;
			}
			step++;
		}
		return true;
	}
}
