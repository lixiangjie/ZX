package AdapterPatternDemo;

//����ʵ���� MediaPlayer �ӿڵ�ʵ���ࡣ
public class AudioPlayer implements MediaPlayer{
	
	MediaAdapter MediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		//����MP3�����ļ�������֧��
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing mp3 file Name: " + fileName);
		}
		
		//mediaAdapter �ṩ�˲��������ļ���ʽ��֧��
		else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			MediaAdapter = new MediaAdapter(audioType);
			MediaAdapter.play(audioType, fileName);
		}else {
			System.out.println("Invalid media " + audioType + " format not supported");
		}
	}

}
