package AdapterPatternDemo;

//为媒体播放器和更高级的媒体播放器创建接口
public interface AdvanceMediaPlayer {
	public void playVlc(String fileName);
	public void playMp4(String fileName);
}
