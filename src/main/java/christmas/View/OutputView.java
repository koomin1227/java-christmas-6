package christmas.View;

import christmas.Domain.Event;
import christmas.Domain.Order;
import christmas.Domain.OrderList;

import java.text.DecimalFormat;

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

    public static void printPriceBeforeDiscount(OrderList orderList) {
        System.out.println("\n<할인 전 총주문 금액>");
        String price = formatNumberWithComma(orderList.getTotalPrice());
        System.out.printf("%s원", price);
    }

    public static String formatNumberWithComma(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }

    public static void printPresentation(Event event) {
        System.out.println("\n<증정 메뉴>");
        if (event.getBenefitList().containsKey("증정 이벤트")) {
            System.out.println("샴페인 1개");
        } else {
            System.out.println("없음");
        }
    }

    public static void printBenefitList(Event event) {
        System.out.println("\n<혜택 내역>");
        if (event.getBenefitList().isEmpty()) {
            System.out.println("없음");
            return;
        }
        for (String key : event.getBenefitList().keySet()) {
            String price = formatNumberWithComma(event.getBenefitList().get(key));
            System.out.printf("%s: -%s원\n", key, price);
        }
    }

    public static void printTotalBenefit(Event event) {
        System.out.println("\n<총혜택 금액>");
        if (event.getTotalBenefit() == 0) {
            System.out.println("0원");
            return;
        }
        String price = formatNumberWithComma(event.getTotalBenefit());
        System.out.printf("-%s원\n", price);
    }

    public static void printTotalPrice(Event event, OrderList orderList) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        String price = formatNumberWithComma(orderList.getTotalPrice() - event.getTotalDiscount());
        System.out.printf("%s원\n", price);
    }

    public static void printBadge(String badge) {
        System.out.println("\n<12월 이벤트 배지>");
        if (badge == null) {
            System.out.println("없음");
            return;
        }
        System.out.println(badge);
    }
}