package DesignPatterns;
/**
 * ������չAbstractoryFactory�Ĺ�����ColorFactory.java
 * */
public class ColorFactory extends AbstractFactory {

	@Override
	Color getColor(String colorType) {
		if (colorType == null) {
			return null;
		}
		if (colorType.equalsIgnoreCase("RED")) {
			return new Red();
		}else if (colorType.equalsIgnoreCase("GREEN")) {
			return new Green();
		}else if (colorType.equalsIgnoreCase("BLUE")) {
			return new Blue();
		}
		return null;
	}

	@Override
	Shape getShape(String shape) {
		// TODO �Զ����ɵķ������
		return null;
	}
	
}
