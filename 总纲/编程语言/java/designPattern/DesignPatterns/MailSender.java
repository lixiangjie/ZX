package DesignPatterns;

/* ����ģʽ����Sender�ӿڵ�ʵ����MailSender */
public class MailSender implements Sender{
	@Override
	public void Send() {
		System.out.println("this is mail sender!");			
	}	
}
