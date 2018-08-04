package StatePattern;

//实现接口的实体类
public class StopState implements State{

	@Override
	public void doAction(Context context) {
		System.out.println("Player is in stop state");
		context.setState(this);
	}
	
	public String toString(){
		return "Stop State";
	}
}
