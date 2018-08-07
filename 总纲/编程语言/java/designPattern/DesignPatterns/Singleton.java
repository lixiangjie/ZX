/**
 * �OӋģʽ֮����ģʽ
 * */
package DesignPatterns;

public class Singleton {
	
	/* ˽�й��췽������ֹ��ʵ���� */
	/* ˽��֮��ù��췽����ֻ���ڱ��౻���ã��������޷����ʣ��������ⴴ���ö���Ҳ���޷���������ⴴ�����󣬼��޷���ʵ���� */
	private Singleton(){}
	
	/* ʹ��һ���ڲ�����ά������ */
	private static class SingleonFactory{
		private static Singleton instance = new Singleton();
	}
	
	/* ��̬���̷�����ȡʵ�� */
	public static Singleton getInstance(){
		return SingleonFactory.instance;
	}
	
	/* ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ�� */  
	public Object readResolve(){
		return getInstance();
	}
}
