/**
 * 設計模式之責任鏈模式
 * */
package ChainOfResponsibilityPattern;

public class ChainOfResponsibilityPatternDemo {
	public static void main(String[] args) {

		// 1.创建抽象的记录器类。AbstractLogger.java

		// 2.创建扩展了该记录器AbstractLogger的实体类ConsoleLogger.java, ErrorLogger.java,
		// FileLogger.java

		// 3.创建不同类型的记录器。赋予它们不同的错误级别，并在每个记录器中设置下一个记录器。
		// 每个记录器中的下一个记录器代表的是链的一部分。ChainPatternDemo.java

		AbstractLogger loggerChain = getChainOfLoggers();

		loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
		loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
		loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");

	}

	// 设置日志等级优先级
	private static AbstractLogger getChainOfLoggers() {
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);

		return errorLogger;
	}
}
