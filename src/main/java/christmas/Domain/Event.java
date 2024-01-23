package christmas.Domain;

import java.util.HashMap;
import static christmas.Constant.DateKind.*;
import static christmas.Constant.Category.*;

public class Event {
    private static final int PRESENTATION_BOUND = 120000;
    private int totalBenefit = 0;
    private int totalDiscount = 0;

    private final HashMap<String, Integer> benefitList = new HashMap<>();
    public Event(Date date, OrderList orderList) {
        if (orderList.getTotalPrice() > 10000){
            setPresentation(orderList.getTotalPrice());
            setDiscount(date, orderList);
        }
    }

    private void setDiscount(Date date, OrderList orderList) {
        setChristmasDiscount(date);
        setWeekdayDiscount(date, orderList);
        setWeekendDiscount(date, orderList);
        setStarDayDiscount(date);
    }

    private void setPresentation(int totalPrice) {
        if (totalPrice >= PRESENTATION_BOUND) {
            totalBenefit += 25000;
            benefitList.put("증정 이벤트", 25000);
        }
    }

    private void setChristmasDiscount(Date date) {
        if (date.getDate() <= 25) {
            int discountPrice = 1000 + (date.getDate() - 1) * 100;
            totalBenefit += discountPrice;
            totalDiscount += discountPrice;
            benefitList.put("크리스마스 디데이 할인", discountPrice);
        }
    }

    private void setWeekdayDiscount(Date date, OrderList orderList) {
        if (date.getKind().contains(WEEKDAY.getKind())) {
            int discountPrice = 0;
            for ( Order order : orderList.getOrders() ) {
                if (order.getMenu().getCategory().equals(DESSERT)) {
                    discountPrice += 2023 * order.getCount();
                }
            }
            totalBenefit += discountPrice;
            totalDiscount += discountPrice;
            benefitList.put("평일 할인", discountPrice);
        }
    }

    private void setWeekendDiscount(Date date, OrderList orderList) {
        if (date.getKind().contains(WEEKEND.getKind())) {
            int discountPrice = 0;
            for ( Order order : orderList.getOrders() ) {
                if (order.getMenu().getCategory().equals(MAIN)) {
                    discountPrice += 2023 * order.getCount();
                }
            }
            totalBenefit += discountPrice;
            totalDiscount += discountPrice;
            benefitList.put("주말 할인", discountPrice);
        }
    }

    private void setStarDayDiscount(Date date) {
        if (date.getKind().contains(STAR_DAY.getKind())) {
            int discountPrice = 1000;
            totalBenefit += discountPrice;
            totalDiscount += discountPrice;
            benefitList.put("특별 할인", discountPrice);
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
}
