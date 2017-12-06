package Command;

import Invoker.*;

public class CMDAddItemToOrder implements Command {
    private Aggregator agg;
    private int itemNum;

    public CMDAddItemToOrder(Aggregator agg, int itemNum) {
        this.agg = agg;
        this.itemNum = itemNum;
    }

    public OrderItem execute() {
        OrderItem order = new OrderItem(itemNum);
        agg.getOrders().addOrder(order);
        return order;
    }
}
