package Command;

import Aggregations.Aggregator;
import Aggregations.Menu;

public class CMDGetMenu implements Command {

	private final Aggregator aggregator;

	public CMDGetMenu(Aggregator aggregator) {
		this.aggregator = aggregator;
	}

	public Menu execute() {
		return aggregator.getMenu();
	}
}
