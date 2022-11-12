package lotto.domain;

import lotto.VO.LottoPrice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoCompany {

    private WinningNumber winningNumber;
    private long money;
    private long winningMoney;
    private static Map<LottoPrice, Integer> totalPrices = new LinkedHashMap<>();

    public LottoCompany() {
        for (LottoPrice lottoPrice : LottoPrice.values()) {
            totalPrices.put(lottoPrice, 0);
        }
    }


    public void WinningConfirmation(List<Lotto> lottos) {

        for (Lotto lotto : lottos) {

            int match = findMatchBall(lotto);
            boolean bonus = findBonusBall(lotto);

            LottoPrice lottoPrice = LottoPrice.find(match, bonus);
            totalPrices.put(lottoPrice, totalPrices.get(lottoPrice) + 1);
            winningMoney += lottoPrice.getPrice();
        }

    }

    private int findMatchBall(Lotto lotto) {
        int match = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumber.getNumbers().contains(number)) {
                match++;
            }
        }
        return match;
    }

    private boolean findBonusBall(Lotto lotto) {

        return lotto.getNumbers().contains(winningNumber.getBonusNum());
    }

    public double getYield() {
        return (double)winningMoney / (double)money * 100;
    }

    public void setWinningNumber(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setMoney(String money) {
        this.money = Integer.parseInt(money);
    }

    public long getMoney() {
        return money;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public Map<LottoPrice, Integer> getTotalPrices() {
        return totalPrices;
    }
}
