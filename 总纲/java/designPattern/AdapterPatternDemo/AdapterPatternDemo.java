/**
 * 設計模式之適配器模式
 * */
package AdapterPatternDemo;

public class AdapterPatternDemo {
	//1.为媒体播放器和更高级的媒体播放器创建接口MediaPlayer.java, AdvancedMediaPlayer.java
	
	//2.创建实现了 AdvancedMediaPlayer 接口的实体类VlcPlayer.java, Mp4Player.java
	
	//3.创建实现了 MediaPlayer 接口的适配器类MediaAdapter.java
	
	//4.创建实现了 MediaPlayer 接口的实体类AudioPlayer.java
	
	//5.使用 AudioPlayer 来播放不同类型的音频格式AdapterPatternDemo.java
	public static void main(String[] args){
		AudioPlayer audioPlayer = new AudioPlayer();
		
		audioPlayer.play("mp3", "lxj.mp3");
		audioPlayer.play("mp4", "alone.mp4");
		audioPlayer.play("vlc", "aa.vlc");
		audioPlayer.play("avi", "me.avi");
	}
}
