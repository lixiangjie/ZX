package TemplatePattern;

//抽象类，模板方法
public abstract class Game {
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
	
	//模板方法   final关键字
	public final void play(){
		
		//初始化游戏
		initialize();
		
		//开始游戏
		startPlay();
		
		//结束游戏
		endPlay();
	}
}
