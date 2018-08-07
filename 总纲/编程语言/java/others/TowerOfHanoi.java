import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description: 汉诺塔问题
 * 
 *               递归就是方法内部自己调用自己，同时也一定有一个结束点。 从栈的角度：就是从主线程开始调用方法进行不停的压栈和出栈操作。
 *               方法的调入就是将方法压入栈中。方法的结束就是方法出栈的过程。 这样保证了方法调用的顺序流，
 *               如果跟踪递归的调用情况会发现也是如此，到最后一定是这个方法最后从栈中弹出回到主线程，并且结束。 栈的特点:先进后出。
 * 
 *               利用树的遍历理解汉诺塔柱子调用顺序的变化。遍历的顺序对应移动的过程。
 * 
 *               A->C (ABC) 
 *                   | 
 *            ———————————————— 
 *           |                | 
 *    (ACB) A->B             B->C (BAC) 
 *           |                |
 *        ——————		   ——————— 
 *       |      |         |       | 
 *     A->C    C->B      B->A    A->C 
 *    (ABC)   (CAB)     (BCA)   (ABC)
 * 
 * @ClassName: TowerOfHanoi
 * @author:
 * @date: 2017年5月4日 下午3:24:46
 */
public class TowerOfHanoi {
	public static void main(String[] args) throws IOException {
		int j;
		String str;
		BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("输入盘子数量：");
		str = keyin.readLine();
		j = Integer.parseInt(str);
		hanoi(j, 1, 2, 3);
	}

	public static void hanoi(int n, int p1, int p2, int p3) {
		if (n == 1) { // 一个盘子的情况，也是递归的出口
			System.out.println("盘子从" + p1 + "移动到" + p3);
		} else { // 盘子数量大于1时，用抽象出的三步来移动
			hanoi(n - 1, p1, p3, p2); // 将n-1个环从p1移动到p2上
			System.out.println("盘子从" + p1 + "移动到" + p3); // 将底盘从p1移动到p3上
			hanoi(n - 1, p2, p1, p3); // 将p2上的n-1个环移动到p3上
		}
	}
}
