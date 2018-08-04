/**
 * �OӋģʽ֮�^����ģʽ
 * */
package ObserverPattern;

public class ObserverPatternDemo {

	// 1.������Observer.java

	// 2.������Subject.java

	// 3.����ʵ��۲�����BinaryObserver.java, OctalObserver.java, HexaObserver.java

	// 4.ʹ�� Subject ��ʵ��۲��߶���ObserverPatternDemo.java

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
