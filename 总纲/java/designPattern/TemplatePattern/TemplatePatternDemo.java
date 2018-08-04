package TemplatePattern;

/**
 * 設計模式之模板模式
 * */
public class TemplatePatternDemo {

	//1.创建一个抽象类Game.java，它的模板方法被设置为 final。	
	
	//2.创建扩展了上述类Game.java的实体类Cricket.java, Football.java
	
	//3.使用 Game 的模板方法 play() 来演示游戏的定义方式。
	
	public static void main(String[] args){
		
		Game game = new Cricket();
		game.play();
		
		System.out.println();
		
		game = new Football();
		game.play();
	}
}
