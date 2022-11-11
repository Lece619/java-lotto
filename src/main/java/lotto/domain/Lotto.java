package lotto.domain;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOverLap(List<Integer> numbers){

        int size = new HashSet<>(numbers).size();

        if(size != 6){
            throw new IllegalArgumentException(ErrorMessage.LottoNumberOverLabError.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
