package lotto.view;

import lotto.Validator.InputMoneyValidator;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    private final OutputView outputView = new OutputView();
    private final InputMoneyValidator inputMoneyValidator = new InputMoneyValidator();

    public void purchase(){
        outputView.printPurchaseMessage();
        String money = inputMoneyValidator.moneyValidate(readLine());
    }
}
