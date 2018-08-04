/**
 * 設計模式之狀態模式
 * */
package StatePattern;

public class StatePatternDemo {

	//1.创建一个接口。State.java
	
	//2.创建实现接口的实体类。StartState.java, StopState.java
	
	//3.创建 Context 类。Context.java
	
	//4.使用 Context 来查看当状态 State 改变时的行为变化。StatePatternDemo.java
	
	public static void main(String[] args){
		Context context = new Context();
		
		StartState startState = new StartState();
		startState.doAction(context);
		
		System.out.println(context.getState().toString());
		
		StopState stopState = new StopState();
		stopState.doAction(context);
		
		System.out.println(context.getState().toString());
	}
}











