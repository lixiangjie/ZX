/**
 * 設計模式之命令模式
 * */
package CommandPattern;

public class CommandPatternDemo {

	//1.创建一个命令接口。Order.java
	
	//2.创建一个请求类。Stock.java
	
	//3.创建实现了 Order 接口的实体类。BuyStock.java, SellStock.java
	
	//4.创建命令调用类。Broker.java
	
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
