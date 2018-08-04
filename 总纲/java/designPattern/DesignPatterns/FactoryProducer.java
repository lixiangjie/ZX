package DesignPatterns;

/**
 * 创建工厂生成器类FactoryProducer.java，通过传递形状或颜色信息来获取抽象工厂类的实体类对象
 * */
public class FactoryProducer {
	public static AbstractFactory getFactory(String choice){
		if (choice.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory();
		}else if (choice.equalsIgnoreCase("COLOR")) {
			return new ColorFactory();
		}
		return null;
	}
}
