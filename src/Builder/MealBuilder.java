package Builder;
import Invoker.*;


public class MealBuilder {

	public void buildMeal(MenuItem entree, MenuItem side, MenuItem drink) {
		Meal meal = new Meal();
		meal.setEntree(entree);
		meal.setSide(side);
		meal.setDrink(drink);
	}
}
