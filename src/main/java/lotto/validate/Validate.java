package lotto.validate;

import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class Validate {
    private final static int NUMBER_RANGE_MIN = 1;
    private final static int NUMBER_RANGE_MAX = 45;
    private final static int LOTTO_PRICE = 1000;

    public static int lottoPrice(String purchase) {
        int price = hasNoString(purchase);
        purchaseAmount(price);

        return price;
    }

    public static List<Integer> winnerNumber(String number) {
        List<Integer> numbers = Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .toList();
        new Lotto(numbers);

        return numbers;
    }

    public static int bonusNumber(String number) {
        int bonus = hasNoString(number);
        numberRange(bonus);

        return bonus;
    }

    public static void numberRange(int number) {
        if (number < NUMBER_RANGE_MIN || number > NUMBER_RANGE_MAX) {
            String errorMessage = String.format("[ERROR] %d ~ %d사이 숫자 입력해주세요.", NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static int hasNoString(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void purchaseAmount(int price) {
        if (price % LOTTO_PRICE != 0) {
            String errorMessage = String.format("[ERROR] %d단위의 숫자를 입력해주세요.", LOTTO_PRICE);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}

