package BuilderPattern;

//创建表示食物信息的接口
public interface Item {
	public String name();
	public Packing packing();//另一个接口类型
	public float price();
}
