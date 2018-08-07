package ChainOfResponsibilityPattern;

//创建扩展了该记录器AbstractLogger的实体类
public class FileLogger extends AbstractLogger{

	public FileLogger(int level) {
		this.level = level;
	}
	
	@Override
	protected void write(String message) {
		System.out.println("File::Logger: " + message);
	}

}
