package State;

import Aggregations.Menu;

public class Afternoon implements State {


	@Override
	public void displayState() {
		System.out.println("Lunch Menu Selected");
	}

	public void updateTime(int i, Menu menu) {
		if (i == 1)
			menu.setState(new Morning());
		else if (i == 3)
			menu.setState(new Evening());
		else
			menu.setState(this);

	}

	public String toString() {
		return "Lunch";
	}

}
