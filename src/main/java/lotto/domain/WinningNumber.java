package lotto.domain;

import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;

    private final int bonusNum;

    public WinningNumber(List<Integer> numbers, int bonusNum) {
        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
