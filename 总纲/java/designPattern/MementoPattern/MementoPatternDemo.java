/**
 * 設計模式之備忘錄模式
 * */
package MementoPattern;

public class MementoPatternDemo {

	//1.创建 Memento 类。Memento.java
	
	//2.创建 Originator 类。Originator.java
	
	//3.创建 CareTaker 类。CareTaker.java
	
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



