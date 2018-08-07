/**
 * �OӋģʽ֮������ģʽ
 * */
package BuilderPattern;

public class BuilderPatternDemo {

	//1.������ʾʳ�����ԵĽӿ�Item.java�ͱ�ʾʳ���װ�Ľӿ�Packing.java
	
	//2.����ʵ��Packing�ӿڵ�ʵ����Wrapper.java��Bottle.java
	
	//3.����ʵ�� Item �ӿڵĳ�����Burger.jva��ColdDrink.java�������ṩ��Ĭ�ϵĹ��ܣ���װ�ͼ۸񣩡�
	
	//4.������չ��Burger��ʵ����VegBurger.java��ChickenBurger.java
	//  ������չ��ColdDrink��ʵ����Pepsi.java��Coke.java
	
	//5.����һ�� Meal �࣬�������涨��� Item ����
	
	//6.����һ�� MealBuilder �࣬ʵ�ʵ� builder �ฺ�𴴽� Meal ����
	
	//7.BuiderPatternDemo ʹ�� MealBuider ����ʾ������ģʽ��Builder Pattern����
	
	public static void main(String[] args){
		MealBuilder mealBuilder = new MealBuilder();
		
		Meal VegMeal = mealBuilder.prepareVegMeal();		
		System.out.println("Veg Meal");
		VegMeal.showItems();
		System.out.println("Total Cost: " + VegMeal.getCost());
		
		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("\nNon-Veg Meal");
		nonVegMeal.showItems();
		System.out.println("Total Cost: " + nonVegMeal.getCost());
		
		Meal NewMeal = mealBuilder.NewPrepareMeal();
		System.out.println("\nNew Meal");
		NewMeal.showItems();
		System.out.println("Total Cost: " + NewMeal.getCost());
	}
}
