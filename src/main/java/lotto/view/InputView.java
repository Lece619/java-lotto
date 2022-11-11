package lotto.view;

import lotto.Validator.InputMoneyValidator;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    private final OutputView outputView = new OutputView();
    private final InputMoneyValidator inputMoneyValidator = new InputMoneyValidator();

    public String purchaseMoney(){

        outputView.printPurchaseMessage();
        return inputMoneyValidator.moneyValidate(readLine());
    }
}
