/**
 * @ClassName: Java20170523
 * @Description: Jaca并发之生产者消费者模型
 * @author:
 * @date: 2017年5月23日 下午6:29:15  
 */
public class ProducerConsumerModel {
	public static void main(String[] args) {
		WareHouse wareHouse = new WareHouse();
		Producer producer = new Producer(wareHouse);
		Consumer consumer = new Consumer(wareHouse);
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}

/**
 * @ClassName: WareHouse
 * @Description: 仓库类
 * @author:
 * @date: 2017年5月23日 下午6:29:40  
 */
class WareHouse {
	private static final int STORE_SIZE = 10;
	private String[] storeProducts = new String[STORE_SIZE];
	private int index = 0;

	/*
	* @Description: 生产商品
	* @Title: pushProduct 
	* @param product
	* @return_type: void
	* @throws:
	*/
	public void pushProduct(String product) {
		synchronized (this) {
			while (index == STORE_SIZE) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			storeProducts[index++] = product;
			
			//唤醒正在等待对象监视器的单个线程
			this.notify();
			
			System.out.println("生产了: " + product + " , 目前仓库里共: " + index + " 个货物");
		}
	}

	/*
	* @Description: 消费商品
	* @Title: getProduct 
	* @return
	* @return_type: String
	* @throws:
	*/
	public synchronized String getProduct() {
		synchronized (this) {
			while (index == 0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			String product = storeProducts[index - 1];
			index--;
			System.out.println("消费了: " + product + ", 目前仓库里共: " + index + " 个货物");
			
			//唤醒正在等待对象监视器的单个线程
			this.notify();
			
			return product;
		}
	}
}

/**
 * @ClassName: Producer
 * @Description: TODO
 * @author:
 * @date: 2017年5月23日 下午6:37:03  
 */
class Producer implements Runnable {
	WareHouse wareHouse;

	public Producer(WareHouse wh) {
		this.wareHouse = wh;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			String product = "product" + i;
			
			//生产者生产商品
			this.wareHouse.pushProduct(product);
		}
	}
}

/**
 * @ClassName: Consumer
 * @Description: TODO
 * @author:
 * @date: 2017年5月23日 下午6:37:18  
 */
class Consumer implements Runnable {
	WareHouse wareHouse;

	public Consumer(WareHouse wh) {
		this.wareHouse = wh;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			
			//消费者消费商品
			this.wareHouse.getProduct();
		}
	}
}