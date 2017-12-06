package Command;

import Invoker.Menu;
import Invoker.Orders;
import Invoker.Tab;

public class Aggregator {

    private Menu menu;
    private Orders orders;
    private Tab tab;

    public Aggregator(Menu menu, Orders orders, Tab tab) {
        this.menu = menu;
        this.orders = orders;
        this.tab = tab;
    }

    public Menu getMenu() {
        return menu;
    }

    public Orders getOrders() {
        return orders;
    }

    public Tab getTab() {
        return tab;
    }

}
