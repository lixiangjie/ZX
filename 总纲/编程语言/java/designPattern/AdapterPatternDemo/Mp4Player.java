package AdapterPatternDemo;

//����ʵ���� AdvancedMediaPlayer �ӿڵ�ʵ���ࡣ
public class Mp4Player implements AdvanceMediaPlayer{

	@Override
	public void playVlc(String fileName) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void playMp4(String fileName) {
		// TODO �Զ����ɵķ������
		System.out.println("Playing mp4 file Name: " + fileName);
	}

}
