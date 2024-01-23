package christmas.Domain;

import christmas.Constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static christmas.Constant.Category.DRINK;

public class OrderList {
    private static final int MAX_ORDER_BOUND = 20;
    private int totalPrice = 0;
    private final List<Order> orders;

    public OrderList(List<Order> orders) {
        validateOrders(orders);
        this.orders = orders;
    }

    private void validateOrders(List<Order> orders) {
        int totalMenuCount = 0;
        boolean isAllDrink = true;
        for(Order order : orders) {
            if (isDuplicate(orders, order.getMenu().getName())) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
            }
            if (!order.getMenu().getCategory().equals(DRINK)) {
                isAllDrink = false;
            }
            totalMenuCount += order.getCount();
            totalPrice += order.getMenu().getPrice() * order.getCount();
        }
        if (isAllDrink) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
        if (totalMenuCount > MAX_ORDER_BOUND) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private boolean isDuplicate(List<Order> orders, String menu) {
        return orders.stream().
                filter(order -> order.getMenu().getName().equals(menu))
                .toList().size() > 1;
    }


    public int getTotalPrice() {
        return totalPrice;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
