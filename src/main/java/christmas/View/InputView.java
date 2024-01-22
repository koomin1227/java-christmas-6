package christmas.View;

import camp.nextstep.edu.missionutils.Console;
import christmas.Domain.Date;

public class InputView {
    public static Date readDate() {
        while (true) {
            try{
                System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
                String input = Console.readLine();
                Date date = new Date(input);
                return date;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage() + " 다시 입력해 주세요.");
            }
        }
    }
}
