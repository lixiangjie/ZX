package TemplatePattern;

//�����࣬ģ�巽��
public abstract class Game {
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
	
	//ģ�巽��   final�ؼ���
	public final void play(){
		
		//��ʼ����Ϸ
		initialize();
		
		//��ʼ��Ϸ
		startPlay();
		
		//������Ϸ
		endPlay();
	}
}
