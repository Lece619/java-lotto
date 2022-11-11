package lotto.Validator;

import lotto.view.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class InputWinningNumberValidatorTest {

    InputWinningNumberValidator validator = new InputWinningNumberValidator();

    @Test
    @DisplayName("숫자와 쉼표가 아닐때 에러가 발생함")
    void 당첨번호검증_숫자쉼표(){

        String readLine = "1,,-";

        Assertions.assertThatThrownBy(()-> validator.winningNumberValidation(readLine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_NOT_INTEGER.getMessage());
    }

    @Test
    @DisplayName("숫자가 6개 인지 확인")
    void 당첨번호_갯수_검증(){

        String readLine = "1,2,3,4,5";

        Assertions.assertThatThrownBy(()-> validator.winningNumberValidation(readLine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_SIZE_ERROR.getMessage());
    }

    @Test
    @DisplayName("숫자 형식 입력 확인")
    void 번호_입력형식_확인(){

        String readLine = "1,2,,,1,1";

        Assertions.assertThatThrownBy(()-> validator.winningNumberValidation(readLine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_MAL_FORMAT.getMessage());
    }

    @Test
    @DisplayName("숫자 중복 확인")
    void 번호_입력중복_확인(){

        String readLine = "1,1,2,3,4,5";

        Assertions.assertThatThrownBy(()-> validator.winningNumberValidation(readLine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_OVER_LAP.getMessage());
    }

    @Test
    @DisplayName("숫자 범위 테스트")
    void 로또_숫자_범위테스트(){
        String readLine = "1,2,3,4,5,0";

        Assertions.assertThatThrownBy(()-> validator.winningNumberValidation(readLine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());

    }

    @Test
    @DisplayName("보너스 숫자 Integer확인")
    void 보너스숫자테스트(){

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNum = "r";

        Assertions.assertThatThrownBy(()-> validator.winningBonusNumberValidation(numbers, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_BONUS_ISNOT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 숫자 범위 확인")
    void 보너스숫자_범위테스트(){

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNum = "46";

        Assertions.assertThatThrownBy(()-> validator.winningBonusNumberValidation(numbers, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());
    }
}