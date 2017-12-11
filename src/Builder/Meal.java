package Builder;

public class Meal {
	private int mealId;
	private String mealName;
	private String entree;
	private String side;
	private String drink;
	private double cost;

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public void setEntree(String entree) {
		this.entree = entree;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String toString() {
		return (mealName + ":\n\t" + entree + "\n\t" + side + "\n\t" + drink + "\n Meal Cost: $" + cost + "\n");
	}

}