package Invoker;

import java.util.*;

public class Tab {

	private ArrayList<String> orders;

	public Tab() {
		orders = new ArrayList<>();
	}

	public ArrayList<String> fillList(Menu menu, Orders order) {
		for (int x = 0; x < order.getTotalOrders(); x++) {
			for (int y = 0; y < menu.totalMenuItems(); y++) {
				if (order.getOrderItem(x).getItemNum() == menu.getMenuItem(y).getItemNum()) {
					orders.add(menu.getMenuItem(y).toString());
				}
			}
		}
		return orders;
	}

	public void clearTab() {
		orders.clear();
	}

	public String calcTotal(Menu menu, Orders order) {
		double total = 0.0;

		for (int x = 0; x < order.getTotalOrders(); x++) {
			for (int y = 0; y < menu.totalMenuItems(); y++) {
				if (order.getOrderItem(x).getItemNum() == menu.getMenuItem(y).getItemNum()) {
					total += menu.getMenuItem(y).getPrice();
				}
			}
		}

		return "Total: $" + total;
	}

	public int getTotal() {
		return orders.size();
	}

	public Iterator<String> iterator() {
		return new TabIterator();
	}

	private class TabIterator implements Iterator<String> {
		int index = 0;

		@Override
		public boolean hasNext() {
			return !(index >= orders.size() || orders.get(index) == null);
		}

		@Override
		public String next() {
			return orders.get(index++);
		}
	}
}
