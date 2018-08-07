package CommandPattern;

//实现了 Order 接口的实体类。
public class SellStock implements Order{

	private Stock abcStock;
	
	public SellStock(Stock abcSrock) {
		this.abcStock = abcSrock;
	}
	
	@Override
	public void execute() {
		abcStock.sell();
	}

}
