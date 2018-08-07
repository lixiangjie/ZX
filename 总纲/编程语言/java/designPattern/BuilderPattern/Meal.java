package BuilderPattern;

import java.util.ArrayList;
import java.util.List;

//����һ�� Meal�࣬���� Item�������ϸ��Ϣ���������ơ���װ���۸�
public class Meal {
	private List<Item> items = new ArrayList<Item>();
	
	//���������������Ʒ����
	public void addItem(Item item){
		items.add(item);
	}
	
	//����������Ʒ�Ļ���
	public float getCost(){
		float cost = 0.0f;
		for(Item item : items){
			cost += item.price();
		}
		return cost;
	}
	
	//��ʾ���ѵ���Ʒ��Ϣ
	public void showItems(){
		for(Item item : items){
			System.out.print("Item: " + item.name());
			System.out.print(", packing: " + item.packing().pack());
			System.out.println(", price: " + item.price());
		}
	}
}
