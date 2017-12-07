package Command;

import Aggregations.Aggregator;
import Aggregations.Tab;

public class CMDGetTab implements Command {
	private final Aggregator aggregator;

	public CMDGetTab(Aggregator aggregator) {
		this.aggregator = aggregator;
	}

	public Tab execute() {
		return aggregator.getTab();
	}
}
