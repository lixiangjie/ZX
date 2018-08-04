/**
 * 設計模式之建造者模式
 * */
package BuilderPattern;

public class BuilderPatternDemo {

	//1.创建表示食物属性的接口Item.java和表示食物包装的接口Packing.java
	
	//2.创建实现Packing接口的实体类Wrapper.java和Bottle.java
	
	//3.创建实现 Item 接口的抽象类Burger.jva和ColdDrink.java，该类提供了默认的功能（包装和价格）。
	
	//4.创建扩展了Burger的实体类VegBurger.java，ChickenBurger.java
	//  创建扩展了ColdDrink的实体类Pepsi.java，Coke.java
	
	//5.创建一个 Meal 类，带有上面定义的 Item 对象。
	
	//6.创建一个 MealBuilder 类，实际的 builder 类负责创建 Meal 对象。
	
	//7.BuiderPatternDemo 使用 MealBuider 来演示建造者模式（Builder Pattern）。
	
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
