package christmas.Constant;

public enum DateKind {
    WEEKDAY("weekday"),
    WEEKEND("weekend"),
    STAR_DAY("starDay");

    private final String kind;
    DateKind(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }
}
