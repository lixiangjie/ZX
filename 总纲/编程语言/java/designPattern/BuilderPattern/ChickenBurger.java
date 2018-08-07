package BuilderPattern;

//创建扩展了Burger的实体类ChickenBurger
public class ChickenBurger extends Burger{

	@Override
	public String name() {
		// TODO 自动生成的方法存根
		return "Chicken Burger";
	}

	@Override
	public float price() {
		// TODO 自动生成的方法存根
		return 50.5f;
	}

}
