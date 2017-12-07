package State;

public class Evening implements State {
	@Override
	public void timeOfDay(StateContext context) {
		context.setState(new Evening());
	}
	public void displayState() {
		System.out.println("Dinner Menu Selected");
	}

	public String toString() {
		return "Dinner";
	}

}
