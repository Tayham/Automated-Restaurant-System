package State;

public class Afternoon implements State {
	@Override
	public void displayState() {
		System.out.println("Lunch Menu Selected");
	}

	public String toString() {
		return "Lunch";
	}

}
