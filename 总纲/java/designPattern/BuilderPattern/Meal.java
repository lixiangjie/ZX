package BuilderPattern;

import java.util.ArrayList;
import java.util.List;

//创建一个 Meal类，带有 Item对象的详细信息，包括名称、包装、价格。
public class Meal {
	private List<Item> items = new ArrayList<Item>();
	
	//向泛型容器中添加物品对象
	public void addItem(Item item){
		items.add(item);
	}
	
	//计算所有物品的花费
	public float getCost(){
		float cost = 0.0f;
		for(Item item : items){
			cost += item.price();
		}
		return cost;
	}
	
	//显示花费的物品信息
	public void showItems(){
		for(Item item : items){
			System.out.print("Item: " + item.name());
			System.out.print(", packing: " + item.packing().pack());
			System.out.println(", price: " + item.price());
		}
	}
}
