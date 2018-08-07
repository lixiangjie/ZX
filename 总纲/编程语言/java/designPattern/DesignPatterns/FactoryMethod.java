/**
 * 設計模式之工廠模式
 * */
package DesignPatterns;

public class FactoryMethod {

	/* 1.创建实例类的共同接口Sender.java */
	
	/* 2.创建接口的实体类-MailSender.java */
	
	/* 2.创建接口的实体类-EmailSender.java */
	
	/* 3.创建工厂类 SendFactory*/
	
	/* 4.测试 */
	public static void main(String[] args){
//		SendFactory factory = new SendFactory();
//		Sender sender = factory.Produce("mail");/* 普通工厂模式测试 */
//		Sender sender2 = factory.ProduceEmail();/* 多个工厂模式测试 */
//		sender.Send();
//		sender2.Send();
		
		/* 静态工厂模式，直接调用工厂类中的静态方法创建实例 */
		Sender sender3 = SendFactory.ParoduceEmail();/* 静态工厂模式测试 */
		sender3.Send();
	}	
}
