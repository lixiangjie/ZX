/**
 * 設計模式之迭代器模式
 * */
package IteratorPattern;

public class IteratorPatternDemo {
	//1.创建接口Iterator.java, Container.java
	
	//2.创建实现了 Container 接口的实体类NameRepository.java。该类有实现了 Iterator 接口的内部类 NameIterator。
	
	//3.使用 NameRepository 来获取迭代器，并打印名字。IteratorPatternDemo.java
	
	public static void main(String[] args){
		 NameRepository nameRepository = new NameRepository();
		 
		 for(Iterator iterator = nameRepository.getIterator(); iterator.hasNext();){
			 String name = (String) iterator.next();
			 System.out.println("Names: " + name);
		 }
	}
}
