package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_SIZE = "%d개를 구매했습니다.\n";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

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
}
