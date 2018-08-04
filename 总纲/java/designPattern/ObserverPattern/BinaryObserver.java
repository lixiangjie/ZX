package ObserverPattern;

//ʵ��۲�����BinaryObserver.java
public class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary String: " + Integer.toHexString(subject.getState()).toUpperCase());

	}

}
