/**
 * �OӋģʽ֮�m����ģʽ
 * */
package AdapterPatternDemo;

public class AdapterPatternDemo {
	//1.Ϊý�岥�����͸��߼���ý�岥���������ӿ�MediaPlayer.java, AdvancedMediaPlayer.java
	
	//2.����ʵ���� AdvancedMediaPlayer �ӿڵ�ʵ����VlcPlayer.java, Mp4Player.java
	
	//3.����ʵ���� MediaPlayer �ӿڵ���������MediaAdapter.java
	
	//4.����ʵ���� MediaPlayer �ӿڵ�ʵ����AudioPlayer.java
	
	//5.ʹ�� AudioPlayer �����Ų�ͬ���͵���Ƶ��ʽAdapterPatternDemo.java
	public static void main(String[] args){
		AudioPlayer audioPlayer = new AudioPlayer();
		
		audioPlayer.play("mp3", "lxj.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "aa.vlc");
		audioPlayer.play("avi", "me.avi");
	}
}
