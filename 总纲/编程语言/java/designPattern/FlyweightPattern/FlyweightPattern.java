/**
 * �OӋģʽ֮��Ԫģʽ
 * */
package FlyweightPattern;

public class FlyweightPattern {

	//1.����һ���ӿ�Shape.java
	
	//2.����ʵ�ֽӿ�Shape.java��ʵ����Circle.java
	
	//3.�������������ɻ��ڸ�����Ϣ��ʵ����Ķ���ShapeFacory.java
	
	//4.ʹ�ù���ShapeFacory.java��ͨ��������ɫ��Ϣ����ȡʵ����Ķ���FlyweightPatternDemo.java
	
	private static final String colors[] = {"Red", "Green", "Blue", "White", "Black"};
	
	public static void main(String[] args){
		for(int i = 0; i < 20; i++){
			Circle circle = (Circle)ShapeFacory.getCircle(getRandomColor());
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			circle.setRadius(100);
			circle.draw();
		}
	}
	
	private static String getRandomColor(){
		return colors[(int) (Math.random() * colors.length)];
	}
	
	private static int getRandomX(){
		return (int) (Math.random() * 100);
	}
	
	private static int getRandomY() {
		return (int)(Math.random() * 100);
	}
}




















