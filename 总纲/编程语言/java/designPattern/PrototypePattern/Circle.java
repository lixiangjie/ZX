package PrototypePattern;

public class Circle extends Shape{

	public Circle() {
		// TODO �Զ����ɵĹ��캯�����
		type = "Circle";
	}
	
	@Override
	void draw() {
		// TODO �Զ����ɵķ������
		System.out.println("Inside Square::draw() method.");
	}

}
