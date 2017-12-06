package Builder;

import Invoker.MenuItem;

public class Meal {
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

	public int generateMealNum() {
		if ((entree != null) && (side != null) && (drink != null)) {
			return Integer.valueOf(String.valueOf(entree) + String.valueOf(side) + String.valueOf(drink));
		} else return 0;
	}

	public double getCost() {
		return entree.getPrice() + side.getPrice() + drink.getPrice();
	}

	public String showItems() {
		return "\t#" + entree.toString() + "\t#" + side.toString() + "\t#" + drink.toString();
	}
}