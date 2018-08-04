package BuilderPattern;

//创建扩展了ColdDrink的实体类Coke
public class Coke extends ColdDrink{

	@Override
	public String name() {
		// TODO 自动生成的方法存根
		return "Coke";
	}

	@Override
	public float price() {
		// TODO 自动生成的方法存根
		return 30.0f;
	}
	
}
