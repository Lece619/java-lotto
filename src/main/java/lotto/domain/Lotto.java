package lotto.domain;

import lotto.VO.LottoInfo;
import lotto.view.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateOverLap(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoInfo.LOTTO_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private void validateOverLap(List<Integer> numbers){

        int size = new HashSet<>(numbers).size();

        if(size != LottoInfo.LOTTO_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_OVER_LAB_ERROR.getMessage());
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }
}
