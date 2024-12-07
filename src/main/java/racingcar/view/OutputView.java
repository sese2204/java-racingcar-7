package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {
    private static final String OUTPUT_HEADER = "실행 결과";
    private static final String OUTPUT_MESSAGE_ROUND = "%s : ";
    private static final String OUTPUT_WINNER = "최종 우승자 : ";

    public void printOutputHeader() {
        System.out.println(OUTPUT_HEADER);
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(String.format(OUTPUT_MESSAGE_ROUND, car.getCarName()) + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> winningCars) {
        String winners = winningCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
        System.out.print(OUTPUT_WINNER + winners);
    }
}
