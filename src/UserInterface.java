import Invoker.MenuItemType;
import Restaurant.SystemInterface;

import java.util.Scanner;

import static Invoker.MenuItemType.*;

public class UserInterface {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		SystemInterface systemInterface = new SystemInterface();
		String todPrompt = "Please select what time of day it is: \n1 - Morning\n2 - Lunchtime\n3 - Dinnertime";
		String menuPrompt = "1 - Display Menu\n2 – Add Order\n3 - Make Meal and Add to Order (Meals have a 5% discount) \n4 – Print Tab\n0 – EXIT";
		String inputPrompt = "Please enter your option:";
		String orderPrompt = "Please enter the order number (0 To Exit): ";
		SystemInterface.init();
		SystemInterface.setMenuState(menu(todPrompt, inputPrompt, 0, 3));


		boolean exit = false;

		do {
			int selection = menu(menuPrompt, inputPrompt, 0, 4);
			switch (selection) {
				case 0: //EXIT
					exit = true;
					break;
				case 1: //Print Menu
					printMenu(systemInterface);
					break;
				case 2: //Add Order
					addOrder(0, orderPrompt, console, systemInterface);
					break;
				case 3: //Make Meal and Add to Order
					addMeal(console, systemInterface);
					break;
				case 4: //Print Tab
					printTab();
					break;
			}
		} while (!exit);
	}


	public static void printMenu(SystemInterface systemInterface) {
		for (String lines : SystemInterface.printMenu()) {
			System.out.print(lines);
			System.out.println(" ");
		}
	}

	public static void printMenuType(MenuItemType type, SystemInterface systemInterface) {
		for (String lines : SystemInterface.printMenuType(type)) {
			System.out.print(lines);
			System.out.println(" ");
		}
	}

	public static void addOrder(int exitInt, String inputPrompt, Scanner console, SystemInterface systemInterface) {
		for (; ; ) {
			printMenu(systemInterface);
			System.out.println(inputPrompt);
			int selection = console.nextInt();
			if (selection == exitInt)
				return;
			SystemInterface.addOrder(selection);
		}
	}

	public static void addMeal(Scanner input, SystemInterface systemInterface) {
		int[] selections = new int[3];
		printMenuType(ENTREE, systemInterface);
		selections[0] = getValidOrder(input, ENTREE);
		printMenuType(SIDE, systemInterface);
		selections[1] = getValidOrder(input, SIDE);
		printMenuType(DRINK, systemInterface);
		selections[2] = getValidOrder(input, DRINK);
		System.out.println(SystemInterface.makeMeal(selections));

	}

	private static int getValidOrder(Scanner input, MenuItemType type) {
		{
			System.out.println("Select a " + type.toString());
			while (!input.hasNextInt()) {
				input.next(); //consume
				System.out.println("Not an integer or a valid order selection");
				System.out.println("Select a " + type.toString());

			}
			return input.nextInt();
		}
	}


	public static void printTab() {
		System.out.println("Your Bill: ");
		System.out.println("________________________");
		for (String lines : SystemInterface.printTab()) {
			System.out.println(lines);
			System.out.println(" ");
		}
		System.out.println(SystemInterface.calcTotal()[0]);
	}

	private static int menu(String menuOptions, String inputPrompt, int min, int max) {
		System.out.println("\nYour options are:\n-----------------");
		System.out.println(menuOptions);
		Scanner console = new Scanner(System.in);

		int input;
		for (input = getInt(console, inputPrompt); min > input || input > max; input = getInt(console, inputPrompt)) {
			System.out.println(input + " is not a valid option");
		}

		return input;
	}

	public static int getInt(Scanner input, String prompt) {
		System.out.println(prompt);
		while (!input.hasNextInt()) {
			input.next(); //consume
			System.out.println("Not an integer. Try again!");
			System.out.println(prompt);
		}
		return input.nextInt();
	}


}
