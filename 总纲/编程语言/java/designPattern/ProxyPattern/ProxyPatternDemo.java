/**
 * �OӋģʽ֮����ģʽ
 * */
package ProxyPattern;

public class ProxyPatternDemo {
	
	//1.����һ���ӿ�Image.java
	
	//2.����ʵ�ֽӿڵ�ʵ����RealImage.java, ProxyImage.java
	
	//3.��������ʱ��ʹ�� ProxyImage ����ȡ RealImage ��Ķ���
	
	public static void main(String[] args){
		Image image = new ProxyImage("test.jpg");
		
		//ͼƬ�Ӵ��̼���
		image.display();
		
		System.out.println(" ");
		
		//ͼ���޷��Ӵ��̼���
		image.display();
	}
		
}












