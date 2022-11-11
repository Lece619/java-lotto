package lotto.view;

import lotto.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("당첨번호 입력 테스트")
    void winningNumbers() {
        command("1,2,3,4,5,6", "7");
        WinningNumber winningNumber = inputView.winningNumbers();

        Assertions.assertThat(winningNumber.getNumbers()).contains(1,2,3,4,5,6);
        Assertions.assertThat(winningNumber.getBonusNum()).isEqualTo(7);

    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}