package testAlgorithms;

import java.util.Scanner;

/**
 * @ClassName: SeparateCards
 * @Description: ̰���㷨---����ֽ��
 * 
 *               ����������
 *               ��N��ֽ�ƣ���ŷֱ�Ϊ1��2������n��ÿ������������,��ֽ��������Ϊn�ı���.��������һ����ȡ������ֽ��,Ȼ���ƶ���
 *               ���ƵĹ���Ϊ���ڱ��Ϊ1��ȡ��ֽ�ƣ�ֻ���Ƶ����Ϊ2�Ķ��ϣ��ڱ��Ϊn�Ķ���ȡ��ֽ�ƣ�ֻ���Ƶ����Ϊn-1�Ķ��ϣ���������ȡ��ֽ�ƣ������Ƶ�������߻��ұߵĶ��ϡ�
 *               ����Ҫ���ҳ�һ���ƶ������������ٵ��ƶ�����ʹÿ����ֽ������һ���ࡣ ���磺n=4��4��ֽ�Ʒֱ�Ϊ�� �� 9 �� 8 �� 17
 *               �� 6 �ƶ����ο��ԴﵽĿ�ģ��Ӣ�ȡ4���Ʒŵ��ܣ��ٴӢ���3�ŷŵ��ڣ�Ȼ��Ӣ�ȥ1�ŷŵ��١�
 * 
 *               ��������� ��heap_Count=3������ֽ����Ϊ1 2 27
 *               ����ʱcard_Ave=10��Ϊ��ʹ��һ��Ϊ10��Ҫ�ӵڶ�����9�ŵ���һ�ѣ����ڶ���ֻ��2�ſ����ƣ����ǲ�����ζ�Ÿղ�ʹ��̰�ķ��Ǵ�����أ�
 *               ���Ǽ���������������ƹ��̣��ӵڶ����Ƴ�9�ŵ���һ�Ѻ󣬵�һ����10�ţ��ڶ���ʣ��-7�ţ��ڴӵ������ƶ�17�ŵ��ڶ��ѣ��պ�����ֽ�ƶ���10��������ǶԵģ�
 *               �������ƶ������У�ֻ�Ǹı����ƶ���˳�򣬶��ƶ��������㣬��˴���ʹ��̰�ķ����еġ�
 * 
 *               �㷨�����ʵ�֣� ��a[i]Ϊ��I��ֽ�Ƶ�������0<=I<=n����AveΪ���ֺ�ÿ��ֽ�Ƶ�������sΪ��С�ƶ�������
 *               ������̰���㷨�����մ����ҵ�˳���ƶ�ֽ�ơ����I�ѵ�ֽ����������ƽ��ֵ�����ƶ�һ�Σ���s��1��������������ƶ���
 *               1����a[i]>Ave����a[i]-Ave�Ŵӵ�I���ƶ�����I+1�ѣ�
 *               2����a[i]<Ave����Ave-a[i]�Ŵӵ�I+1���ƶ�����I�ѡ�
 *               Ϊ����Ƶķ��㣬���ǰ����������ͳһ�����ǽ�a[i]-Ave�ӵ�I���ƶ�����I+1�ѣ��ƶ�����a[i]=Ave;
 *               a[I+1]=a[I+1]+a[i]-Ave.
 *               �ڴӵ�I+1��ȡ��ֽ�Ʋ����I�ѵĹ����п��ܻس��ֵ�I+1�ѵ�ֽ��С����������
 * 
 * @author:
 * @date: 2017��6��20�� ����7:26:13
 */
public class SeparateCards {
	public static void main(String[] args) {
		separateCards();
	}

