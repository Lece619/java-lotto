package lotto.view;

import lotto.VO.LottoPrice;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

/*
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
* */
public class OutputView {

    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_SIZE = "%d개를 구매했습니다.\n";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_PRICE_CONFIRMATION = "당첨 통계\n---";
    private static final String TOTAL_YIELD = "총 수익률은 %.1f%%입니다.\n";

    public void printPurchaseMessage(){
        System.out.println(PURCHASE_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos) {
        
        System.out.printf(PURCHASE_LOTTO_SIZE, lottos.size());

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println( lottoPrinter(numbers) );
        }

        System.out.println();
    }

    public String lottoPrinter(List<Integer> numbers) {

        StringBuilder line = new StringBuilder();

        line.append("[");

        for (Integer number : numbers) {
            line.append(number).append(", ");
        }

        line.delete(line.lastIndexOf(","),line.length());
        line.append("]");

        return line.toString();
    }

    public void printInputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printPrice(Map<LottoPrice, Integer> totalPrices) {
        System.out.println(WINNING_PRICE_CONFIRMATION);

        for (int i = 5; i >= 1; i--) {
            LottoPrice key = LottoPrice.findByRank(i);
            System.out.printf(key.getMessage(), totalPrices.get(key));
        }
    }

    public void printYield(double yield) {
        System.out.printf(TOTAL_YIELD, yield);
    }
}
