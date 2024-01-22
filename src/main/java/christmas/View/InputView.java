package christmas.View;

import camp.nextstep.edu.missionutils.Console;
import christmas.Constant.ErrorMessage;

public class InputView {
    private static final int START_DATE = 1;
    private static final int END_DATE = 31;
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        validateDate(input);
        return Integer.parseInt(input);
    }

    private void validateDate(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
        int date = Integer.parseInt(input);
        if (date < START_DATE || date > END_DATE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }

    private boolean isNumeric(String input) {
        return input.matches("\\\\d+");
    }
}
