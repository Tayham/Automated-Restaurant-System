package Command;

import Invoker.Orders;

public class CMDGetOrders implements Command {

    private Aggregator agg;

    public CMDGetOrders(Aggregator agg) {
        this.agg = agg;
    }

    public Orders execute() {
        return agg.getOrders();
    }
}
