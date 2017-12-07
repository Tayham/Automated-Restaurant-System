package Builder;

import Invoker.Menu;
import Invoker.MenuItem;

public class MealBuilder {

	public Meal buildMeal(Menu menu, int[] selections) {
		Meal meal = new Meal();
		MenuItem[] items = new MenuItem[3];
		int i = 0;
		for (int s : selections) {
			items[i] = menu.getMenuItem(s - 1);
			i++;
		}
		meal.setEntree(items[0]);
		meal.setSide(items[1]);
		meal.setDrink(items[2]);
		return meal;
	}
}
