package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.RacingGameConstant;
import racingcar.util.RandomNumberGenerator;

public class RacingGame {
    private List<Car> cars;
    private List<Car> winningCars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
        this.winningCars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinningCars() {
        return winningCars;
    }

    public void runRound() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber(
                    RacingGameConstant.MIN_RANDOM_NUMBER.getValue()
                    , RacingGameConstant.MAX_RANDOM_NUMBER.getValue());
            if (isValidNumber(randomNumber)) {
                car.goFoward();
            }
        }
    }

    public void findWinningCars() {
        int maxPosition = findMaxPosition();
        winningCars.add(cars.get(maxPosition));
    }

    private int findMaxPosition() {
        int maxPosition = -1;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private Boolean isValidNumber(int number) {
        return number >= RacingGameConstant.TARGET_NUMBER.getValue();
    }
}