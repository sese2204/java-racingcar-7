package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_MESSAGE_CARNAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분";
    public static final String INPUT_MESSAGE_TRYCOUNT = "시도할 횟수는 몇 회인가요?";

    public String requestCarName() {
        System.out.println(INPUT_MESSAGE_CARNAME);
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 비어있습니다.");
        }
    }
}
