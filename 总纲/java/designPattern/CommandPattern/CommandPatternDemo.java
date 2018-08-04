/**
 * �OӋģʽ֮����ģʽ
 * */
package CommandPattern;

public class CommandPatternDemo {

	//1.����һ������ӿڡ�Order.java
	
	//2.����һ�������ࡣStock.java
	
	//3.����ʵ���� Order �ӿڵ�ʵ���ࡣBuyStock.java, SellStock.java
	
	//4.������������ࡣBroker.java
	
	public static void main(String[] args){
		Stock abcStock = new Stock();
		
		BuyStock buyStockOrder = new BuyStock(abcStock);
		SellStock sellStockOrder = new SellStock(abcStock);
		
		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);
		
		broker.placeOrders();
	}
}
