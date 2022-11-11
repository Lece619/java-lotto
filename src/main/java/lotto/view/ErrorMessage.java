package lotto.view;

public enum ErrorMessage {

    LottoSizeError("[ERROR] 로또의 번호는 6개를 지정해야 합니다."),
    LottoNumberOverLabError("[ERROR] 중복된 숫자가 존재합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
