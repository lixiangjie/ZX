package DesignPatterns;

/* 创建工厂类，生成基于给定信息的实体类对象 */
public class SendFactory {
	
	/* 普通工厂模式 */
	/* 创建的实体类对象的返回类型为接口类型Sender */
	public Sender Produce(String type){
		if ("mail".equals(type)) {
			return new MailSender();
		}else if ("email".equals(type)) {
			return new EmailSender();
		}else {
			System.out.println("请输入正确的类型");
			return null;
		}
	}
	
	/* 多个工厂模式 */
//	public Sender ProduceMail(){
//		return new MailSender();
//	}
//	public Sender ProduceEmail(){
//		return new EmailSender();
//	}
	
	/* 静态工厂模式 */
	public static Sender ProduceMail(){
		return new MailSender();
	}
	public static Sender ParoduceEmail(){
		return new EmailSender();
	}
}
