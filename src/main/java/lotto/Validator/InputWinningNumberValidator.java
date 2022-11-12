package lotto.Validator;

import lotto.VO.LottoInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputWinningNumberValidator {

    public List<Integer> winningNumberValidation(String readLine) {

        numberValidation(readLine);
        numberSplitValidation(readLine);
        numberParsingValidation(readLine);
        numbersOverLapValidation(readLine);
        numberRangeValidation(readLine);

        return Arrays.stream(readLine.split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    private void numberValidation(String readLine) {
        if(!readLine.matches("[0-9|,]+")){
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_NOT_INTEGER.getMessage());
        }
    }

    private void numberSplitValidation(String readLine){
        int size = readLine.split(",").length;
        if(size != LottoInfo.LOTTO_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_SIZE_ERROR.getMessage());
        }
    }

    private void numberParsingValidation(String readLine){
        String[] numbers = readLine.split(",");
        try{
            for (String number : numbers) {
                Integer.parseInt(number);
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_MAL_FORMAT.getMessage());
        }
    }

    private void numbersOverLapValidation(String readLine) {
        int size = Arrays.stream(readLine.split(",")).collect(Collectors.toSet()).size();
        if(size != LottoInfo.LOTTO_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_OVER_LAP.getMessage());
        }
    }

    private void numberRangeValidation(String readLine) {
        long count = Arrays.stream(readLine.split(",")).mapToInt(Integer::parseInt)
                .filter(i -> i < 1 || i > 45).count();
        if(count > 0){
            throw  new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());
        }
    }

    public int winningBonusNumberValidation(List<Integer> numbers, String bonusNum) {

        bonusNumIntegerValidation(bonusNum);
        bonusNumRangeValidation(bonusNum);
        bonusNumContainsValidation(bonusNum, numbers);

        return Integer.parseInt(bonusNum);
    }

    private void bonusNumIntegerValidation(String bonusNum) {
        if(!bonusNum.matches("[0-9]+")){
            throw new IllegalArgumentException(ErrorMessage.WINNING_BONUS_ISNOT_NUMBER.getMessage());
        }
    }

    private void bonusNumRangeValidation(String bonusNum) {
        int num = Integer.parseInt(bonusNum);
        if(num < 1 || num > 45){
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private void bonusNumContainsValidation(String bonusNum, List<Integer> numbers) {
        int num = Integer.parseInt(bonusNum);
        if(numbers.contains(num)){
            throw new IllegalArgumentException(ErrorMessage.WINNING_BONUS_IS_CONTAINS.getMessage());
        }
    }
}
