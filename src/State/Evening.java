package State;

public class Evening implements State {
	@Override
	public void displayState() {
		System.out.println("Dinner Menu Selected");
	}

	public String toString() {
		return "Dinner";
	}

}
