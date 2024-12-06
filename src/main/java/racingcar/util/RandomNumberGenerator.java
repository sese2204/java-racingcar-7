package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int generateRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
