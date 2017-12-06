package Invoker;

import java.util.*;

public class Orders {

    private ArrayList<OrderItem> orders;

    public Orders() {
        orders = new ArrayList();
    }

    public void addOrder(OrderItem order) {
        orders.add(order);
    }

    public OrderItem getOrderItem(int x){
        OrderItem item;
        item = orders.get(x);
        return item;
    }

    public int getTotalOrders() {
        return orders.size();
    }

    public Iterator<OrderItem> iterator() {
        return new OrderIterator();
    }

    private class OrderIterator implements Iterator<OrderItem> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return !(index >= orders.size() || orders.get(index) == null);
        }

        @Override
        public OrderItem next() {
            return orders.get(index++);
        }
    }
}
