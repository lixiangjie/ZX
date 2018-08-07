package DesignPatterns;

/* 工厂模式创建Sender接口的实体类EmailSender */
public class EmailSender implements Sender{
	@Override
	public void Send() {
		System.out.println("this is email sender!");
	}
} 
