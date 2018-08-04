package BuilderPattern;

//创建扩展了ColdDrink的实体类Pepsi
public class Pepsi extends ColdDrink{

	@Override
	public String name() {
		// TODO 自动生成的方法存根
		return "Pepsi";
	}

	@Override
	public float price() {
		// TODO 自动生成的方法存根
		return 35.0f;
	}

}
