package Command;

import Aggregations.Aggregator;
import Builder.Meal;
import Builder.Meals;
import Aggregations.Menu;
import Aggregations.Orders;
import Aggregations.Tab;

public class Invoker {

	private final Aggregator aggregator;

	public Invoker(Menu menu, Orders order, Meals meals, Tab tab) {
		aggregator = new Aggregator(menu, order, meals, tab);
	}

	public void addOrders(int itemId) {
		new CMDAddItemToOrder(aggregator, itemId).execute();
	}

	public Meal makeMeal(int selection) {
		return new CMDMakeMeal(aggregator, selection).execute();
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
