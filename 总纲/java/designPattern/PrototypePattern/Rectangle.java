package PrototypePattern;

public class Rectangle extends Shape{

	public Rectangle() {
		// TODO 自动生成的构造函数存根
		type = "Rectangle";
	}
	
	@Override
	//重写父类的抽象方法
	void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}

}
