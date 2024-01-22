package christmas.Domain;

import christmas.Constant.DateKind;
import christmas.Constant.DateKindList;
import christmas.Constant.ErrorMessage;

public class Date {
    private static final int START_DATE = 1;
    private static final int END_DATE = 31;
    private int date;
    private String kind;

    public Date(String date) {
        validateDate(date);
        this.date = Integer.parseInt(date);
        setKind();
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

    private void setKind() {
        if (isInList(DateKindList.STAR_DAY_LIST.getDayList())) {
            this.kind = DateKind.STAR_DAY.getKind();
            return;
        }
        if (isInList(DateKindList.WEEKEND_LIST.getDayList())) {
            this.kind = DateKind.WEEKEND.getKind();
            return;
        }
        this.kind = DateKind.WEEKDAY.getKind();
    }

    private boolean isInList(int [] list) {
        for (int date : list) {
            if (this.date == date) {
                return true;
            }
        }
        return false;
    }

    public String getKind() {
        return kind;
    }
}
