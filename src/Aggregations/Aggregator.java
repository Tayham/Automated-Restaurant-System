package Aggregations;

import Builder.MealBuilder;
import Builder.Meals;

public class Aggregator {

	private final Menu menu;
	private final Orders orders;
	private final Tab tab;
	private final Meals meals;
	private final MealBuilder mealBuilder;

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
