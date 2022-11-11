package lotto;

import lotto.Validator.InputMoneyValidator;
import lotto.controller.WeeklyLottoController;

public class Application {

    private static final WeeklyLottoController weeklyLotto = new WeeklyLottoController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        weeklyLotto.run();
    }
}
