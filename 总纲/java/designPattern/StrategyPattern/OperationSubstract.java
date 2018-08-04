package StrategyPattern;

//接口Strategy.java的具体实现类
public class OperationSubstract implements Strategy{

	@Override
	public int doOperation(int num1, int num2) {
		return num1 - num2;
	}

}
