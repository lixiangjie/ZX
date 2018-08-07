package ObserverPattern;

//ʵ��۲�����HexaObserver.java
public class HexaObserver extends Observer {

	public HexaObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	
	@Override
	public void update() {
		System.out.println("Hex String: " + Integer.toBinaryString(subject.getState()));
	}

}
