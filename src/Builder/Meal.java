package Builder;

import Invoker.MenuItem;

public class Meal {
	private int mealNum;
	private MenuItem entree;
	private MenuItem side;
	private MenuItem drink;


	public MenuItem getEntree() {
		return entree;
	}

	public void setEntree(MenuItem entree) {
		this.entree = entree;
	}

	public MenuItem getSide() {
		return side;
	}

	public void setSide(MenuItem side) {
		this.side = side;
	}

	public MenuItem getDrink() {
		return drink;
	}

	public void setDrink(MenuItem drink) {
		this.drink = drink;
	}

	public void generateMealNum() {
		if ((entree != null) && (side != null) && (drink != null)) {
			mealNum = Integer.valueOf(String.valueOf(entree.getItemNum()) + String.valueOf(side.getItemNum()) + String.valueOf(drink.getItemNum()));
		}
	}

	public int getMealNum() {
		return mealNum;
	}

	public double getCost() {
		return (entree.getPrice() + side.getPrice() + drink.getPrice()) * .95;
	}

	public String toString() {
		return "Meal #" + mealNum + ":\n\t" + entree.toString() + "\t" + side.toString() + "\t" + drink.toString();
	}
}