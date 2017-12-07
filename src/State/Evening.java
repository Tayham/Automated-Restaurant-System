package State;

import Aggregations.Menu;

public class Evening implements State {

	@Override
	public void updateTime(int i, Menu menu) {
		if (i == 1)
			menu.setState(new Morning());
		else if (i == 2)
			menu.setState(new Afternoon());
		else
			menu.setState(this);
	}

	public void displayState() {
		System.out.println("Dinner Menu Selected");
	}

	public String toString() {
		return "Dinner";
	}

}
