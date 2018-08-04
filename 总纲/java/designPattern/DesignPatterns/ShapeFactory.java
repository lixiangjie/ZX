package DesignPatterns;
/**
 * ������չAbstractoryFactory�Ĺ�����ShapeFactory.java
 * */
public class ShapeFactory extends AbstractFactory {

	@Override
	//��дAbstractoryFactory�������еķ���
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) { //equalsIgnoreCase�ַ����Ƚϣ����Դ�Сд
			return new Circle();
		}else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		}else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}
	
	@Override
	Color getColor(String color) {
		// TODO �Զ����ɵķ������
		return null;
	}

}
