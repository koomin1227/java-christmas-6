package christmas.Domain;

import christmas.Constant.ErrorMessage;
import christmas.Constant.Menu;

import java.util.Arrays;
import java.util.List;

public class Order {
    private static final int MIN_ORDER_BOUND = 1;
    private Menu menu;
    private int count;

    public Order(String input) {
        validateOrder(input);
    }

    private void validateOrder(String input) {
        String[] inputs = input.split("-");
        if (inputs.length != 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
        validateMenu(inputs[0]);
        validateCount(inputs[1]);

    }

    private void validateMenu(String input) {
        List<Menu> filteredMenu =  Arrays.stream(Menu.values()).filter(menu -> menu.getName().equals(input)).toList();
        if (filteredMenu.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
        this.menu = filteredMenu.get(0);
    }

    private void validateCount(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
        int count = Integer.parseInt(input);
        if (count < MIN_ORDER_BOUND) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
        this.count = count;
    }


    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }
}
