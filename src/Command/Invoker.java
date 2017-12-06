package Command;

import Invoker.*;

public class Invoker {

    private Aggregator agg;

    public Invoker(Menu menu, Orders order, Tab tab) {
        agg = new Aggregator(menu, order, tab);
    }
    public OrderItem addOrders(int itemNum) {
        return new CMDAddItemToOrder(agg, itemNum).execute();
    }

    public Orders getOrders() {
        return new CMDGetOrders(agg).execute();
    }

    public Menu getMenu() {
        return new CMDGetMenu(agg).execute();
    }

    public Tab getTab() {
        return new CMDGetTab(agg).execute();
    }

}
