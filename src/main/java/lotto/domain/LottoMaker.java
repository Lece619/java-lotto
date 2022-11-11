package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.VO.LottoInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {

    private static final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> purchase(String money) {

        int count = Integer.parseInt(money) / LottoInfo.LOTTO_PRICE;

        for (int i = 0; i < count; i++) {
            lottos.add(makeLotto());
        }

        return lottos;
    }

    public Lotto makeLotto(){

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }


}
