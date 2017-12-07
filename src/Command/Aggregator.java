package Command;

import Builder.MealBuilder;
import Builder.Meals;
import Invoker.Menu;
import Invoker.Orders;
import Invoker.Tab;

public class Aggregator {

	private Menu menu;
	private Orders orders;
	private Tab tab;
	private Meals meals;
	private MealBuilder mealBuilder;

	public Aggregator(Menu menu, Orders orders, Meals meals, Tab tab, MealBuilder mealBuilder) {
		this.menu = menu;
		this.orders = orders;
		this.tab = tab;
		this.meals = meals;
		this.mealBuilder = mealBuilder;
	}

	public Meals getMeals() {
		return meals;
	}

	public Menu getMenu() {
		return menu;
	}

	public Orders getOrders() {
		return orders;
	}

	public MealBuilder getMealBuilder() {
		return mealBuilder;
	}

	public Tab getTab() {
		return tab;
	}

}
