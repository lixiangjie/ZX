package DesignPatterns;

/**
 * ����������������FactoryProducer.java��ͨ��������״����ɫ��Ϣ����ȡ���󹤳����ʵ�������
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
