package lotto.domain;

import java.util.Map;

public class Calculator {
    public static double sum(Map<Grade, Integer> result) {
        return result.entrySet().stream()
                .filter(grade -> grade.getValue() > 0)
                .mapToDouble(grade -> grade.getKey().getPrize() * grade.getValue())
                .sum();
    }

    public static double rate(Double sum, int prize) {
        return sum / prize * 100;
    }
}
