package lotto.Validator;

import lotto.view.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputMoneyValidatorTest {

    public InputMoneyValidator inputMoneyValidator = new InputMoneyValidator();

    @Test
    @DisplayName("구매 금액은 숫자를 입력해야 합니다.")
    public void notInteger(){

        String money = "1000원";

        Assertions.assertThatThrownBy(() -> inputMoneyValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MONEY_NOT_INTEGER_ERROR.getMessage());

    }

    @Test
    @DisplayName("구매 금액은 0원이 될 수 없습니다.")
    public void moneyCannotZero(){

        String money = "0";

        Assertions.assertThatThrownBy(() -> inputMoneyValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MONEY_NOT_ZERO_ERROR.getMessage());

    }

    @Test
    @DisplayName("구매 금액은 1000원 단위 여야 합니다.")
    public void moneyOnPrice(){

        String money = "1200";

        Assertions.assertThatThrownBy(() -> inputMoneyValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MONEY_PRICE_ERROR.getMessage());

    }
}