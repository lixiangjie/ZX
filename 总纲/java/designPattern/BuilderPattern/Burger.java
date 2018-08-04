package BuilderPattern;

//创建实现 Item接口的抽象类Burger
public abstract class Burger implements Item{
	
	@Override
	public Packing packing(){
		return new Wrapper(); //包含实体类Wrapper，即返回使用的包装类
	}
	
	@Override
	public abstract float price();

}
