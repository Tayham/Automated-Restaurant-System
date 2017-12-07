package Command;

import Builder.Meal;
import Invoker.OrderItem;

public class CMDMakeMeal {
	private Aggregator agg;
	private int[] selections;

	public CMDMakeMeal(Aggregator agg, int[] selections) {
		this.agg = agg;
		this.selections = selections;
	}

	public Meal execute() {
		Builder.Meal meal = agg.getMealBuilder().buildMeal(agg.getMenu(), selections);
		meal.generateMealNum();
		OrderItem mealOrder = new OrderItem(meal.getMealNum());
		agg.getOrders().addOrder(mealOrder);
		agg.getMeals().addMeal(meal);
		return meal;
	}
}
