package Builder;

public class NiceMealBuilder extends MealBuilder {

	public void addEntree() {
		meal.setEntree("Steak");
	}

	public void addSide() {
		meal.setSide("Sweet Potato");
	}

	public void addId() {
		meal.setMealId(501);
	}

	public void addMealName() {
		meal.setMealName("Nice Meal");
	}

	public void addCost() {
		meal.setCost(25.35);
	}

	public void addDrink() {
		meal.setDrink("Wine");
	}

	public Meal getMeal() {
		return meal;
	}

}
