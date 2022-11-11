package lotto.service;

import lotto.domain.LottoMaker;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoService {

    private final LottoMaker lottoMaker = new LottoMaker();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void purchaseLotto() {

        String money = inputView.purchaseMoney();
        lottoMaker.purchase(money);

    }

    public void printLottos() {
        outputView.printLottos(lottoMaker.getLottos());
    }
}
