/**
 * �OӋģʽ֮��Bģʽ
 * */
package StatePattern;

public class StatePatternDemo {

	//1.����һ���ӿڡ�State.java
	
	//2.����ʵ�ֽӿڵ�ʵ���ࡣStartState.java, StopState.java
	
	//3.���� Context �ࡣContext.java
	
	//4.ʹ�� Context ���鿴��״̬ State �ı�ʱ����Ϊ�仯��StatePatternDemo.java
	
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











