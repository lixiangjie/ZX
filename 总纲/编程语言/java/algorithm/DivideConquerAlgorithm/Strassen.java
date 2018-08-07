package DivideConquerAlgorithm;

import java.io.*;
import java.util.*;

class matrix {
	public int[][] m = new int[32][32];
}

public class Strassen {
	public int judgment(int n) {
		int flag = 0, temp = n;
		while (temp % 2 == 0) {
			if (temp % 2 == 0)
				temp /= 2;
			else
				flag = 1;
		}
		if (temp == 1)
			flag = 0;
		return flag;
	}

	public void Divide(matrix d, matrix d11, matrix d12, matrix d21, matrix d22, int n)/* 分解矩阵方法 */
	{
		int i, j;
		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++) {
				d11.m[i][j] = d.m[i][j];
				d12.m[i][j] = d.m[i][j + n];
				d21.m[i][j] = d.m[i + n][j];
				d22.m[i][j] = d.m[i + n][j + n];
			}
	}

	public matrix Merge(matrix a11, matrix a12, matrix a21, matrix a22, int n)/* 合并矩阵方法 */
	{
		int i, j;
		matrix a = new matrix();
		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++) {
				a.m[i][j] = a11.m[i][j];
				a.m[i][j + n] = a12.m[i][j];
				a.m[i + n][j] = a21.m[i][j];
				a.m[i + n][j + n] = a22.m[i][j];
			}
		return a;
	}

	public matrix AdhocMatrixMultiply(matrix x, matrix y) /* 阶数为2的矩阵乘法方法 */
	{
		int m1, m2, m3, m4, m5, m6, m7;
		matrix z = new matrix();

		m1 = (y.m[1][2] - y.m[2][2]) * x.m[1][1];
		m2 = y.m[2][2] * (x.m[1][1] + x.m[1][2]);
		m3 = (x.m[2][1] + x.m[2][2]) * y.m[1][1];
		m4 = x.m[2][2] * (y.m[2][1] - y.m[1][1]);
		m5 = (x.m[1][1] + x.m[2][2]) * (y.m[1][1] + y.m[2][2]);
		m6 = (x.m[1][2] - x.m[2][2]) * (y.m[2][1] + y.m[2][2]);
		m7 = (x.m[1][1] - x.m[2][1]) * (y.m[1][1] + y.m[1][2]);
		z.m[1][1] = m5 + m4 - m2 + m6;
		z.m[1][2] = m1 + m2;
		z.m[2][1] = m3 + m4;
		z.m[2][2] = m5 + m1 - m3 - m7;
		return z;
	}

	public matrix MatrixPlus(matrix f, matrix g, int n) /* 矩阵加法方法 */
	{
		int i, j;
		matrix h = new matrix();
		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++)
				h.m[i][j] = f.m[i][j] + g.m[i][j];
		return h;
	}

	public matrix MatrixMinus(matrix f, matrix g, int n) /* 矩阵减法方法 */
	{
		int i, j;
		matrix h = new matrix();
		for (i = 1; i <= n; i++)
			for (j = 1; j <= n; j++)
				h.m[i][j] = f.m[i][j] - g.m[i][j];
		return h;
	}

	public matrix MatrixMultiply(matrix a, matrix b, int n) /* 矩阵乘法方法 */
	{
		int k;
		matrix a11, a12, a21, a22;
		a11 = new matrix();
		a12 = new matrix();
		a21 = new matrix();
		a22 = new matrix();
		matrix b11, b12, b21, b22;
		b11 = new matrix();
		b12 = new matrix();
		b21 = new matrix();
		b22 = new matrix();
		matrix c11, c12, c21, c22, c;
		c11 = new matrix();
		c12 = new matrix();
		c21 = new matrix();
		c22 = new matrix();
		c = new matrix();
		matrix m1, m2, m3, m4, m5, m6, m7;
		k = n;
		if (k == 2) {
			c = AdhocMatrixMultiply(a, b);
			return c;
		} else {
			k = n / 2;
			Divide(a, a11, a12, a21, a22, k); // 拆分A、B、C矩阵
			Divide(b, b11, b12, b21, b22, k);
			Divide(c, c11, c12, c21, c22, k);

			m1 = MatrixMultiply(MatrixMinus(b12, b22, n / 2), a11, k);
			m2 = MatrixMultiply(b22, MatrixPlus(a11, a12, k), k);
			m3 = MatrixMultiply(MatrixPlus(a21, a22, k), b11, k);
			m4 = MatrixMultiply(a22, MatrixMinus(b21, b11, k), k);
			m5 = MatrixMultiply(MatrixPlus(a11, a22, k), MatrixPlus(b11, b22, k), k);
			m6 = MatrixMultiply(MatrixMinus(a12, a22, k), MatrixPlus(b21, b22, k), k);
			m7 = MatrixMultiply(MatrixMinus(a11, a21, k), MatrixPlus(b11, b12, k), k);
			c11 = MatrixPlus(MatrixMinus(MatrixPlus(m5, m4, k), m2, k), m6, k);
			c12 = MatrixPlus(m1, m2, k);
			c21 = MatrixPlus(m3, m4, k);
			c22 = MatrixMinus(MatrixMinus(MatrixPlus(m5, m1, k), m3, k), m7, k);

			c = Merge(c11, c12, c21, c22, k); // 合并C矩阵
			return c;
		}
	}

	public static void main(String[] args) throws IOException {
		Strassen instance = new Strassen();
		int i, j, num;
		matrix A, B, C;
		A = new matrix();
		B = new matrix();
		C = new matrix();
		Scanner in = new Scanner(System.in);
		System.out.print("输入矩阵的阶数: ");
		num = in.nextInt();
		if (instance.judgment(num) == 0) {
			System.out.println("输入矩阵A:");
			for (i = 1; i <= num; i++)
				for (j = 1; j <= num; j++)
					A.m[i][j] = in.nextInt();
			System.out.println("输入矩阵B:");
			for (i = 1; i <= num; i++)
				for (j = 1; j <= num; j++)
					B.m[i][j] = in.nextInt();
			if (num == 1)
				C.m[1][1] = A.m[1][1] * B.m[1][1]; // 矩阵阶数为1时的特殊处理
			else
				C = instance.MatrixMultiply(A, B, num);
			System.out.println("矩阵C为:");
			for (i = 1; i <= num; i++) {
				for (j = 1; j <= num; j++)
					System.out.print(C.m[i][j] + "     ");
				System.out.println();
			}
		} else
			System.out.println("输入的阶数不是2的N次方");
	}
}