package AdapterPatternDemo;

//����ʵ���� AdvancedMediaPlayer �ӿڵ�ʵ���ࡣ
public class VlcPlayer implements AdvanceMediaPlayer{

	@Override
	public void playVlc(String fileName) {
		// TODO �Զ����ɵķ������
		System.out.println("Playing vlc file Name: " + fileName);
	}

	@Override
	public void playMp4(String fileName) {
		// TODO �Զ����ɵķ������
		
	}
	
}
