package lotto.view;

import lotto.VO.LottoPrice;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    @DisplayName("구매 갯수 확인")
    void printLottos() {

        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        outputView.printLottos(lottos);

        Assertions.assertThat(output.toString().trim()).contains("1개를 구매했습니다.");
    }

    @Test
    @DisplayName("로또 한줄 출력 테스트")
    void printLineTest(){

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Assertions.assertThat(outputView.lottoPrinter(numbers)).isEqualTo(
                "[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("구매 로또 확인 테스트")
    void printLottoAll() {

        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2,3,4,5,6,7)));
        outputView.printLottos(lottos);

        Assertions.assertThat(output.toString().trim()).contains("2개를 구매했습니다."
        ,"[1, 2, 3, 4, 5, 6]", "[2, 3, 4, 5, 6, 7]");
    }

    @Test
    @DisplayName("당첨 확인 통계 메시지 테스트")
    void printWinningMessage(){

        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Map<LottoPrice, Integer> totalPrices = new HashMap<>();
        Arrays.stream(LottoPrice.values()).forEach(lottoPrice->totalPrices.put(lottoPrice,0));

        outputView.printPrice(totalPrices);

        Assertions.assertThat(output.toString().trim()).contains("3개 일치 (5,000원)");
    }

    @Test
    @DisplayName("수익률 출력 테스트")
    void printYield(){

        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        outputView.printYield(1000000.000);

        Assertions.assertThat(output.toString().trim()).contains("1,000,000.0%");
    }

    @Test
    @DisplayName("수익률 포맷팅 테스트")
    void formatting(){

        double yield = 11221231.16;

        String result = outputView.formattingYield(yield);

        Assertions.assertThat(result).isEqualTo("11,221,231.2");
    }
}