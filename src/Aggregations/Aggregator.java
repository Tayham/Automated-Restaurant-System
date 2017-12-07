package Aggregations;


import Builder.Meals;

public class Aggregator {

	private final Menu menu;
	private final Orders orders;
	private final Tab tab;
	private final Meals meals;

	public Aggregator(Menu menu, Orders orders, Meals meals, Tab tab) {
		this.menu = menu;
		this.orders = orders;
		this.tab = tab;
		this.meals = meals;
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

	public Tab getTab() {
		return tab;
	}

}
