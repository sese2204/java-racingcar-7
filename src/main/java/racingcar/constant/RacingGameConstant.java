package racingcar.constant;

public enum RacingGameConstant {
    MAX_RANDOM_NUMBER(9),
    MIN_RANDOM_NUMBER(0),
    TARGET_NUMBER(4);

    private int value;

    RacingGameConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
