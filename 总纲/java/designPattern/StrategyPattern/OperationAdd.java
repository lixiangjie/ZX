package StrategyPattern;

//�ӿ�Strategy.java�ľ���ʵ����
public class OperationAdd implements Strategy{

	@Override
	public int doOperation(int num1, int num2) {
		return num1 + num2;
	}

}
