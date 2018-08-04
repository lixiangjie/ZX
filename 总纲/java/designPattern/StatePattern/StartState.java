package StatePattern;

//实现接口的实体类
public class StartState implements State{

	@Override
	public void doAction(Context context) {
		System.out.println("Player is in start state");
		context.setState(this);
	}

	public String toString(){
		return "Start State";
	}
}
