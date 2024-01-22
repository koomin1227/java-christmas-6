package christmas.Constant;

import static christmas.Constant.Category.*;

public enum Menu {
    MUSHROOM_SOUP(APPETIZER, 6_000, "양송이수프"),
    TAPAS(APPETIZER, 5_500, "타파스"),
    CAESAR_SALAD(APPETIZER, 8_000, "시저샐러드"),
    T_BONE_STEAK(MAIN, 55_000, "티본스테이크"),
    BBQ_RIBS(MAIN, 54_000, "바비큐립"),
    SEAFOOD_PASTA(MAIN, 35_000, "해산물파스타"),
    CHRISTMAS_PASTA(MAIN, 25_000, "크리스마스파스타"),
    CHOCOLATE_CAKE(DESSERT, 15_000, "초코케이크"),
    ICE_CREAM(DESSERT, 5_000, "아이스크림"),
    ZERO_COLA(DRINK, 3_000, "제로콜라"),
    RED_WINE(DRINK, 60_000, "레드와인"),
    CHAMPAGNE(DRINK, 25_000, "샴페인");

    private final Category category;
    private final int price;
    private final String name;

    Menu(Category category, int price, String name) {
        this.category = category;
        this.price = price;
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
