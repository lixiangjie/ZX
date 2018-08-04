/**
 * 設計模式之觀察者模式
 * */
package ObserverPattern;

public class ObserverPatternDemo {

	// 1.创建类Observer.java

	// 2.创建类Subject.java

	// 3.创建实体观察者类BinaryObserver.java, OctalObserver.java, HexaObserver.java

	// 4.使用 Subject 和实体观察者对象。ObserverPatternDemo.java

	public static void main(String[] args) {
		Subject subject = new Subject();

		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15);

		System.out.println("First state change: 10");
		subject.setState(10);

	}

}
