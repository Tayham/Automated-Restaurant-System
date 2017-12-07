package Builder;


public abstract class MealBuilder {

	final Meal meal = new Meal();

	public abstract void addDrink();

	public abstract void addEntree();

	public abstract void addSide();

	public abstract void addId();

	public abstract void addMealName();

	public abstract void addCost();

	public abstract Meal getMeal();
}

