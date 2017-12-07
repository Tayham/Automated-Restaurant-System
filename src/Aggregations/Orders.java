package Aggregations;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class Orders {

	private final ArrayList<OrderItem> orders;

	public Orders() {
		orders = new ArrayList();
	}

	public void addOrder(OrderItem order) {
		orders.add(order);
	}

	public OrderItem getOrder(int id) {
		return orders.get(id);
	}

	public int getOrderLength() {
		return orders.size();
	}
}
