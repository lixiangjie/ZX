package BridgePatternDemo;

//����ʵ���� DrawAPI �ӿڵ�ʵ���Ž�ʵ����RedCircle.java
public class RedCircle implements DrawAPI{

	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: red, radius: "
		         + radius +", x: " +x+", y: "+ y +"]");
	}
	
}
