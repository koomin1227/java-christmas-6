package christmas.View;

import camp.nextstep.edu.missionutils.Console;
import christmas.Domain.Date;
import christmas.Domain.Order;
import christmas.Domain.OrderList;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static Date readDate() {
        while (true) {
            try{
                System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
                String input = Console.readLine();
                Date date = new Date(input);
                return date;
            } catch(IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage() + " 다시 입력해 주세요.");
            }
        }
    }

    public static OrderList readOrder() {
        while (true) {
            try{
                System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
                String input = Console.readLine();
                List<Order> orders = Arrays.stream(input.split(",")).map(Order::new).toList();
                return new OrderList(orders);
            } catch(IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage() + " 다시 입력해 주세요.");
            }
        }
    }
}
