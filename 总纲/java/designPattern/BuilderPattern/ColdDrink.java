package BuilderPattern;

//����ʵ�� Item�ӿڵĳ�����ColdDrink
public abstract class ColdDrink implements Item{
	
	@Override
	public Packing packing(){
		return new Bottle(); //����ʵ����Bottle.java��������ʹ�õİ�װ��
	}
	
	@Override
	public abstract float price();
}
