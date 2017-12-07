package State;

public class Afternoon implements State {

	public void timeOfDay(StateContext context) {
		context.setState(new Afternoon());
	}
	@Override
	public void displayState() {
		System.out.println("Lunch Menu Selected");
	}
	
// 	public State time(String s){
// 		if (s.equals("Morning")
// 		    menu.setState(new Morning());
// 	}

	public String toString() {
		return "Lunch";
	}

}
