package BridgePatternDemo;

//ʹ�� DrawAPI �ӿڴ��������� Shape.java
public abstract class Shape {
	protected DrawAPI drawAPI;
	protected Shape(DrawAPI drawAPI){
		this.drawAPI = drawAPI;
	}
	public abstract void draw();
}
