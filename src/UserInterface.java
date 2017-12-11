import System.SystemInterface;

import java.util.Scanner;

class UserInterface {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String todPrompt = "Please select what time of day it is: \n1 - Morning\n2 - Lunchtime\n3 - Dinnertime";
		String menuPrompt = "1 - Display Menu\n2 – Add Order\n3 - Select a Special Meal and Add to Order \n4 – Print Tab\n5 – Change Time of Day\n0 – EXIT";
		String inputPrompt = "Please enter your option:";
		String orderPrompt = "Please enter the order number (0 To Exit): ";
		String tabPrompt = "Total:\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
		String mealPrompt = "1 - Nice Meal \n2 – PanBrown Meal\n3 - Spaghetti Meal";
		SystemInterface.init();
		SystemInterface.setMenuState(menu(todPrompt, inputPrompt, 3, 1));


		boolean exit = false;
		do {
			int selection = menu(menuPrompt, inputPrompt, 5, 0);
			switch (selection) {
				case 0: //EXIT
					exit = true;
					break;
				case 1: //Print Menu
					printMenu();
					break;
				case 2: //Add Order
					addOrder(orderPrompt, input);
					break;
				case 3: //Make Meal and Add to Order
					System.out.println(SystemInterface.makeMeal(menu(mealPrompt, inputPrompt, 3, 1)));
					break;
				case 4: //Print Tab
					printTab(tabPrompt);
					break;
				case 5: //Change Time of Day
					SystemInterface.setMenuState(menu(todPrompt, inputPrompt, 3, 1));
					break;
			}
		} while (!exit);
	}

	private static void printMenu() {
		for (String output : SystemInterface.printMenu()) {
			System.out.print(output);
		}
	}

	private static void printTab(String prompt) {
		System.out.println(prompt);
		for (String output : SystemInterface.printTab()) {
			System.out.print(output);
		}
		System.out.println(SystemInterface.calcTotal());
	}

	private static void addOrder(String inputPrompt, Scanner console) {
		for (; ; ) {
			printMenu();
			System.out.println(inputPrompt);
			int selection = console.nextInt();
			if (selection == 0)
				return;
			SystemInterface.addOrder(selection);
		}
	}

	private static int menu(String menuOptions, String inputPrompt, int max, int min) {
		System.out.println("\nYour options are:\n-----------------");
		System.out.println(menuOptions);
		Scanner console = new Scanner(System.in);

		int input;
		for (input = getInt(console, inputPrompt); min > input || input > max; input = getInt(console, inputPrompt)) {
			System.out.println(input + " is not a valid option");
		}
		return input;
	}

	private static int getInt(Scanner input, String prompt) {
		System.out.println(prompt);
		while (!input.hasNextInt()) {
			input.next(); //consume
			System.out.println("Not an integer. Try again!");
			System.out.println(prompt);
		}
		return input.nextInt();
	}

}
