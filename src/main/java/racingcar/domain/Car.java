package racingcar.domain;

import racingcar.exception.ExceptionMessages;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName, int position) {
        validateCarName(carName);
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void goFoward() {
        position++;
    }

    private void validateCarName(String carName) {
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_NAME_LENGTH.getMessage());
        }
    }
}
