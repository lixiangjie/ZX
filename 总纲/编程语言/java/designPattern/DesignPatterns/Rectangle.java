package DesignPatterns;

public class Rectangle implements Shape {
	
	@Override //@Override��ʾ��������ּ�ڸ��ǻ�ʵ�ֳ������еķ��������� 
	public void draw(){
		System.out.println("Inside Rectangle::draw() method.");
	}
}
