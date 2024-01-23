package christmas.Constant;

public enum DateKindList {
    WEEKDAY_LIST(new int[]{3,4,5,6,7,10,11,12,13,14,17,18,19,20,21,24,25,26,27,28,31}),
    WEEKEND_LIST(new int[]{1,2,8,9,15,16,22,23,29,30}),
    STAR_DAY_LIST(new int[]{3,10,17,24,25,31});


    private final int[] dayList;
    DateKindList(int[] dayList) {
        this.dayList = dayList;
    }

    public int[] getDayList() {
        return dayList;
    }
}
