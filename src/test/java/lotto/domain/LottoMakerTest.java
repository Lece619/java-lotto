package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoMakerTest {

    private LottoMaker lottoMaker = new LottoMaker();

    @Test
    @DisplayName("로또 구매 확인")
    void 로또_구매확인(){

        String money = "5000";

        Assertions.assertThat(lottoMaker.purchase(money).size()).isEqualTo(5);
    }

}