/**
 * �OӋģʽ֮���ģʽ
 * */
package BridgePatternDemo;

public class BridgePatternDemo {
	//1.�����Ž�ʵ�ֵĽӿ�DrawAPI.java
	
	//2.����ʵ���� DrawAPI �ӿڵ�ʵ���Ž�ʵ����RedCircle.java, GreenCircle.java
	
	//3.ʹ�� DrawAPI �ӿڴ��������� Shape.java
	
	//4.����ʵ���� Shape �ӿڵ�ʵ����Circle.java
	
	//5.ʹ�� Shape �� DrawAPI �໭����ͬ��ɫ��ԲBridgePatternDemo.java
	
	public static void main(String[] args){
		Shape redCircle = new Circle(100, 100, 10, new RedCircle());
		Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());
		
		redCircle.draw();
		greenCircle.draw();
		
	}
}
