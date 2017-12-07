package Command;

import Aggregations.Aggregator;
import Aggregations.Orders;

public class CMDGetOrders implements Command {

	private final Aggregator aggregator;

	public CMDGetOrders(Aggregator aggregator) {
		this.aggregator = aggregator;
	}

	public Orders execute() {
		return aggregator.getOrders();
	}
}
