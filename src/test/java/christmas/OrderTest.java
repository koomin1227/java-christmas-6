package christmas;

import org.junit.jupiter.api.Test;
import christmas.Domain.Order;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {
    @Test
    void 정상적인_주문인_경우() {
        String input = "시저샐러드-1";
        Order order = new Order(input);
    }

    @Test
    void 주문형식이_맞지_않는_경우() {
        String input1 = "시저샐러드--1";
        assertThatThrownBy(() -> new Order(input1))
                .isInstanceOf(IllegalArgumentException.class);
        String input2 = "시저샐러드1";
        assertThatThrownBy(() -> new Order(input2))
                .isInstanceOf(IllegalArgumentException.class);
        String input3 = "시저샐러드-1-3";
        assertThatThrownBy(() -> new Order(input3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 없는_메뉴를_주문하는_경우() {
        String input = "배달-1";
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 옳지_않는_수량으로_주문한_경우() {
        String input = "시저샐러드-0";
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
