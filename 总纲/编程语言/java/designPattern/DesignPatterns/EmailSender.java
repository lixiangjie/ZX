package DesignPatterns;

/* ����ģʽ����Sender�ӿڵ�ʵ����EmailSender */
public class EmailSender implements Sender{
	@Override
	public void Send() {
		System.out.println("this is email sender!");
	}
} 
