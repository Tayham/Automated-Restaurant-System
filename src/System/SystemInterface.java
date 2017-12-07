package System;

import Aggregations.*;
import Builder.MealBuilder;
import Builder.Meals;
import Command.Invoker;
import State.Afternoon;
import State.Evening;
import State.Morning;

import java.util.ArrayList;
import java.util.Iterator;


@SuppressWarnings("unchecked")
public class SystemInterface {

	private static Invoker invoker;

	public static void init() {
		invoker = new Invoker(new Menu(), new Orders(), new Meals(), new Tab(), new MealBuilder());
	}

	public static void setMenuState(int s) {
		switch (s) {
			case 1:
				invoker.getMenu().setState(new Morning());
				break;
			case 2:
				invoker.getMenu().setState(new Afternoon());
				break;
			case 3:
				invoker.getMenu().setState(new Evening());
				break;
		}
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

	public static ArrayList<String> printMenuType(MenuItemType type) {
		ArrayList<String> output = new ArrayList<>();
		Iterator<MenuItem> iterator = invoker.getMenu().typeIterator(type);
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

	public static String makeMeal(int[] itemCodes) {
		return invoker.makeMeal(itemCodes).toString();
	}

	private static void fillTab() {
		invoker.getTab().populateTab(invoker.getMeals(), invoker.getMenu(), invoker.getOrders());
	}

	public static String calcTotal() {
		return invoker.getTab().total(invoker.getMeals(), invoker.getMenu(), invoker.getOrders());

	}


}
