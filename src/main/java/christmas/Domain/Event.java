package christmas.Domain;

import java.util.HashMap;
import static christmas.Constant.DateKind.*;
import static christmas.Constant.Category.*;
import static christmas.Constant.Badge.*;
import static christmas.Constant.Discount.*;

public class Event {
    private static final int PRESENTATION_BOUND = 120000;
    private static final int EVENT_THRESHOLD = 10000;
    private static final int CHRISTMAS_DAY = 25;
    private int totalBenefit = 0;
    private int totalDiscount = 0;
    private final int totalPrice;

    private final HashMap<String, Integer> benefitList = new HashMap<>();
    public Event(Date date, OrderList orderList) {
        if (orderList.getTotalPrice() > EVENT_THRESHOLD){
            setPresentation(orderList.getTotalPrice());
            setDiscount(date, orderList);
        }
        this.totalPrice = orderList.getTotalPrice() - totalDiscount;
    }

    private void setDiscount(Date date, OrderList orderList) {
        setChristmasDiscount(date);
        setWeekdayDiscount(date, orderList);
        setWeekendDiscount(date, orderList);
        setStarDayDiscount(date);
    }

    private void setPresentation(int totalPrice) {
        if (totalPrice >= PRESENTATION_BOUND) {
            totalBenefit += PRESENTATION.getDiscountPrice();
            benefitList.put(PRESENTATION.getName(), PRESENTATION.getDiscountPrice());
        }
    }

    private void setChristmasDiscount(Date date) {
        if (date.getDate() <= CHRISTMAS_DAY) {
            int discountPrice = CHRISTMAS_DISCOUNT.getDiscountPrice() + (date.getDate() - 1) * 100;
            totalBenefit += discountPrice;
            totalDiscount += discountPrice;
            benefitList.put(CHRISTMAS_DISCOUNT.getName(), discountPrice);
        }
    }

    private void setWeekdayDiscount(Date date, OrderList orderList) {
        if (date.getKind().contains(WEEKDAY.getKind())) {
            int discountPrice = 0;
            for ( Order order : orderList.getOrders() ) {
                if (order.getMenu().getCategory().equals(DESSERT)) {
                    discountPrice += WEEKDAY_DISCOUNT.getDiscountPrice() * order.getCount();
                }
            }
            totalBenefit += discountPrice;
            totalDiscount += discountPrice;
            benefitList.put(WEEKDAY_DISCOUNT.getName(), discountPrice);
        }
    }

    private void setWeekendDiscount(Date date, OrderList orderList) {
        if (date.getKind().contains(WEEKEND.getKind())) {
            int discountPrice = 0;
            for ( Order order : orderList.getOrders() ) {
                if (order.getMenu().getCategory().equals(MAIN)) {
                    discountPrice += WEEKEND_DISCOUNT.getDiscountPrice() * order.getCount();
                }
            }
            totalBenefit += discountPrice;
            totalDiscount += discountPrice;
            benefitList.put(WEEKEND_DISCOUNT.getName(), discountPrice);
        }
    }

    private void setStarDayDiscount(Date date) {
        if (date.getKind().contains(STAR_DAY.getKind())) {
            int discountPrice = STAR_DAY_DISCOUNT.getDiscountPrice();
            totalBenefit += discountPrice;
            totalDiscount += discountPrice;
            benefitList.put(STAR_DAY_DISCOUNT.getName(), discountPrice);
        }
    }

    public int getTotalBenefit() {
        return totalBenefit;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public HashMap<String, Integer> getBenefitList() {
        return benefitList;
    }

    public String getBadge() {
        if (totalBenefit > SANTA.getPrice()) {
            return SANTA.getName();
        }
        if (totalBenefit > TREE.getPrice()) {
            return TREE.getName();
        }
        if (totalBenefit > STAR.getPrice()) {
            return STAR.getName();
        }
        return null;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
