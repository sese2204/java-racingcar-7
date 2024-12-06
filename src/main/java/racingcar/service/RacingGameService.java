package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.RacingGameConstant;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class RacingGameService {
    private static final String DELIMITER = ",";

    public List<Car> createCars(String input) {
        List<String> names = parseInput(input);
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name, RacingGameConstant.DEFAULT_POSITOIN.getValue()));
        }
        return cars;
    }

    public RacingGame createRacingGame(List<Car> cars) {
        return new RacingGame(cars);
    }

    private List<String> parseInput(String input) {
        List<String> names = new ArrayList<>();
        String[] splitedInput = input.split(DELIMITER);

        for (String s : splitedInput) {
            s.trim();
            names.add(s);
        }
        return names;
    }
}
