package CommandPattern;

//ʵ���� Order �ӿڵ�ʵ���ࡣ
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
