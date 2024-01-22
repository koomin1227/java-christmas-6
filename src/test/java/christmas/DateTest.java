package christmas;

import christmas.Domain.Date;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DateTest {
    @Test
    void 날짜에_숫자가_아닌_문자가_있는_경우_오류() {
        String input = "abc";
        assertThatThrownBy(() -> new Date(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 날짜가_범위를_벗어나는_경우_오류() {
        String input = "123";
        String finalInput = input;
        assertThatThrownBy(() -> new Date(finalInput))
                .isInstanceOf(IllegalArgumentException.class);

        input = "-1";
        String finalInput1 = input;
        assertThatThrownBy(() -> new Date(finalInput1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Date_객체_생성() {
        String input = "12";
        new Date(input);
    }
}
