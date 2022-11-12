package lotto.Validator;

import lotto.VO.LottoInfo;

public class InputMoneyValidator {

    public String moneyValidate(String money) {

        try{
            int moneyToInt = Integer.parseInt(money);
            checkMoney(moneyToInt);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_INTEGER_ERROR.getMessage());
        }

        return money;
    }

    public void checkMoney(int money){

        if(money == 0){
            throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_ZERO_ERROR.getMessage());
        }

        if(money % LottoInfo.LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ErrorMessage.MONEY_PRICE_ERROR.getMessage());
        }
    }
}
