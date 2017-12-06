package State;

public class Morning implements State {
	@Override
	public void displayState() {
		System.out.println("Breakfast Menu Selected");
	}
	public String toString() {
		return "Breakfast";
	}

}
