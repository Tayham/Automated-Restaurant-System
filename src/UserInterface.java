import Invoker.MenuItemType;
import Restaurant.SystemInterface;

import java.util.Scanner;

import static Invoker.MenuItemType.*;

public class UserInterface {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		SystemInterface systemInterface = new SystemInterface();
		String todPrompt = "Please select what time of day it is: \n1 - Morning\n2 - Lunchtime\n3 - Dinnertime";
		String menuPrompt = "1 - Display Menu\n2 – Add Order\n3 - Make Meal and Add to Order\n4 – Print Tab\n0 – EXIT";
		String inputPrompt = "Please enter your option:";
		String orderPrompt = "Please enter the order number (0 To Exit): ";
		systemInterface.init();
		systemInterface.setMenuState(menu(todPrompt, inputPrompt, 0, 3));


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
					printTab(systemInterface);
					break;
			}
		} while (!exit);
	}


	public static void printMenu(SystemInterface systemInterface) {
		for (String lines : systemInterface.printMenu()) {
			System.out.print(lines);
			System.out.println(" ");
		}
	}

	public static void printMenuType(MenuItemType type, SystemInterface systemInterface) {
		for (String lines : systemInterface.printMenuType(type)) {
			System.out.print(lines);
			System.out.println(" ");
		}
	}

	public static void addOrder(int exitInt, String inputPrompt, Scanner console, SystemInterface systemInterface) {
		for (;;) {
			printMenu(systemInterface);
			System.out.println(inputPrompt);
			int selection = console.nextInt();
			if(selection == exitInt)
				return;
			systemInterface.addOrder(selection);
		}
	}

	public static void addMeal( Scanner console, SystemInterface systemInterface) {
			System.out.println("Select an Entree");
			printMenuType(ENTREE, systemInterface);
			int selection = console.nextInt();
			systemInterface.addOrder(selection);

			System.out.println("Select a Side");
			printMenuType(SIDE, systemInterface);
			selection = console.nextInt();
			systemInterface.addOrder(selection);

			System.out.println("Select an Drink");
			printMenuType(DRINK, systemInterface);
			selection = console.nextInt();
			systemInterface.addOrder(selection);

	}



	public static void printTab(SystemInterface systemInterface) {
		System.out.println("Your Bill: ");
		System.out.println("________________________");
		for (String lines : systemInterface.printTab()) {
			System.out.println(lines);
			System.out.println(" ");
		}
		System.out.println(systemInterface.calcTotal()[0]);
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

	public static int getIntRange(Scanner input, String prompt, int MAX, int LOW) {
		int x = getInt(input, prompt);
		while (x > MAX || x < LOW) {
			System.out.println("INPUT ERROR!!! Invalid size. Positive and <= 20.");
			x = getInt(input, prompt);
		}
		return x;
	}

}
