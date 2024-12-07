package racingcar.controller;


import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.exception.ExceptionMessages;
import racingcar.service.RacingGameService;
import racingcar.util.RetryUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public Controller(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    public void run() {
        List<Car> cars = requestCars();
        int tryCount = requestTryCount();
        RacingGame racingGame = racingGameService.createRacingGame(cars);
        outputView.printOutputHeader();
        runRounds(tryCount, racingGame);
        outputView.printWinner(racingGame.getWinningCars());
    }

    private Integer requestTryCount() {
        return RetryUtil.retryUntilSuccessWithReturn(() -> {
            int tryCountInput = inputView.requestTryCount();
            if (tryCountInput < 0) {
                throw new IllegalArgumentException(ExceptionMessages.ERROR_NOT_INTEGER.getMessage());
            }
            return tryCountInput;
        });
    }

    private void runRounds(int tryCount, RacingGame racingGame) {
        for (int i = 0; i < tryCount; i++) {
            racingGame.runRound();
            outputView.printRoundResult(racingGame.getCars());
        }
    }

    private List<Car> requestCars() {
        return RetryUtil.retryUntilSuccessWithReturn(() -> {
            String carNameInput = inputView.requestCarName();
            return racingGameService.createCars(carNameInput);
        });
    }


}