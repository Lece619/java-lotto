package lotto.view;

import lotto.Validator.InputMoneyValidator;
import lotto.Validator.InputWinningNumberValidator;
import lotto.domain.WinningNumber;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    private final OutputView outputView = new OutputView();
    private final InputMoneyValidator inputMoneyValidator = new InputMoneyValidator();
    private final InputWinningNumberValidator inputWinningNumberValidator = new InputWinningNumberValidator();

    public String purchaseMoney(){

        outputView.printPurchaseMessage();
        return inputMoneyValidator.moneyValidate(readLine());
    }

    public WinningNumber winningNumbers() {

        outputView.printInputWinningNumbers();
        List<Integer> numbers = inputWinningNumberValidator.winningNumberValidation(readLine());
        outputView.printInputBonusNumber();
        int bonusNum = inputWinningNumberValidator.winningBonusNumberValidation(numbers, readLine());

        return new WinningNumber(numbers, bonusNum);
    }
}
