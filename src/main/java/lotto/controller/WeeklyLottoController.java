package lotto.controller;

import lotto.service.LottoService;

public class WeeklyLottoController {

    private final LottoService lottoService = new LottoService();

    public void run(){

        lottoService.purchaseLotto();

    }
}
