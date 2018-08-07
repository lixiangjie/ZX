package BuilderPattern;

//创建扩展了Burger的实体类VegBurger
public class VegBurger extends Burger{

	@Override
	public String name() {
		// TODO 自动生成的方法存根
		return "Veg Burger";
	}

	@Override
	public float price() {
		// TODO 自动生成的方法存根
		return 25.0f;
	}
	
}
