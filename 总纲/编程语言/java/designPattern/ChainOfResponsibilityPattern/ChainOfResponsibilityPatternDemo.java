/**
 * �OӋģʽ֮؟���ģʽ
 * */
package ChainOfResponsibilityPattern;

public class ChainOfResponsibilityPatternDemo {
	public static void main(String[] args) {

		// 1.��������ļ�¼���ࡣAbstractLogger.java

		// 2.������չ�˸ü�¼��AbstractLogger��ʵ����ConsoleLogger.java, ErrorLogger.java,
		// FileLogger.java

		// 3.������ͬ���͵ļ�¼�����������ǲ�ͬ�Ĵ��󼶱𣬲���ÿ����¼����������һ����¼����
		// ÿ����¼���е���һ����¼�������������һ���֡�ChainPatternDemo.java

		AbstractLogger loggerChain = getChainOfLoggers();

		loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
		loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
		loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");

	}

	// ������־�ȼ����ȼ�
	private static AbstractLogger getChainOfLoggers() {
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);

		return errorLogger;
	}
}
