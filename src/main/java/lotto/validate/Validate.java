package lotto.validate;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Validate {
    public static int lottoPrice(String purchase) {
        try {
            hasNoString(purchase);
            int price = Integer.parseInt(purchase);

            if (price % 1000 != 0 || price < 1000) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("메세지 다시 입력ㄱㄱ");
            lottoPrice(Console.readLine());
        }

        return Integer.parseInt(purchase);
    }

    public static List<Integer> winnerNumber(String number) {
        try {
            String[] splitNumber = number.split(",");

            for (String num : splitNumber) {
                hasNoString(num);
                numArrange(num);
            }
        } catch (Exception e) {
            System.out.println("다시 입력ㄱㄱ");
            winnerNumber(Console.readLine());
        }

        return Arrays.stream(number.split(",")).map(Integer::parseInt).toList();
    }

    public static int bonusNumber(String number) {
        try {
            hasNoString(number);
            numArrange(number);
        } catch (Exception e) {
            System.out.println("보너스 숫자 다시 입력ㄱㄱ");
            bonusNumber(Console.readLine());
        }

        return Integer.parseInt(number);
    }

    private static void hasNoString(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void numArrange(String num) {
        int number = Integer.parseInt(num);

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }
}
