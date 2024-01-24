package christmas;

import christmas.Domain.Date;
import christmas.Domain.Event;
import christmas.Domain.OrderList;
import christmas.View.InputView;
import christmas.View.OutputView;

public class ChristmasController {
    private Date date;
    private OrderList orderList;
    public void run() {
        inputOrderInfo();
        outputOrderInfo();
        outputBenefit();
    }

    private void outputOrderInfo() {
        OutputView.printMenu(orderList);
        OutputView.printPriceBeforeDiscount(orderList);
    }

    private void inputOrderInfo() {
        OutputView.printWelcomeMessage();
        this.date = InputView.readDate();
        this.orderList = InputView.readOrder();
        OutputView.printInfoMessage();
    }

    private void outputBenefit() {
        Event event = new Event(date, orderList);
        OutputView.printPresentation(event.getBenefitList());
        OutputView.printBenefitList(event.getBenefitList());
        OutputView.printTotalBenefit(event.getTotalBenefit());
        OutputView.printTotalPrice(event.getTotalPrice());
        OutputView.printBadge(event.getBadge());
    }
}
