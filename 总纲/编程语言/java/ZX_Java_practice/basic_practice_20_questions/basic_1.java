// 编写程序实现对给定的 4个整数从大到小的顺序排列

/* 一、审题
 * 1. 带有顺序的数据结构   ArrayList存入数字
 * 2. 比较排序
 * 3. 量多的情况，考虑时间复杂度和空间复杂度
 * 
 * 二、IPO
 * input：输入的数字
 * process：排序算法
 * output：数字按照从大到小输出
 * 
 * 三、原则
 * 1. 一个函数只完成一个功能
 * 2. 命名问题
 * 
 * */

package basic_practice_20_questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class basic_1 {
	public static void main(String[] args) {
		ArrayList<Integer> numList = getInputNum();
		numCompare(numList);
		printNumOrderRes(numList);
	}
	
	// 获取输入数字
	public static ArrayList<Integer> getInputNum() {
		Scanner num_scan = new Scanner(System.in);
		ArrayList<Integer> numList = new ArrayList<>();		// !
		while (num_scan.hasNextInt()) {
			int num = num_scan.nextInt();
			if (String.valueOf(num) == " ") {              	// !
				break;
			}
			numList.add(num);
		}
		return numList;
	}
		
	// 比较数字
	public static void numCompare(ArrayList<Integer> num) {
		Collections.sort(num);
	}
	
	// 输出结果
	public static void printNumOrderRes(ArrayList<Integer> num) {
		for (int i = 0; i < num.size(); i++) {
			System.out.print(num.get(i) + " ");
		}
	}
	
}













