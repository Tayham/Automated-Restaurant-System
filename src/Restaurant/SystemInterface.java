package Restaurant;

import Command.Invoker;
import Invoker.Menu;
import Invoker.MenuItem;
import Invoker.Orders;
import Invoker.Tab;
import State.Afternoon;
import State.Evening;
import State.Morning;
import Invoker.MenuItemType;

import java.util.ArrayList;
import java.util.Iterator;

public class SystemInterface {

	public static Invoker invoker;

	public static void init() {
		invoker = new Invoker(new Menu(), new Orders(), new Tab());
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
		Orders order = invoker.getOrders();

		tab.fillList(menu, order);
	}

	public static String[] calcTotal() {
		Tab tab = invoker.getTab();
		Menu menu = invoker.getMenu();
		Orders order = invoker.getOrders();
		String[] lines = new String[1];
		lines[0] = tab.calcTotal(menu, order);

		return lines;
	}


}
