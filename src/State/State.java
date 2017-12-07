package State;

import Aggregations.Menu;

public interface State {

	void updateTime(int i, Menu menu);

	void displayState();

	String toString();

}
