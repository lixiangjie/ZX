package BuilderPattern;

//������չ��Burger��ʵ����ChickenBurger
public class ChickenBurger extends Burger{

	@Override
	public String name() {
		// TODO �Զ����ɵķ������
		return "Chicken Burger";
	}

	@Override
	public float price() {
		// TODO �Զ����ɵķ������
		return 50.5f;
	}

}
