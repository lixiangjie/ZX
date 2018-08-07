package ObserverPattern;

//实体观察者类HexaObserver.java
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
