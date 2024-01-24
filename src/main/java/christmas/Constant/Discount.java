package christmas.Constant;

public enum Discount {
    WEEKDAY_DISCOUNT("평일 할인", 2023),
    WEEKEND_DISCOUNT("주말 할인", 2023),
    STAR_DAY_DISCOUNT("특별 할인", 1000),
    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인", 1000),
    PRESENTATION("증정 이벤트", 25000);


    private final String name;
    private final int discountPrice;

    Discount(String name, int discountPrice) {
        this.name = name;
        this.discountPrice = discountPrice;
    }

    public String getName() {
        return name;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
