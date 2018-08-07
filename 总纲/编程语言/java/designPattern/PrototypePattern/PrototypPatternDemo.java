/**
 * �OӋģʽ֮ԭ��ģʽ
 * */
package PrototypePattern;

public class PrototypPatternDemo {
	//1.����һ��ʵ����Clonable�ӿڵĳ�����Shape.java
	
	//2.������չ��Shape.java�������ʵ����Rectangle.java, Square.java, Circle.java

	//3.����һ����ShapeCache.java�������ݿ��ȡʵ���࣬�������Ǵ洢��һ��Hashtable�У�

	//4.PrototypePatternDemo ʹ�� ShapeCache ������ȡ�洢�� Hashtable �е���״�Ŀ�¡
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











