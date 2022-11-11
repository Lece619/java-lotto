package lotto.controller;

import lotto.service.LottoService;

public class WeeklyLottoController {

    private final LottoService lottoService = new LottoService();

    public void run(){

        try {
            lottoService.purchaseLotto();
            lottoService.printLottos();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
