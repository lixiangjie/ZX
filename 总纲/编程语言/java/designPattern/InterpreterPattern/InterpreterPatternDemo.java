/**
 * 設計模式之解釋器模式
 * */
package InterpreterPattern;

public class InterpreterPatternDemo {

	// 1.创建一个表达式接口。Expression.java

	// 2.创建实现了上述接口的实体类。TerminalExpression.java, OrExpression.java,
	// AndExpression.java

	// 3.InterpreterPatternDemo 使用 Expression
	// 类来创建规则，并解析它们。InterpreterPatternDemo.java

	public static void main(String[] args) {
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();
		
		System.out.println("John is male? " + isMale.interpret("John"));
		System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
	}

	// 规则：Robert 和 John 是男性
	public static Expression getMaleExpression() {
		Expression robert = new TerminalExpression("Robert");
		Expression john = new TerminalExpression("John");
		return new OrExpression(robert, john);
	}

	// 规则：Julie 是一个已婚的女性
	public static Expression getMarriedWomanExpression() {
		Expression julie = new TerminalExpression("Julie");
		Expression married = new TerminalExpression("Married");
		return new AndExpression(julie, married);
	}
}
