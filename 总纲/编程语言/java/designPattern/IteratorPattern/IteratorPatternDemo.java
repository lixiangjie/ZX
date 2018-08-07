/**
 * �OӋģʽ֮������ģʽ
 * */
package IteratorPattern;

public class IteratorPatternDemo {
	//1.�����ӿ�Iterator.java, Container.java
	
	//2.����ʵ���� Container �ӿڵ�ʵ����NameRepository.java��������ʵ���� Iterator �ӿڵ��ڲ��� NameIterator��
	
	//3.ʹ�� NameRepository ����ȡ������������ӡ���֡�IteratorPatternDemo.java
	
	public static void main(String[] args){
		 NameRepository nameRepository = new NameRepository();
		 
		 for(Iterator iterator = nameRepository.getIterator(); iterator.hasNext();){
			 String name = (String) iterator.next();
			 System.out.println("Names: " + name);
		 }
	}
}
