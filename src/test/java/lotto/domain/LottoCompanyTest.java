package lotto.domain;

import lotto.VO.LottoPrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoCompanyTest {

    @Test
    @DisplayName("로또 당첨 횟수 & 금액 확인")
    void winningConfirmation() {

        LottoCompany lottoCompany = new LottoCompany();
        lottoCompany.setWinningNumber( new WinningNumber(List.of(1,2,3,4,5,6), 7));


        List<Lotto> lottos = List.of(
                new Lotto( List.of( 1,2,3,4,5,6)),
                new Lotto( List.of(1,2,3,4,5,7)));

        lottoCompany.WinningConfirmation(lottos);

        Assertions.assertThat(lottoCompany.getTotalPrices().get(LottoPrice.FIRST)).isEqualTo(1);
        Assertions.assertThat(lottoCompany.getTotalPrices().get(LottoPrice.SECOND)).isEqualTo(1);
        Assertions.assertThat(lottoCompany.getWinningMoney()).isEqualTo(LottoPrice.FIRST.getPrice() + LottoPrice.SECOND.getPrice());
    }


}