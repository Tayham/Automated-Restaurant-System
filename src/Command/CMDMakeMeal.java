package Command;

import Aggregations.Aggregator;
import Aggregations.OrderItem;
import Builder.*;

class CMDMakeMeal {
	private final Aggregator aggregator;
	private final int selection;

	public CMDMakeMeal(Aggregator aggregator, int selection) {
		this.aggregator = aggregator;
		this.selection = selection;
	}

	public Meal execute() {
		MealDirector director = new MealDirector();
		MealBuilder builder = null;
		switch (selection) {
			case 1:
				builder = new NiceMealBuilder();
				break;
			case 2:
				builder = new PanBrownMealBuilder();
				break;
			case 3:
				builder = new SpaghettiMealBuilder();
				break;
		}
		Meal meal = director.createMeal(builder);
		OrderItem mealOrder = new OrderItem(meal.getMealId());
		aggregator.getOrders().addOrder(mealOrder);
		aggregator.getMeals().addMeal(meal);
		return meal;
	}
}

