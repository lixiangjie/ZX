package DivideConquerAlgorithm;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: BigIntMultiply  
 * @Description:分治算法---大整数乘法
 * 
 * 							   问题描述：
 *                           大整数乘法，就是两个乘数比较大，最后结果超过了整型甚至长整型的最大范围，此时如果需要得到精确结果，就不能常规的使用乘号直接计算。
 *                           此时需要采用分治的思想，将乘数“分割”，将大整数计算转换为小整数计算。
 * 
 *                           拼接时注意：两位数分解成一位数相乘，超过一位数，需要进位。同理，两位数乘以两位数，结果超过两位数，也要进位。
 * 
 *                           规律：
 *                           任意位数（例如N位整数相乘），都可以用这种思想实现：
 *                           低位保留N位数字串，多余高位进位（拼接时多余位数进位）；高位要加上低位进位，如果超过N位，依然只保留N位，高位进位。
 *                           （如果是M位整数乘以N位整数怎么办？高位补0，凑成一样位数的即可）
 * 
 *                           具体实现：递归 
 *                           1. 如果两个整数M和N的长度都小于等于4位数，则直接返回M*N的结果的字符串形式。
 *                           2. 如果如果M、N长度不一致，在M的高位补齐0（不妨设N>M），使之都为N位整数。 
 *                           3. N/2取整，得到整数的分割位数。将M、N拆分成m1、m2，n1，n2。 
 *                           4. 将m1、n1；m2、n1；m1、n2；m2、n2递归调用第1步，分别得到结果AC(高位)、BC(中位)、AD(中位)、BD(低位)。
 *                           5. 判断BD位是否有进位bd，并截取bd得到保留位BD'；判断BC+AD+bd是否有进位abcd，并截取进位得到保留位ABCD'；判断AC+abcd是否有进位ac，并截取进位得到保留位AC'。
 *                           6. 返回最终大整数相乘的结果：ac AC' ABCD' BD'。
 *                           
 * @author:
 * @date: 2017年6月7日 下午4:16:14
 */
public class BigIntMultiply   {
	
	//分治算法的最小規模，即當遞歸的乘數小於4后，結束遞歸，直接計算。
	private final static int SIZE=4;
	
	public static void main(String[] args){
		//正則表達式
		String pat = "^[1-9]\\d*$";
		Pattern pattern=Pattern.compile(pat);
		
		//獲得乘數A
		System.out.println("请输入乘数A（不以0开头的正整数）：");  
		Scanner scannerA = new Scanner(System.in);
		String A = scannerA.nextLine();
		Matcher matcherA = pattern.matcher(A);
		if (!matcherA.matches()) {
			System.out.println("輸入數字不合法！");
			return;
		}
		
		//獲得乘數B
		System.out.println("请输入乘数B（不以0开头的正整数）：");  
		Scanner scannerB = new Scanner(System.in);
		String B = scannerB.nextLine();
		Matcher matcherB = pattern.matcher(B);
		if (!matcherB.matches()) {
			System.out.println("輸入數字不合法！");
			return;
		}
		
		//相乘結果---Math.max選出乘數中最大的長度，作為標準補齊短的乘數
		System.out.println(A+" * "+B+"="+bigIntMultiply(A,B,Math.max(A.length(), B.length())));
	}
	
	//大整數相乘算法
	public static String bigIntMultiply(String X,String Y,int length){
		//最終返回結果
		String str="";
		
		//補齊X,Y，使之長度相同
		X=formatNumber(X,length);
		Y=formatNumber(Y,length);
		
		//少於4位數，直接計算
		if (length<=SIZE) {
			return ""+(Integer.parseInt(X)*Integer.parseInt(Y));	//前面加上    ""+  的作用是將整數轉換成字符串輸出
		}
		
		//將X,Y分別分為兩半部分
		int len1=length/2;
		int len2=length-len1;
		String A=X.substring(0,len1);	//0---len1-1
		String B=X.substring(len1);		//len1----結尾
		String C=Y.substring(0,len1);	
		String D=Y.substring(len1);		
		
		//乘法法則，分塊處理
		int lenMax=Math.max(len1, len2);
		String AC=bigIntMultiply(A, C, len1);
		String AD=bigIntMultiply(A, D, lenMax);
		String BC=bigIntMultiply(B, C, lenMax);
		String BD=bigIntMultiply(B, D, len2);
		
		//處理BD，得到原位及進位
		String[] stringBD=dealString(BD,len2);
		
		//處理AD+BC的和
		String ADBC = addition(AD,BC);
		
		//加上BD的進位
		if (!"0".equals(stringBD[1])) {
			ADBC=addition(ADBC, stringBD[1]);
		}
		
        // 得到ADBC的进位  
        String[] sADBC = dealString(ADBC, lenMax);  
  
        // AC加上ADBC的进位  
        AC = addition(AC, sADBC[1]);  
  
        // 最终结果  
        str = AC + sADBC[0] + stringBD[0];  
		
		
		return str;
	}

	//兩個字符串按位相加
	private static String addition(String ad, String bc) {
		//返回的結果
		String string="";
		
		//調整兩字符串的長度，使其相同
		int lenM=Math.max(ad.length(), bc.length());
		ad = formatNumber(ad, lenM);
		bc = formatNumber(bc, lenM);
		
		//按位相加，進位存儲在temp中
		int flag=0;
		
		//從後往前按位求和
		for(int i=lenM-1;i>=0;i--){
			int t=flag+Integer.parseInt(ad.substring(i, i+1))+Integer.parseInt(bc.substring(i, i+1));
			
			//相加結果大於9，則進位當前位，保留個位數
			if (t>9) {
				flag=1;
				t=t-10;
			}else {
				flag=0;
			}
			
			//拼接當前位（不含進位）的結果字符串
			string = ""+t+string;
		}
		
		//拼接最終結果（含進位）的結果字符串
		if (flag!=0) {
			string=""+flag+string;
		}
		return string;
	}

	//處理字符串，分離出進位；string數組第一個為原位數字，第二個為進位。
	//str--分塊後的字符串；len--分塊后的長度
	private static String[] dealString(String str, int len) {
		//返回的結果
		String[] strings = {str,"0"};
		
		//相乘結果的長度大於之前   乘數、被乘數   的長度，即存在進位
		if (len<str.length()) {
			int t=str.length()-len;	//數字相乘之後的結果與   乘數、被乘數   長度的差值，即進位的長度。
			strings[0]=str.substring(t);	//從t往後即為相乘結果后的原位數字
			strings[1]=str.substring(0, t);	//從0到t即為相乘結果后的進位
		}else {
			
			//要保证结果的length与入参的len一致，少于则高位补0。 例如01*01=1，在結果1的高位補0，保證結果長度一直
			String result = strings[0];
			for(int i=result.length();i<len;i++){
				result="0"+result;
			}
			strings[0]=result;	//將結果賦值給數組的第一位（原位數字）
		}
		return strings;
	}

	//乘數、被乘數位數補齊
	private static String formatNumber(String x, int length) {
		//位數前加"0"
		while(x.length()<length){
			x="0"+x;
		}
		return x;
	}
	
	
	
	
}

























