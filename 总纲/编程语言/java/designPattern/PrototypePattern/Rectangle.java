package PrototypePattern;

public class Rectangle extends Shape{

	public Rectangle() {
		// TODO �Զ����ɵĹ��캯�����
		type = "Rectangle";
	}
	
	@Override
	//��д����ĳ��󷽷�
	void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}

}
