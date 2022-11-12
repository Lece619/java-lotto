package lotto.service;

import lotto.domain.LottoCompany;
import lotto.domain.LottoMaker;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoService {

    private final LottoMaker lottoMaker = new LottoMaker();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoCompany lottoCompany = new LottoCompany();

    public void purchaseLotto() {

        String money = inputView.purchaseMoney();
        lottoMaker.purchase(money);
        lottoCompany.setMoney(money);
        System.out.println();
    }

    public void printLottos() {
        outputView.printLottos(lottoMaker.getLottos());
        System.out.println();
    }

    public void inputWinningNumber() {
        WinningNumber winningNumber = inputView.winningNumbers();
        lottoCompany.setWinningNumber(winningNumber);
    }


    public void checkLottoPrice() {
        lottoCompany.WinningConfirmation( lottoMaker.getLottos() );
    }

    public void printPriceTotal() {
        outputView.printPrice(lottoCompany.getTotalPrices());
    }
}
