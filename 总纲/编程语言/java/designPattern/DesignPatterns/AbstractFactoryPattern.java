/**
 * �OӋģʽ֮���󹤏Sģʽ
 * */
package DesignPatterns;

public class AbstractFactoryPattern {
	//1.Ϊ��״����һ���ӿ�Shape.java
	
	//2.����ʵ��Shape.java�ӿڵ�ʵ����Rectangle.java, Square.java, Circle.java

	//3.Ϊ��״����һ���ӿ�Color.java
	
	//4.����ʵ��Color.java�ӿڵ�ʵ����Red.java, Green.java, Blue.java

	//5.Ϊcolor��shape���󴴽����󹤳���AbstractoryFactory.java
	
	//6.������չAbstractoryFactory�Ĺ�����ShapeFactory.java��ColorFactory.java�����ڸ�������Ϣ����ʵ�������
	
	//7.����������������FactoryProducer.java��ͨ��������״����ɫ��Ϣ����ȡ����
	
	//8.ʹ�ù�����������FactoryProducer��ȡAbstractFactory��ͨ������������Ϣ��ȡʵ����Ķ���
	public static void main(String[] args){
		
		//һ����ȡ��״����
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		
		//1.��ȡ��״Ϊcircle�Ķ���
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		
		//����shape1��draw()����
		shape1.draw();
		
		//2.��ȡ��״Ϊrectangle�Ķ���
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		
		//����shape2��draw()����
		shape2.draw();
		
		//3.��ȡ��״ΪSQUARE�Ķ���
		Shape shape3 = shapeFactory.getShape("SQUARE");
		
		//����shape3��draw()����
		shape3.draw();		
		
		//������ȡ��ɫ����
		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
		
		//1.��ȡ��ɫΪred�Ķ���
		Color color1 = colorFactory.getColor("RED");
		
		//����red��fill����
		color1.fill();
		
		//2.��ȡ��ɫΪgreen�Ķ���
		Color color2 = colorFactory.getColor("GREEN");
		
		//����green��fill����
		color2.fill();
		
		//3.��ȡ��ɫΪblue�Ķ���
		Color color3 = colorFactory.getColor("BLUE");
		
		//����blue��fill����
		color3.fill();
	}

}
