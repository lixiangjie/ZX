package ProxyPattern;

//Image�ӿڵ�ʵ����RealImage.java
public class RealImage implements Image{

	private String fileName;
	
	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFramDisk(fileName);
	}
	
	@Override
	public void display() {
		System.out.println("Displaying " + fileName);
	}
	
	public void loadFramDisk(String fileName){
		System.out.println("Loading " + fileName);
	}

}
