/**
 * 設計模式之策略模式
 * */
package StrategyPattern;

public class StrategyPatternDemo {

	//1.创建接口Strategy.java
	
	//2.创建接口Strategy.java的具体实现类OperationAdd.java, OperationSubstract.java, OperationMultiply.java
	
	//3.创建类 Context.java
	
	//4.使用 Context来查看当它改变策略 Strategy时的行为变化。StrategyPatternDemo.java
	
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
