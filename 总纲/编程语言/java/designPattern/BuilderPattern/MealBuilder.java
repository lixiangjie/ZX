package BuilderPattern;

//创建一个 MealBuilder 类，实际的 builder 类负责创建 Meal 对象。
//选择性的创建已有对象的组合，添加到同一个泛型容器中，创建新的Meal组合对象
public class MealBuilder {
	public Meal prepareVegMeal(){
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}
	
	public Meal prepareNonVegMeal(){
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
	
	public Meal NewPrepareMeal(){
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
