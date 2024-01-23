package christmas.View;

import christmas.Domain.Order;
import christmas.Domain.OrderList;

public class OutputView {
    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printInfoMessage() {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printMenu(OrderList orderList) {
        System.out.println("\n<주문 메뉴>");
        for ( Order order : orderList.getOrders()) {
            System.out.printf("%s %d개\n", order.getMenu().getName(), order.getCount());
        }
    }
}