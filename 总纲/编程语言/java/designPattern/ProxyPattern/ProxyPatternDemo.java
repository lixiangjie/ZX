/**
 * 設計模式之代理模式
 * */
package ProxyPattern;

public class ProxyPatternDemo {
	
	//1.创建一个接口Image.java
	
	//2.创建实现接口的实体类RealImage.java, ProxyImage.java
	
	//3.当被请求时，使用 ProxyImage 来获取 RealImage 类的对象。
	
	public static void main(String[] args){
		Image image = new ProxyImage("test.jpg");
		
		//图片从磁盘加载
		image.display();
		
		System.out.println(" ");
		
		//图像无法从磁盘加载
		image.display();
	}
		
}












