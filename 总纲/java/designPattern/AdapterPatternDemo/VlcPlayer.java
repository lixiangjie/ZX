package AdapterPatternDemo;

//创建实现了 AdvancedMediaPlayer 接口的实体类。
public class VlcPlayer implements AdvanceMediaPlayer{

	@Override
	public void playVlc(String fileName) {
		// TODO 自动生成的方法存根
		System.out.println("Playing vlc file Name: " + fileName);
	}

	@Override
	public void playMp4(String fileName) {
		// TODO 自动生成的方法存根
		
	}
	
}
