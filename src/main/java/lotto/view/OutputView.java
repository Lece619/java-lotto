package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_SIZE = "%d개를 구매했습니다.\n";

    public void printPurchaseMessage(){
        System.out.println(PURCHASE_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos) {
        
        System.out.printf(PURCHASE_LOTTO_SIZE, lottos.size());

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println( lottoPrinter(numbers) );
        }
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
}
