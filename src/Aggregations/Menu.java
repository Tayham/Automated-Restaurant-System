package Aggregations;

import State.Morning;
import State.State;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu {

	private final ArrayList<MenuItem> menu;
	private State menuTime = new Morning();

	public Menu() {
		menu = new ArrayList<>();
		fillMenu();
	}

	public void setState(State s) {
		menuTime = s;
	}

	public void updateMenuTime(int i) {
		menuTime.updateTime(i, this);
		menuTime.displayState();
	}

	private void fillMenu() {
		{

			//Entree Items
			menu.add(new MenuItem(1, "Pancakes", 10.99,  "Breakfast"));
			menu.add(new MenuItem(2, "Waffles", 11.95,  "Breakfast"));
			menu.add(new MenuItem(3, "Bagel", 7.99,  "Breakfast"));

			menu.add(new MenuItem(4, "Soup", 7.27,  "Lunch"));
			menu.add(new MenuItem(5, "Salad", 3.50,  "Lunch"));
			menu.add(new MenuItem(6, "Grilled Cheese", 4.84,  "Lunch"));

			menu.add(new MenuItem(7, "Pizza", 13.48,  "Dinner"));
			menu.add(new MenuItem(8, "CheeseBurger", 15.68,  "Lunch & Dinner"));
			menu.add(new MenuItem(9, "Steak", 20.51,  "Dinner"));

			//Sides
			menu.add(new MenuItem(10, "Sausage", 1.99,  "Breakfast"));
			menu.add(new MenuItem(11, "Bacon", 2.26,  "Breakfast"));
			menu.add(new MenuItem(12, "Fries", 1.99,  "Lunch & Dinner"));
			menu.add(new MenuItem(13, "Mashed Potato", 3.45,  "Dinner"));

			//Drinks
			menu.add(new MenuItem(14, "Chocolate Milk", 1.99, "Breakfast"));
			menu.add(new MenuItem(15, "Coffee", 2.95, "Breakfast & Lunch & Dinner"));
			menu.add(new MenuItem(16, "Soda", 1.50,  "Breakfast & Lunch & Dinner"));
		}
	}

	public MenuItem getMenuItem(int x) {
		return menu.get(x);
	}

	public int getMenuLength() {
		return menu.size();
	}

	public boolean checkItemCode(int itemCode) {
		for (MenuItem m : menu) {
			if (m.getItemId() == (itemCode) && (m.getServedAt().contains(menuTime.toString()))) {
				return true;
			}
		}
		return false;
	}

	public MenuIterator iterator() {
		return new MenuIterator();
	}

	private class MenuIterator implements Iterator {
		private int i = 0;  // i

		public boolean hasNext() {
			return !(i >= menu.size() || menu.get(i) == null) && filter();
		}

		boolean filter() {
			if (menu.get(i).getServedAt().contains(menuTime.toString())) {
				return true;
			} else {
				i++;
				return hasNext();
			}
		}

		public MenuItem next() {
			return menu.get(i++);
		}

		@Override
		public void remove() {

		}
	}

}
