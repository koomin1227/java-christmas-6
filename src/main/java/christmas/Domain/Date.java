package christmas.Domain;

import christmas.Constant.ErrorMessage;

public class Date {
    private static final int START_DATE = 1;
    private static final int END_DATE = 31;
    private int date;
    public Date(String date) {
        validateDate(date);
        this.date = Integer.parseInt(date);
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
        return input.matches("\\d+");
    }
}
