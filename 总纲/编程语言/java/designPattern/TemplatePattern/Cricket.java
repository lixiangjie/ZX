package TemplatePattern;

//创建扩展了Game.java的实体类Cricket.java。	
public class Cricket extends Game{

	@Override
	void startPlay() {
		System.out.println("Cricket Game Started. Enjoy the game!");
	}
	
	@Override
	void initialize() {
		System.out.println("Cricket Game Initialized! Start playing.");
	}

	@Override
	void endPlay() {
		System.out.println("Cricket Game Finished!");
	}
	
}
