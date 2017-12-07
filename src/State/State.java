package State;

public interface State {

	void timeOfDay(StateContext context);

	void displayState();

	String toString();

}
