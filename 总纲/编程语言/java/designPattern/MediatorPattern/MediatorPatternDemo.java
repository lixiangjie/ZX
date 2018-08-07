/**
 * 設計模式之中介者模式
 * */
package MediatorPattern;

public class MediatorPatternDemo {

	//1.创建中介类。ChatRoom.java
	
	//2.创建 user 类。User.java
	
	//3.使用 User 对象来显示他们之间的通信。MediatorPatternDemo.java
	
	public static void main(String[] args){
		User lxj = new User("lxj");
		User cc = new User("cc");
		
		lxj.sendMessage("lxj");
		cc.sendMessage("cc");
	}
}











