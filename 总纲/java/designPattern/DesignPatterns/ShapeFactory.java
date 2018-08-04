package DesignPatterns;
/**
 * 创建扩展AbstractoryFactory的工厂类ShapeFactory.java
 * */
public class ShapeFactory extends AbstractFactory {

	@Override
	//重写AbstractoryFactory抽象类中的方法
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) { //equalsIgnoreCase字符串比较，忽略大小写
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
		// TODO 自动生成的方法存根
		return null;
	}

}
