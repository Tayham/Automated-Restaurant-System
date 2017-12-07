package State;

import Aggregations.Menu;

public class Morning implements State {

	@Override
	public void updateTime(int i, Menu menu) {
		if (i == 2)
			menu.setState(new Afternoon());
		else if (i == 3)
			menu.setState(new Evening());
		else
			menu.setState(this);
	}

	public void displayState() {
		System.out.println("Breakfast Menu Selected");
	}

	public String toString() {
		return "Breakfast";
	}

}
