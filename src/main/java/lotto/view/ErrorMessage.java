package lotto.view;

public enum ErrorMessage {

    LOTTO_SIZE_ERROR("[ERROR] 로또의 번호는 6개를 지정해야 합니다."),
    LOTTO_OVER_LAB_ERROR("[ERROR] 중복된 숫자가 존재합니다."),
    MONEY_NOT_INTEGER_ERROR("[ERROR] 금액을 숫자로 입력해 주세요."),
    MONEY_NOT_ZERO_ERROR("[ERROR] 금액은 0원이 될 수 없습니다."),
    MONEY_PRICE_ERROR("[ERROR] 1000원이 단위로 입력해 주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
