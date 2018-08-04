/**
 * 設計模式之享元模式
 * */
package FlyweightPattern;

public class FlyweightPattern {

	//1.创建一个接口Shape.java
	
	//2.创建实现接口Shape.java的实体类Circle.java
	
	//3.创建工厂，生成基于给定信息的实体类的对象ShapeFacory.java
	
	//4.使用工厂ShapeFacory.java，通过传递颜色信息来获取实体类的对象。FlyweightPatternDemo.java
	
	private static final String colors[] = {"Red", "Green", "Blue", "White", "Black"};
	
	public static void main(String[] args){
		for(int i = 0; i < 20; i++){
			Circle circle = (Circle)ShapeFacory.getCircle(getRandomColor());
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			circle.setRadius(100);
			circle.draw();
		}
	}
	
	private static String getRandomColor(){
		return colors[(int) (Math.random() * colors.length)];
	}
	
	private static int getRandomX(){
		return (int) (Math.random() * 100);
	}
	
	private static int getRandomY() {
		return (int)(Math.random() * 100);
	}
}




















