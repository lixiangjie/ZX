package DesignPatterns;

/* ���������࣬���ɻ��ڸ�����Ϣ��ʵ������� */
public class SendFactory {
	
	/* ��ͨ����ģʽ */
	/* ������ʵ�������ķ�������Ϊ�ӿ�����Sender */
	public Sender Produce(String type){
		if ("mail".equals(type)) {
			return new MailSender();
		}else if ("email".equals(type)) {
			return new EmailSender();
		}else {
			System.out.println("��������ȷ������");
			return null;
		}
	}
	
	/* �������ģʽ */
//	public Sender ProduceMail(){
//		return new MailSender();
//	}
//	public Sender ProduceEmail(){
//		return new EmailSender();
//	}
	
	/* ��̬����ģʽ */
	public static Sender ProduceMail(){
		return new MailSender();
	}
	public static Sender ParoduceEmail(){
		return new EmailSender();
	}
}
