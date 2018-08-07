package TemplatePattern;

/**
 * �OӋģʽ֮ģ��ģʽ
 * */
public class TemplatePatternDemo {

	//1.����һ��������Game.java������ģ�巽��������Ϊ final��	
	
	//2.������չ��������Game.java��ʵ����Cricket.java, Football.java
	
	//3.ʹ�� Game ��ģ�巽�� play() ����ʾ��Ϸ�Ķ��巽ʽ��
	
	public static void main(String[] args){
		
		Game game = new Cricket();
		game.play();
		
		System.out.println();
		
		game = new Football();
		game.play();
	}
}
