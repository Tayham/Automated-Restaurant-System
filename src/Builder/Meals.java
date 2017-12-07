package Builder;

import java.util.ArrayList;

public class Meals {
	private final ArrayList<Meal> meals;

	public Meals() {
		meals = new ArrayList();
	}

	public void addMeal(Meal meal) {
		meals.add(meal);
	}

	public int getMealsLength() {
		return meals.size();
	}

	public Meal getMeal(int x) {
		return meals.get(x);
	}
}

