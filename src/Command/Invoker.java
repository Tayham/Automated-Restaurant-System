package Command;

import Aggregations.Aggregator;
import Builder.Meal;
import Builder.MealBuilder;
import Builder.Meals;
import Aggregations.Menu;
import Aggregations.Orders;
import Aggregations.Tab;

public class Invoker {

	private final Aggregator aggregator;

	public Invoker(Menu menu, Orders order, Meals meals, Tab tab, MealBuilder mealBuilder) {
		aggregator = new Aggregator(menu, order, meals, tab, mealBuilder);
	}

	public void addOrders(int itemId) {
		new CMDAddItemToOrder(aggregator, itemId).execute();
	}

	public Meal makeMeal(int[] selections) {
		return new CMDMakeMeal(aggregator, selections).execute();
	}

	public Meals getMeals() {
		return new CMDGetMeals(aggregator).execute();
	}

	public Menu getMenu() {
		return new CMDGetMenu(aggregator).execute();
	}

	public Tab getTab() {
		return new CMDGetTab(aggregator).execute();
	}

	public Orders getOrders() {
		return new CMDGetOrders(aggregator).execute();
	}
}
