package DesignPatterns;

public class Rectangle implements Shape {
	
	@Override //@Override表示方法声明旨在覆盖或实现超类型中的方法声明。 
	public void draw(){
		System.out.println("Inside Rectangle::draw() method.");
	}
}
