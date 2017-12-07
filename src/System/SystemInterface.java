package System;

import Aggregations.Menu;
import Aggregations.MenuItem;
import Aggregations.Orders;
import Aggregations.Tab;
import Builder.Meals;
import Command.Invoker;

import java.util.ArrayList;
import java.util.Iterator;


@SuppressWarnings("unchecked")
public class SystemInterface {

	private static Invoker invoker;

	public static void init() {
		invoker = new Invoker(new Menu(), new Orders(), new Meals(), new Tab());
	}

	public static void setMenuState(int i) {
		invoker.getMenu().updateMenuTime(i);
	}

	public static ArrayList<String> printMenu() {
		ArrayList<String> output = new ArrayList<>();
		Iterator<MenuItem> iterator = invoker.getMenu().iterator();
		while (iterator.hasNext()) {
			MenuItem item = iterator.next();
			if (item != null)
				output.add(item.toString());
		}
		return output;
	}

	public static String[] printTab() {
		fillTab();
		Iterator<String> iterator = invoker.getTab().iterator();
		String[] output = new String[invoker.getTab().getTabLength()];
		int i = 0;
		while (iterator.hasNext()) {
			output[i] = iterator.next();
			i++;
		}
		invoker.getTab().emptyTab();
		return output;
	}

	public static void addOrder(int itemCode) {
		if (invoker.getMenu().checkItemCode(itemCode)) {
			invoker.addOrders(itemCode);
		}
	}

	public static String makeMeal(int mealChoice) {
		return invoker.makeMeal(mealChoice).toString();
	}

	private static void fillTab() {
		invoker.getTab().populateTab(invoker.getMeals(), invoker.getMenu(), invoker.getOrders());
	}

	public static String calcTotal() {
		return invoker.getTab().total(invoker.getMeals(), invoker.getMenu(), invoker.getOrders());

	}


}
