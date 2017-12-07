package Aggregations;

import Builder.Meals;

import java.util.ArrayList;
import java.util.Iterator;

public class Tab {

	private final ArrayList<String> tab;

	public Tab() {
		tab = new ArrayList<>();
	}

	public void populateTab(Meals meals, Menu menu, Orders order) {
		for (int i = 0; i < order.getOrderLength(); i++) {

			for (int j = 0; j < menu.getMenuLength(); j++) {
				if (order.getOrder(i).getId() == menu.getMenuItem(j).getItemId()) {
					tab.add(menu.getMenuItem(j).toString());
				}
			}

			for (int k = 0; k < meals.getMealsLength(); k++) {
				if (order.getOrder(i).getId() == meals.getMeal(k).getMealId()) {
					tab.add(meals.getMeal(k).toString());
				}
			}

		}
	}

	public String total(Meals meals, Menu menu, Orders order) {
		double total = 0.0;

		for (int i = 0; i < order.getOrderLength(); i++) {

			for (int j = 0; j < menu.getMenuLength(); j++) {
				if (order.getOrder(i).getId() == menu.getMenuItem(j).getItemId()) {
					total += menu.getMenuItem(j).getPrice();
				}
			}

			for (int k = 0; k < meals.getMealsLength(); k++) {
				if (order.getOrder(i).getId() == meals.getMeal(k).getMealId()) {
					total += meals.getMeal(k).getCost();
				}
			}

		}
		return "Total: $" + total;
	}

	public void emptyTab() {
		tab.clear();
	}


	public int getTabLength() {
		return tab.size();
	}

	public Iterator<String> iterator() {
		return new TabIterator();
	}

	private class TabIterator implements Iterator<String> {
		int i = 0;

		@Override
		public boolean hasNext() {
			return !(i >= tab.size() || tab.get(i) == null);
		}

		@Override
		public String next() {
			return tab.get(i++);
		}

		@Override
		public void remove() {

		}
	}
}
