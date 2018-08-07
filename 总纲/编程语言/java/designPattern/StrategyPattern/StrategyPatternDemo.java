/**
 * �OӋģʽ֮����ģʽ
 * */
package StrategyPattern;

public class StrategyPatternDemo {

	//1.�����ӿ�Strategy.java
	
	//2.�����ӿ�Strategy.java�ľ���ʵ����OperationAdd.java, OperationSubstract.java, OperationMultiply.java
	
	//3.������ Context.java
	
	//4.ʹ�� Context���鿴�����ı���� Strategyʱ����Ϊ�仯��StrategyPatternDemo.java
	
	public static void main(String[] args){
		int num1 = 10;
		int num2 = 5;
		
		Context context = new Context(new OperationAdd());
		System.out.println("10 + 5 = " + context.executeStrategy(num1, num2));
		
		context = new Context(new OperationSubstract());
		System.out.println("10 - 5 = " + context.executeStrategy(num1, num2));
		
		context = new Context(new OperationMultiply());
		System.out.println("10 * 5 = " + context.executeStrategy(num1, num2));
	}
	
}
