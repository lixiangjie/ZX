/**
 * �OӋģʽ֮�����ģʽ
 * */
package MementoPattern;

public class MementoPatternDemo {

	//1.���� Memento �ࡣMemento.java
	
	//2.���� Originator �ࡣOriginator.java
	
	//3.���� CareTaker �ࡣCareTaker.java
	
	public static void main(String[] args){
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
		
		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.savaStateToMemento());
		originator.setState("State #3");
		careTaker.add(originator.savaStateToMemento());
		originator.setState("State #4");
		
		System.out.println("Current State" + originator.getState());
		originator.getStateFromMemento(careTaker.get(0));
		System.out.println("First saved State" + originator.getState());
		originator.getStateFromMemento(careTaker.get(1));
		System.out.println("Second saved State" + originator.getState());
	}
}



