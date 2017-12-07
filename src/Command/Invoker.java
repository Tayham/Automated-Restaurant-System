package Command;

import Builder.Meal;
import Builder.MealBuilder;
import Builder.Meals;
import Invoker.Menu;
import Invoker.OrderItem;
import Invoker.Orders;
import Invoker.Tab;

public class Invoker {

	private Aggregator agg;

	public Invoker(Menu menu, Orders order, Meals meals, Tab tab, MealBuilder mealBuilder) {
		agg = new Aggregator(menu, order, meals, tab, mealBuilder);
	}

	public OrderItem addOrders(int itemNum) {
		return new CMDAddItemToOrder(agg, itemNum).execute();
	}

	public Meal makeMeal(int[] selections) {
		return new CMDMakeMeal(agg, selections).execute();
	}

	public Meals getMeals() {
		return new CMDGetMeals(agg).execute();
	}

	public Orders getOrders() {
		return new CMDGetOrders(agg).execute();
	}

	public Menu getMenu() {
		return new CMDGetMenu(agg).execute();
	}

	public Tab getTab() {
		return new CMDGetTab(agg).execute();
	}

}