	// ����ֽ���㷨
	public static void separateCards() {

		int x = 0;// ��¼�ƶ�����

		// ֽ�ƶ���heap_Count
		System.out.println("����ֽ�ƶ�����");
		Scanner in = new Scanner(System.in);
		int heap_Count = in.nextInt();

		// ÿ��ֽ�Ƶĸ���cardArray[i]
		System.out.println("�ֱ�����" + heap_Count + "��ֽ�Ƶĸ�����");
		int[] cardArray = new int[heap_Count];
		for (int i = 0; i < heap_Count; i++) {
			cardArray[i] = in.nextInt();// �����е�scanner�ж�ȡ���������������
		}

		// ��ȡֽ������
		int card_Sum = 0;
		for (int i = 0; i < cardArray.length; i++) {
			card_Sum += cardArray[i];
		}

		// ÿ��ֽ��ƽ������
		int card_Ave = card_Sum / heap_Count;

		// ��ÿһ��ֽ�Ƶ���������
		if (card_Sum % heap_Count != 0) {
			System.out.println("ֽ�����������ƶѵı�����");
		} else {
			for (int i = 0; i < cardArray.length - 1; i++) {

				// //��ֱ���ж��ƶ�����
				// //ǿ�ƽ�a[i]-v�ӵ�I���ƶ�����I+1��
				// if (cardArray[i]-card_Ave!=0) {
				// cardArray[i+1]=cardArray[i+1]+cardArray[i]-card_Ave;
				// x++;
				// }

				// �ֱ��ж��ƶ�����
				// ��i��ֽ�Ƹ���<ƽ��ֽ�Ƹ���
				if (cardArray[i] < card_Ave) {
					
					// ��¼�ƶ�����x���ж��ڼ����ƶ���ֻ��ʾ�����ı����һ�ε��ƶ�������������û�ı�ʱ������ʾ�ƶ����
					System.out.println("��" + (x + 1) + "���ƶ���");
					
					
					System.out.println("    �ӵ�" + (i + 2) + "���ƶ�����" + (i + 1) + "�ѣ��ƶ�" + (card_Ave - cardArray[i]) + "�š�");
					cardArray[i + 1] -= card_Ave - cardArray[i];// ��һ�ѵ�ֽ�Ƹ��� -(ƽ��ֵ-��һ�ѵ�ֽ�Ƹ���)
					cardArray[i] += card_Ave - cardArray[i];// ��һ��ֽ�Ƹ���+(ƽ��ֵ-��һ�ѵ�ֽ�Ƹ���)

					// �����������ƶ��е�ֽ�Ƹ���
					System.out.println("	�ƶ�����Ϊ��");
					for (int j = 0; j < heap_Count; j++) {
						System.out.println("	��" + (j + 1) + "�Ѹ�����" + cardArray[j]);
					}
					x++;

					// ��i��ֽ�Ƹ���>ƽ��ֽ�Ƹ���
				} else if (cardArray[i] > card_Ave) {
					System.out.println("��" + (x + 1) + "���ƶ���");
					System.out.println("�ӵ�" + (i + 1) + "���ƶ�����" + (i + 2) + "�ѣ��ƶ�" + (cardArray[i] - card_Ave) + "�š�");
					cardArray[i + 1] += cardArray[i] - card_Ave;// ��һ�ѵ�ֽ�Ƹ���  + (��һ�ѵ�ֽ�Ƹ���-ƽ��ֵ)
					cardArray[i] -= cardArray[i] - card_Ave;// ��һ�ѵ�ֽ�Ƹ���  - (��һ�ѵ�ֽ�Ƹ���-ƽ��ֵ)

					// �����������ƶ��е�ֽ�Ƹ���
					System.out.println("	�ƶ�����Ϊ��");
					for (int j = 0; j < heap_Count; j++) {
						System.out.println("	��" + (j + 1) + "�Ѹ�����" + cardArray[j]);
					}
					x++;

					// ��i��ֽ�Ƹ���=ƽ��ֽ�Ƹ����������´�ѭ��
				} else {
					continue;
				}

			}

			System.out.println("�ƶ��ܴ���Ϊ��" + x + "�Ρ�");
		}

	}

}
