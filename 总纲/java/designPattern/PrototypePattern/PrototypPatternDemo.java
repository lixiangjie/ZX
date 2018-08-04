/**
 * 設計模式之原型模式
 * */
package PrototypePattern;

public class PrototypPatternDemo {
	//1.创建一个实现了Clonable接口的抽象类Shape.java
	
	//2.创建扩展了Shape.java抽象类的实体类Rectangle.java, Square.java, Circle.java

	//3.创建一个类ShapeCache.java，从数据库获取实体类，并把它们存储在一个Hashtable中，

	//4.PrototypePatternDemo 使用 ShapeCache 类来获取存储在 Hashtable 中的形状的克隆
	public static void main(String[] args){
		ShapeCache.loadCache();
		
		Shape cloneShape = ShapeCache.getShape("1");
		System.out.println("Shape: " + cloneShape.getType());
		
		Shape cloneShape2 = ShapeCache.getShape("2");
		System.out.println("Shape: " + cloneShape2.getType());
		
		Shape cloneShape3 = ShapeCache.getShape("3");
		System.out.println("Shape: " + cloneShape3.getType());
	}
}











