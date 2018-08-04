package BuilderPattern;

//����ʵ�� Item�ӿڵĳ�����Burger
public abstract class Burger implements Item{
	
	@Override
	public Packing packing(){
		return new Wrapper(); //����ʵ����Wrapper��������ʹ�õİ�װ��
	}
	
	@Override
	public abstract float price();

}
