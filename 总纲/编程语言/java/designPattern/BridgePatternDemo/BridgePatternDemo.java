/**
 * 設計模式之橋接模式
 * */
package BridgePatternDemo;

public class BridgePatternDemo {
	//1.创建桥接实现的接口DrawAPI.java
	
	//2.创建实现了 DrawAPI 接口的实体桥接实现类RedCircle.java, GreenCircle.java
	
	//3.使用 DrawAPI 接口创建抽象类 Shape.java
	
	//4.创建实现了 Shape 接口的实体类Circle.java
	
	//5.使用 Shape 和 DrawAPI 类画出不同颜色的圆BridgePatternDemo.java
	
	public static void main(String[] args){
		Shape redCircle = new Circle(100, 100, 10, new RedCircle());
		Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());
		
		redCircle.draw();
		greenCircle.draw();
		
	}
}
