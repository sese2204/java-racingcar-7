package racingcar.exception;

public enum ExceptionMessages {
    ERROR_NOT_INTEGER("시도 횟수는 자연수만 가능합니다."),
    ERROR_NAME_LENGTH("자동차 이름은 최소 한 글자에서 다섯 글자까지 가능합니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("[ERROR] %s", message);
    }
}
