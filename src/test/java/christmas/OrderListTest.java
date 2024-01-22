package christmas;

import christmas.Domain.Order;
import christmas.Domain.OrderList;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

public class OrderListTest {
    @Test
    void 정상_주문인_경우() {
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        List<Order> orders = Arrays.stream(input.split(",")).map(Order::new).toList();
        new OrderList(orders);
    }

    @Test
    void 중복_주문인_경우() {
        String input = "티본스테이크-1,초코케이크-1,초코케이크-2,제로콜라-1";
        List<Order> orders = Arrays.stream(input.split(",")).map(Order::new).toList();
        assertThatThrownBy(() -> new OrderList(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 개수가_20초과의_주문인_경우() {
        String input = "티본스테이크-1,초코케이크-20,바비큐립-2,제로콜라-1";
        List<Order> orders = Arrays.stream(input.split(",")).map(Order::new).toList();
        assertThatThrownBy(() -> new OrderList(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음료수만_주문한_경우() {
        String input = "제로콜라-1,레드와인-3";
        List<Order> orders = Arrays.stream(input.split(",")).map(Order::new).toList();
        assertThatThrownBy(() -> new OrderList(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 총_금액_확인() {
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        List<Order> orders = Arrays.stream(input.split(",")).map(Order::new).toList();
        OrderList orderList = new OrderList(orders);
        assertThat(orderList.getTotalPrice()).isEqualTo(142_000);
    }
}
