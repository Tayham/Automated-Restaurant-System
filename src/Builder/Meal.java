package Builder;

import Aggregations.MenuItem;

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

// --Commented out by Inspection START (12/7/2017 3:34 PM):
//	public String getMealName() {
//		return mealName;
//	}
// --Commented out by Inspection STOP (12/7/2017 3:34 PM)

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

// --Commented out by Inspection START (12/7/2017 3:34 PM):
//	public String getEntree() {
//		return entree;
//	}
// --Commented out by Inspection STOP (12/7/2017 3:34 PM)

	public void setEntree(String entree) {
		this.entree = entree;
	}

// --Commented out by Inspection START (12/7/2017 3:34 PM):
//	public String getSide() {
//		return side;
//	}
// --Commented out by Inspection STOP (12/7/2017 3:34 PM)

	public void setSide(String side) {
		this.side = side;
	}

// --Commented out by Inspection START (12/7/2017 3:34 PM):
//	public String getDrink() {
//		return drink;
//	}
// --Commented out by Inspection STOP (12/7/2017 3:34 PM)

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
		//return "Meal #" + mealId + ":\n\t" + entree.toString() + "\t" + side.toString() + "\t" + drink.toString() +"\n Meal Discount Price: $" + getCost();
		return (mealName + ":\n\t" + entree + "\n\t" + side + "\n\t" + drink + "\n Meal Cost: $" + cost + "\n");
//		return "test";
	}

}