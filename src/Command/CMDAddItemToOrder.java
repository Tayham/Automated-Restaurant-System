package Command;

import Aggregations.Aggregator;
import Aggregations.OrderItem;

public class CMDAddItemToOrder implements Command {
	private final Aggregator aggregator;
	private final int itemId;

	public CMDAddItemToOrder(Aggregator aggregator, int itemId) {
		this.aggregator = aggregator;
		this.itemId = itemId;
	}

	public OrderItem execute() {
		OrderItem order = new OrderItem(itemId);
		aggregator.getOrders().addOrder(order);
		return order;
	}
}
