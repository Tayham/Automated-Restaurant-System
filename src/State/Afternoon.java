package State;

public class Afternoon implements State {

	public void timeOfDay(StateContext context) {
		context.setState(new Afternoon());
	}
	@Override
	public void displayState() {
		System.out.println("Lunch Menu Selected");
	}

	public String toString() {
		return "Lunch";
	}

}
