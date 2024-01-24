package christmas.View;

import christmas.Domain.Event;
import christmas.Domain.Order;
import christmas.Domain.OrderList;

import java.text.DecimalFormat;
import java.util.HashMap;

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

    public static void printPresentation(HashMap<String, Integer> benefitList) {
        System.out.println("\n<증정 메뉴>");
        if (benefitList.containsKey("증정 이벤트")) {
            System.out.println("샴페인 1개");
        } else {
            System.out.println("없음");
        }
    }

    public static void printBenefitList(HashMap<String, Integer> benefitList) {
        System.out.println("\n<혜택 내역>");
        if (benefitList.isEmpty()) {
            System.out.println("없음");
            return;
        }
        for (String key : benefitList.keySet()) {
            String price = formatNumberWithComma(benefitList.get(key));
            System.out.printf("%s: -%s원\n", key, price);
        }
    }

    public static void printTotalBenefit(int totalBenefit) {
        System.out.println("\n<총혜택 금액>");
        if (totalBenefit == 0) {
            System.out.println("0원");
            return;
        }
        String price = formatNumberWithComma(totalBenefit);
        System.out.printf("-%s원\n", price);
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        String price = formatNumberWithComma(totalPrice);
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