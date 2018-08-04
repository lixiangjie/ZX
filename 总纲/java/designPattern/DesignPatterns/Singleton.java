/**
 * 設計模式之單例模式
 * */
package DesignPatterns;

public class Singleton {
	
	/* 私有构造方法，防止被实例化 */
	/* 私有之后该构造方法就只能在本类被调用，其它类无法访问，不能随意创建该对象，也就无法在这个类外创建对象，即无法被实例化 */
	private Singleton(){}
	
	/* 使用一个内部类来维护单例 */
	private static class SingleonFactory{
		private static Singleton instance = new Singleton();
	}
	
	/* 静态工程方法获取实例 */
	public static Singleton getInstance(){
		return SingleonFactory.instance;
	}
	
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
	public Object readResolve(){
		return getInstance();
	}
}
