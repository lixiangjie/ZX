package BuilderPattern;

//������չ��Burger��ʵ����VegBurger
public class VegBurger extends Burger{

	@Override
	public String name() {
		// TODO �Զ����ɵķ������
		return "Veg Burger";
	}

	@Override
	public float price() {
		// TODO �Զ����ɵķ������
		return 25.0f;
	}
	
}
