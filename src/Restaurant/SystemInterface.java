package Restaurant;

import Builder.Meal;
import Builder.MealBuilder;
import Builder.Meals;
import Command.Invoker;
import Invoker.*;
import State.Afternoon;
import State.Evening;
import State.Morning;

import java.util.ArrayList;
import java.util.Iterator;


public class SystemInterface {

	public static Invoker invoker;

	public static void init() {
		invoker = new Invoker(new Menu(), new Orders(), new Meals(), new Tab(), new MealBuilder());
	}

	public static void setMenuState(int s) {
		Menu menu = invoker.getMenu();
		switch (s) {
			case 1:
				menu.setState(new Morning());
				break;
			case 2:
				menu.setState(new Afternoon());
				break;
			case 3:
				menu.setState(new Evening());
				break;
		}
	}

	public static ArrayList<String> printMenu() {
		Menu menu = invoker.getMenu();
		MenuItem item;
		Iterator<MenuItem> menuItr = menu.iterator();
		ArrayList<String> lines = new ArrayList<>();
		while (menuItr.hasNext()) {
			item = menuItr.next();
			if (item != null)
				lines.add(item.toString());
		}
		return lines;
	}

	public static ArrayList<String> printMenuType(MenuItemType type) {
		Menu menu = invoker.getMenu();
		MenuItem item;
		Iterator<MenuItem> menuItr = menu.typeIterator(type);
		ArrayList<String> lines = new ArrayList<>();
		while (menuItr.hasNext()) {
			item = menuItr.next();
			if (item != null)
				lines.add(item.toString());
		}
		return lines;
	}

	public static String addOrder(int itemCode) {
		Menu menu = invoker.getMenu();
		if (menu.checkItemCode(itemCode)) {
			invoker.addOrders(itemCode);
			return "Order # " + itemCode + " Added";
		}
		return "Item # is not on the  " + menu.getState().toString() + "Menu";
	}

	public static String checkOrderItem(int itemCode, MenuItemType type) {
		Menu menu = invoker.getMenu();
		if (menu.checkItemCodeType(itemCode, type)) {
			invoker.addOrders(itemCode);
			return "Order # " + itemCode + " Added";
		} else {
			return "Item # is not on the  " + menu.getState().toString() + "Menu";
		}
	}

	public static String makeMeal(int[] itemCodes) {
		Meal meal = invoker.makeMeal(itemCodes);

		return meal.toString();
	}

	public static String[] printTab() {
		Tab tab = invoker.getTab();
		String item;
		fillTab();
		Iterator<String> tabItr = tab.iterator();
		int i = 0;
		String[] lines = new String[tab.getTotal()];
		while (tabItr.hasNext()) {
			item = tabItr.next();
			lines[i] = item;
			i++;
		}
		tab.clearTab();

		return lines;
	}

	public static void fillTab() {
		Tab tab = invoker.getTab();
		Menu menu = invoker.getMenu();
		Meals meals = invoker.getMeals();
		Orders order = invoker.getOrders();

		tab.fillList(meals, menu, order);
	}

	public static String[] calcTotal() {
		Tab tab = invoker.getTab();
		Menu menu = invoker.getMenu();
		Meals meals = invoker.getMeals();
		Orders order = invoker.getOrders();
		String[] lines = new String[1];
		lines[0] = tab.calcTotal(meals, menu, order);

		return lines;
	}


}
