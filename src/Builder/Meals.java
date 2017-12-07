package Builder;

import java.util.ArrayList;
import java.util.Iterator;

public class Meals {
	private ArrayList<Meal> meals;

	public Meals() {
		meals = new ArrayList();
	}

	public void addMeal(Meal meal) {
		meals.add(meal);
	}


	public int getTotalMeals() {
		return meals.size();
	}

	public Meal getMealItem(int x) {
		return meals.get(x);
	}

	public Iterator<Meal> iterator() {
		return new Meals.MealsIterator();
	}


	private class MealsIterator implements Iterator<Meal> {
		int index = 0;

		@Override
		public boolean hasNext() {
			return !(index >= meals.size() || meals.get(index) == null);
		}

		@Override
		public Meal next() {
			return meals.get(index++);
		}
	}
}

