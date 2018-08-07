package ChainOfResponsibilityPattern;

//创建扩展了该记录器AbstractLogger的实体类
public class ErrorLogger extends AbstractLogger{

	public ErrorLogger(int level) {
		this.level = level;
	}
	
	@Override
	protected void write(String message) {
		System.out.println("Error Console::Logger: " + message);
	}

}
