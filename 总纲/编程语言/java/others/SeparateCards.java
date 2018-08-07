
import java.util.Scanner;

/**
 * @ClassName: SeparateCards
 * @Description: 贪心算法---均分纸牌
 * 
 *               问题描述：
 *               有N堆纸牌，编号分别为1，2，…，n。每堆上有若干张,但纸牌总数必为n的倍数.可以在任一堆上取若干张纸牌,然后移动。
 *               移牌的规则为：在编号为1上取的纸牌，只能移到编号为2的堆上；在编号为n的堆上取的纸牌，只能移到编号为n-1的堆上；其他堆上取的纸牌，可以移到相邻左边或右边的堆上。
 *               现在要求找出一种移动方法，用最少的移动次数使每堆上纸牌数都一样多。 例如：n=4，4堆纸牌分别为： ① 9 ② 8 ③ 17
 *               ④ 6 移动三次可以达到目的：从③取4张牌放到④，再从③区3张放到②，然后从②去1张放到①。
 * 
 *               问题分析： 如heap_Count=3，三堆纸牌数为1 2 27
 *               ，这时card_Ave=10，为了使第一堆为10，要从第二堆移9张到第一堆，而第二堆只有2张可以移，这是不是意味着刚才使用贪心法是错误的呢？
 *               我们继续按规则分析移牌过程，从第二堆移出9张到第一堆后，第一堆有10张，第二堆剩下-7张，在从第三堆移动17张到第二堆，刚好三堆纸牌都是10，最后结果是对的，
 *               我们在移动过程中，只是改变了移动的顺序，而移动次数不便，因此此题使用贪心法可行的。
 * 
 *               算法设计与实现： 设a[i]为第I堆纸牌的张数（0<=I<=n），Ave为均分后每堆纸牌的张数，s为最小移动次数。
 *               我们用贪心算法，按照从左到右的顺序移动纸牌。如第I堆的纸牌数不等于平均值，则移动一次（即s加1），分两种情况移动：
 *               1．若a[i]>Ave，则将a[i]-Ave张从第I堆移动到第I+1堆；
 *               2．若a[i]<Ave，则将Ave-a[i]张从第I+1堆移动到第I堆。
 *               为了设计的方便，我们把这两种情况统一看作是将a[i]-Ave从第I堆移动到第I+1堆，移动后有a[i]=Ave;
 *               a[I+1]=a[I+1]+a[i]-Ave.
 *               在从第I+1堆取出纸牌补充第I堆的过程中可能回出现第I+1堆的纸牌小于零的情况。
 * 
 * @author:
 * @date: 2017年6月20日 下午7:26:13
 */
public class SeparateCards {
	public static void main(String[] args) {
		separateCards();
	}

	// 均分纸牌算法
	public static void separateCards() {

		int x = 0;// 记录移动次数

		// 纸牌堆数heap_Count
		System.out.println("输入纸牌堆树：");
		Scanner in = new Scanner(System.in);
		int heap_Count = in.nextInt();

		// 每堆纸牌的个数cardArray[i]
		System.out.println("分别输入" + heap_Count + "堆纸牌的个数：");
		int[] cardArray = new int[heap_Count];
		for (int i = 0; i < heap_Count; i++) {
			cardArray[i] = in.nextInt();// 从已有的scanner中读取接下来输入的数字
		}

		// 获取纸牌总数
		int card_Sum = 0;
		for (int i = 0; i < cardArray.length; i++) {
			card_Sum += cardArray[i];
		}

		// 每堆纸牌平均个数
		int card_Ave = card_Sum / heap_Count;

		// 对每一堆纸牌的数量均分
		if (card_Sum % heap_Count != 0) {
			System.out.println("纸牌总数不是牌堆的倍数！");
		} else {
			for (int i = 0; i < cardArray.length - 1; i++) {

				// //简单直接判断移动过程
				// //强制将a[i]-v从第I堆移动到第I+1堆
				// if (cardArray[i]-card_Ave!=0) {
				// cardArray[i+1]=cardArray[i+1]+cardArray[i]-card_Ave;
				// x++;
				// }

				// 分别判断移动过程
				// 第i堆纸牌个数<平均纸牌个数
				if (cardArray[i] < card_Ave) {
					
					// 记录移动次数x来判定第几次移动，只显示发生改变的那一次的移动情况，其余次数没改变时，不显示移动情况
					System.out.println("第" + (x + 1) + "次移动：");
					
					
					System.out.println("    从第" + (i + 2) + "堆移动至第" + (i + 1) + "堆，移动" + (card_Ave - cardArray[i]) + "张。");
					cardArray[i + 1] -= card_Ave - cardArray[i];// 后一堆的纸牌个数 -(平均值-上一堆的纸牌个数)
					cardArray[i] += card_Ave - cardArray[i];// 上一堆纸牌个数+(平均值-上一堆的纸牌个数)

					// 单独遍历当牌堆中的纸牌个数
					System.out.println("	移动后结果为：");
					for (int j = 0; j < heap_Count; j++) {
						System.out.println("	第" + (j + 1) + "堆个数：" + cardArray[j]);
					}
					x++;

					// 第i堆纸牌个数>平均纸牌个数
				} else if (cardArray[i] > card_Ave) {
					System.out.println("第" + (x + 1) + "次移动：");
					System.out.println("从第" + (i + 1) + "堆移动至第" + (i + 2) + "堆，移动" + (cardArray[i] - card_Ave) + "张。");
					cardArray[i + 1] += cardArray[i] - card_Ave;// 后一堆的纸牌个数  + (上一堆的纸牌个数-平均值)
					cardArray[i] -= cardArray[i] - card_Ave;// 上一堆的纸牌个数  - (上一堆的纸牌个数-平均值)

					// 单独遍历当牌堆中的纸牌个数
					System.out.println("	移动后结果为：");
					for (int j = 0; j < heap_Count; j++) {
						System.out.println("	第" + (j + 1) + "堆个数：" + cardArray[j]);
					}
					x++;

					// 第i堆纸牌个数=平均纸牌个数，继续下次循环
				} else {
					continue;
				}

			}

			System.out.println("移动总次数为：" + x + "次。");
		}

	}

}