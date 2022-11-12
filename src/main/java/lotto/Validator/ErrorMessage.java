package lotto.Validator;

public enum ErrorMessage {

    LOTTO_SIZE_ERROR("[ERROR] 로또의 번호는 6개를 지정해야 합니다."),
    LOTTO_OVER_LAB_ERROR("[ERROR] 중복된 숫자가 존재합니다."),

    MONEY_NOT_INTEGER_ERROR("[ERROR] 금액을 숫자로 입력해 주세요."),
    MONEY_NOT_ZERO_ERROR("[ERROR] 금액은 0원이 될 수 없습니다."),
    MONEY_PRICE_ERROR("[ERROR] 1000원이 단위로 입력해 주세요."),

    WINNING_NUMBER_NOT_INTEGER("[ERROR] 숫자와 쉼표를 입력해 주세요."),
    WINNING_NUMBER_SIZE_ERROR("[ERROR] 숫자를 6개 입력해 주세요."),
    WINNING_NUMBER_MAL_FORMAT("[ERROR] 숫자를 쉼표로 구분해 입력해 주세요."),
    WINNING_NUMBER_OVER_LAP("[ERROR] 중복된 숫자는 입력할 수 없습니다."),
    WINNING_NUMBER_RANGE("[ERROR] 숫자는 1 - 45 사이의 숫자를 입력해주세요."),

    WINNING_BONUS_ISNOT_NUMBER("[ERROR] 숫자만 입력해주세요"),
    WINNING_BONUS_IS_CONTAINS("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
