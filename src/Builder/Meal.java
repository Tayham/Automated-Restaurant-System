package Builder;

import Aggregations.MenuItem;

public class Meal {
	private int mealNum;
	private MenuItem entree;
	private MenuItem side;
	private MenuItem drink;


	public void setEntree(MenuItem entree) {
		this.entree = entree;
	}


	public void setSide(MenuItem side) {
		this.side = side;
	}


	public void setDrink(MenuItem drink) {
		this.drink = drink;
	}

	public void generateMealNum() {
		if ((entree != null) && (side != null) && (drink != null)) {
			mealNum = Integer.valueOf(String.valueOf(entree.getItemId()) + String.valueOf(side.getItemId()) + String.valueOf(drink.getItemId()));
		}
	}

	public int getMealId() {
		return mealNum;
	}

	public double getCost() {
		return (entree.getPrice() + side.getPrice() + drink.getPrice()) * .95;
	}

	public String toString() {
		return "Meal #" + mealNum + ":\n\t" + entree.toString() + "\t" + side.toString() + "\t" + drink.toString() +"\n Meal Discount Price: $" + getCost();
	}
}