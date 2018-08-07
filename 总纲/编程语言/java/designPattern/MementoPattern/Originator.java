package MementoPattern;

import java.awt.Menu;

public class Originator {
	private String state;
	
	public void setState(String state){
		this.state = state;
	}
	
	public String getState(){
		return state;
	}
	
	public Memento savaStateToMemento(){
		return new Memento(state);
	}
	
	public void getStateFromMemento(Memento Memento){
		state = Memento.getState();
	}
}










