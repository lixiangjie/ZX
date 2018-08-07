package BuilderPattern;

//创建实现 Item接口的抽象类ColdDrink
public abstract class ColdDrink implements Item{
	
	@Override
	public Packing packing(){
		return new Bottle(); //包含实体类Bottle.java，即返回使用的包装类
	}
	
	@Override
	public abstract float price();
}
