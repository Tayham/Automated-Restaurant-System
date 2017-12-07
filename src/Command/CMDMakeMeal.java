package Command;

import Aggregations.Aggregator;
import Aggregations.OrderItem;
import Builder.Meal;

class CMDMakeMeal {
	private final Aggregator aggregator;
	private final int[] selections;

	public CMDMakeMeal(Aggregator aggregator, int[] selections) {
		this.aggregator = aggregator;
		this.selections = selections;
	}

	public Meal execute() {
		Builder.Meal meal = aggregator.getMealBuilder().buildMeal(aggregator.getMenu(), selections);
		meal.generateMealNum();
		OrderItem mealOrder = new OrderItem(meal.getMealId());
		aggregator.getOrders().addOrder(mealOrder);
		aggregator.getMeals().addMeal(meal);
		return meal;
	}
}
