/**
 * �OӋģʽ֮���Sģʽ
 * */
package DesignPatterns;

public class FactoryMethod {

	/* 1.����ʵ����Ĺ�ͬ�ӿ�Sender.java */
	
	/* 2.�����ӿڵ�ʵ����-MailSender.java */
	
	/* 2.�����ӿڵ�ʵ����-EmailSender.java */
	
	/* 3.���������� SendFactory*/
	
	/* 4.���� */
	public static void main(String[] args){
//		SendFactory factory = new SendFactory();
//		Sender sender = factory.Produce("mail");/* ��ͨ����ģʽ���� */
//		Sender sender2 = factory.ProduceEmail();/* �������ģʽ���� */
//		sender.Send();
//		sender2.Send();
		
		/* ��̬����ģʽ��ֱ�ӵ��ù������еľ�̬��������ʵ�� */
		Sender sender3 = SendFactory.ParoduceEmail();/* ��̬����ģʽ���� */
		sender3.Send();
	}	
}
