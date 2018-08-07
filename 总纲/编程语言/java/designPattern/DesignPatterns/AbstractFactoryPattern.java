/**
 * 設計模式之抽象工廠模式
 * */
package DesignPatterns;

public class AbstractFactoryPattern {
	//1.为形状创建一个接口Shape.java
	
	//2.创建实现Shape.java接口的实体类Rectangle.java, Square.java, Circle.java

	//3.为形状创建一个接口Color.java
	
	//4.创建实现Color.java接口的实体类Red.java, Green.java, Blue.java

	//5.为color和shape对象创建抽象工厂类AbstractoryFactory.java
	
	//6.创建扩展AbstractoryFactory的工厂类ShapeFactory.java和ColorFactory.java，基于给定的信息生成实体类对象
	
	//7.创建工厂生成器类FactoryProducer.java，通过传递形状或颜色信息来获取工厂
	
	//8.使用工厂生成器类FactoryProducer获取AbstractFactory，通过传递类型信息获取实体类的对象
	public static void main(String[] args){
		
		//一、获取形状工厂
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		
		//1.获取形状为circle的对象
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		
		//调用shape1的draw()方法
		shape1.draw();
		
		//2.获取形状为rectangle的对象
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		
		//调用shape2的draw()方法
		shape2.draw();
		
		//3.获取形状为SQUARE的对象
		Shape shape3 = shapeFactory.getShape("SQUARE");
		
		//调用shape3的draw()方法
		shape3.draw();		
		
		//二、获取颜色工厂
		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
		
		//1.获取颜色为red的对象
		Color color1 = colorFactory.getColor("RED");
		
		//调用red的fill方法
		color1.fill();
		
		//2.获取颜色为green的对象
		Color color2 = colorFactory.getColor("GREEN");
		
		//调用green的fill方法
		color2.fill();
		
		//3.获取颜色为blue的对象
		Color color3 = colorFactory.getColor("BLUE");
		
		//调用blue的fill方法
		color3.fill();
	}

}
