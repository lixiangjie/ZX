package testAlgorithms;

/**
 * @ClassName: Coin
 * @Description: 贪心算法---找零钱问题
 * 
 *               问题描述： 
 *               当前有面值分别为50, 20, 10, 5, 1 面值的零钱，请给出找n元钱的最佳方案（要求找出的零钱数目最少）
 * 
 *               问题分析：
 *               根据常识，我们到店里买东西找钱时，老板总是先给我们最大面值的，要是不够再找面值小一点的，直到找满为止。
 *               如果老板都给你找分数的或者几角的，那你肯定不干，另外，他也可能没有那么多零碎的钱给你找。 
 *               其实这就是一个典型的贪心选择问题。
 * 
 *               算法设计与实现：
 *               先举个例子，假如老板要找给我99元钱，他有上面的面值分别为50，20，10，5，1的零钱面值数，为了找给我最少的零钱数，
 *               那么他是不是该这样找呢，先看看该找多少个50元的，99／50＝1个，
 *               然后给我2个20元的，由于还少给我9元，所以还得给我1个5元和4个1元。
 * 
 * @author:
 * @date: 2017年6月20日 下午5:23:42
 */
public class Coin {
	public static void main(String[] args) {

		// m[]依次存放从大到小排列的零钱面值
		int m[] = { 50, 20, 10, 5, 1 };

		// 需要找的钱数
		int n = 99;

		// 对应数组m中的面值，存放选取不同零钱面值的数量，即找钱方案
		int[] num = new int[m.length];

		num = coin(m, n);

		System.out.println(n + "的找钱方案：");
		for (int i = 0; i < m.length; i++) {
			System.out.println(num[i] + "枚" + m[i] + "元面值");
		}
	}

	// 找零钱算法
	public static int[] coin(int m[], int n) {

		// num[]存放找钱方案
		int[] num = new int[m.length];

		for (int i = 0; i < m.length; i++) {
			// 计算对应零钱面值上的找钱数量
			num[i] = n / m[i];

			// 余下需要找的钱数
			n = n % m[i];
		}
		return num;
	}

}
