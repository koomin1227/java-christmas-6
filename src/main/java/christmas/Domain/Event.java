package christmas.Domain;

import java.util.HashMap;

public class Event {
    private static final int PRESENTATION_BOUND = 120000;
    private int totalBenefit = 0;
    private int totalDiscount = 0;
    private HashMap<String, Integer> benefitList = new HashMap<>();
    Event(Date date, OrderList orderList) {
        if (orderList.getTotalPrice() > 10000){
            setPresentation(orderList.getTotalPrice());
            setDiscount(date, orderList);
        }
    }

    private void setDiscount(Date date, OrderList orderList) {
        setChristmasDiscount(date);
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

}
