/**
 * �OӋģʽ֮�н���ģʽ
 * */
package MediatorPattern;

public class MediatorPatternDemo {

	//1.�����н��ࡣChatRoom.java
	
	//2.���� user �ࡣUser.java
	
	//3.ʹ�� User ��������ʾ����֮���ͨ�š�MediatorPatternDemo.java
	
	public static void main(String[] args){
		User lxj = new User("lxj");
		User cc = new User("cc");
		
		lxj.sendMessage("lxj");
		cc.sendMessage("cc");
	}
}











