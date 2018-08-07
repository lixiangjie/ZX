package BuilderPattern;

//����һ�� MealBuilder �࣬ʵ�ʵ� builder �ฺ�𴴽� Meal ����
//ѡ���ԵĴ������ж������ϣ���ӵ�ͬһ�����������У������µ�Meal��϶���
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
