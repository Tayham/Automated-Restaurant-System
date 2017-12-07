package Builder;

public class SpaghettiMealBuilder extends MealBuilder {

	public void addEntree() {
		meal.setEntree("Sphaghetti");
	}

	public void addSide() {
		meal.setSide("Garlic Bread");
	}

	public void addId() {
		meal.setMealId(502);
	}

	public void addMealName() {
		meal.setMealName("Spaghetti Meal");
	}

	public void addCost() {
		meal.setCost(20.35);
	}

	public void addDrink() {
		meal.setDrink("Wine");
	}

	public Meal getMeal() {
		return meal;
	}

}
