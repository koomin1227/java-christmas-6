package christmas;

import christmas.Domain.Date;
import christmas.Domain.OrderList;
import christmas.View.InputView;
import christmas.View.OutputView;

public class ChristmasController {
    private Date date;
    private OrderList orderList;
    public void run() {
        inputOrderInfo();
        outputMenu();
    }

    private void outputMenu() {
        OutputView.printMenu(orderList);
    }

    private void inputOrderInfo() {
        OutputView.printWelcomeMessage();
        this.date = InputView.readDate();
        this.orderList = InputView.readOrder();
        OutputView.printInfoMessage();
    }
}
