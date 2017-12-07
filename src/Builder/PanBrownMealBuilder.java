package Builder;

public class PanBrownMealBuilder extends MealBuilder {


	public void addEntree() {
		meal.setEntree("Pancakes");
	}

	public void addSide() {
		meal.setSide("Hashbrowns");
	}

	public void addId() {
		meal.setMealId(500);
	}

	public void addMealName() {
		meal.setMealName("PanBrown Special");
	}

	public void addCost() {
		meal.setCost(18.05);
	}

	public void addDrink() {
		meal.setDrink("Milk");
	}

	public Meal getMeal() {
		return meal;
	}

}