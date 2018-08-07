package DesignPatterns;

/* 工厂模式创建Sender接口的实体类MailSender */
public class MailSender implements Sender{
	@Override
	public void Send() {
		System.out.println("this is mail sender!");			
	}	
}
