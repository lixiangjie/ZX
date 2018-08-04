package DivideConquerAlgorithm;

/**
 * @ClassName: StrassenMatrix
 * @Description: Strassen矩阵乘法
 * 
 *               Strassen的矩阵相乘方法是一种典型的分治算法。 实现矩阵乘法，并考虑当矩阵规模较大时的优化方法。
 * 
 *               矩阵乘法的复杂度主要就是体现在相乘上，而多一两次的加法并不会让复杂度上升太多。
 *               故此，我们思考，是否可以让矩阵乘法的运算过程中乘法的运算次数减少，从而达到降低矩阵乘法的复杂度呢？答案是肯定的。
 * 
 *               strassen算法的关键在于内部递归调用的次数减少了1（从普通的8次变为特殊的7次）。这里的一个结论就是递归算法中递归调用次数少，时间复杂度底。
 *               但凡是能够优化时间复杂度的算法，高复杂度的算法中必然是有一些计算是冗余的，如能用更少的计算代替冗余，就能提高效率。
 * 
 *               冗余的根本原因应该在于基本的乘法分配律a*(b+c)=a*b+a*c。同样的计算结果，前一种（等号前）方法计算需要2次基本运算，而后一种（等号后）方法需要3次。（假设乘法运算和加法运算是同等开销的基本运算）。
 *               而一般的矩阵乘法算法中是大量的单步乘法运算后求和，即采用的是上述等号右边的计算式。如果能有一种方法，将乘法运算中的相同因子提到前边来，运用上述乘法分配律转换计算形式，那么就能提高计算效率。这应该就是strassen算法的本质。看strassen算法的过程，就是先将一部分子矩阵进行加（减）运算，再进行乘法运算。其实就是构造了上述分配律的左式
 * 
 * 
 * 
 * @author:
 * @date: 2017年6月7日 上午11:45:48
 */
public class StrassenMatrix {
	public static void main(String[] args) {
		int a[][] = new int[][] { { 1, 2 }, { 2, 3 } };
		int b[][] = new int[][] { { 1, 2 }, { 2, 3 } };
		int c[][] = new int[][] { { 0, 0 }, { 0, 0 } };
		showdata(a);
		showdata(b);
		mul(a, b, c);
		showdata(c);
	}

	public static void mul(int a[][], int b[][], int c[][]) {
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 2; ++j) {
				for (int k = 0; k < 2; ++k) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
	}

	public static void showdata(int a[][]) {
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[row].length; col++) {
				System.out.print(a[row][col] + " ");
			}
			System.out.println();
		}
	}

}
