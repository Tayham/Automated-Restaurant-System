package Invoker;

import State.State;

import java.util.ArrayList;
import java.util.Iterator;

import static Invoker.MenuItemType.*;

public class Menu {

	private ArrayList<MenuItem> menu;
	private State menuTime;

	public Menu() {
		menu = new ArrayList<>();
		fillMenu();
	}

	public void addMenuItem(MenuItem item) {
		menu.add(item);
	}

	public void removeMenuItem(MenuItem item) {
		menu.remove(item);
	}

	public State getState() {
		return menuTime;
	}

	public void setState(State newState) {
		menuTime = newState;
		menuTime.displayState();
	}

	public void fillMenu() {
		{

			//Entree Items
			menu.add(new MenuItem(1, "Pancakes", 10.99, ENTREE, "Breakfast"));
			menu.add(new MenuItem(2, "Waffles", 11.95, ENTREE, "Breakfast"));
			menu.add(new MenuItem(3, "Bagel", 7.99, ENTREE, "Breakfast"));

			menu.add(new MenuItem(4, "Soup", 7.27, ENTREE, "Lunch"));
			menu.add(new MenuItem(5, "Salad", 3.50, ENTREE, "Lunch"));
			menu.add(new MenuItem(6, "Grilled Cheese", 4.84, ENTREE, "Lunch"));

			menu.add(new MenuItem(7, "Pizza", 13.48, ENTREE, "Dinner"));
			menu.add(new MenuItem(8, "CheeseBurger", 15.68, ENTREE, "Lunch & Dinner"));
			menu.add(new MenuItem(9, "Steak", 20.51, ENTREE, "Dinner"));

			//Sides
			menu.add(new MenuItem(10, "Sausage", 1.99, SIDE, "Breakfast"));
			menu.add(new MenuItem(11, "Bacon", 2.26, SIDE, "Breakfast"));
			menu.add(new MenuItem(12, "Fries", 1.99, SIDE, "Lunch & Dinner"));
			menu.add(new MenuItem(13, "Mashed Potato", 3.45, SIDE, "Dinner"));

			//Drinks
			menu.add(new MenuItem(14, "Chocolate Milk", 1.99, DRINK, "Breakfast"));
			menu.add(new MenuItem(15, "Coffee", 2.95, DRINK, "Breakfast & Lunch & Dinner"));
			menu.add(new MenuItem(16, "Soda", 1.50, DRINK, "Breakfast & Lunch & Dinner"));
		}
	}

	public MenuItem getMenuItem(int x) {
		return menu.get(x);
	}

	public int totalMenuItems() {
		return menu.size();
	}

	public boolean checkItemCode(int itemCode) {
		for (MenuItem m : menu) {
			if (m.getItemNum() == (itemCode) && (m.getServedAt().contains(menuTime.toString()))) {
				return true;
			}
		}
		return false;
	}


	public Iterator<MenuItem> iterator() {
		return new MenuIterator();
	}

	public Iterator<MenuItem> typeIterator(MenuItemType type) {
		return new TypeIterator(type);
	}

	private class MenuIterator implements Iterator {
		private int i = 0;  // index

		public boolean hasNext() {
			return !(i >= menu.size() || menu.get(i) == null) && filter();
		}

		public boolean filter() {
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

	private class TypeIterator implements Iterator {
		MenuItemType type;
		private int i = 0;

		public TypeIterator(MenuItemType type) {
			this.type = type;
		}

		public boolean hasNext() {
			return !(i >= menu.size() || menu.get(i) == null) && filter();
		}

		public boolean filter() {
			if ((menu.get(i).getType() == (type)) && menu.get(i).getServedAt().contains(menuTime.toString())) {
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
