package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.domain.Calculation;
import lotto.domain.Grade;

public class OutputView {
    public void printLotto(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.stream()
                .map(Lotto::getNumbers)
                .map(number -> number.stream()
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")))
                .forEach(number -> System.out.println("[" + number + "]"));
    }

    public void printResult(Map<Grade, Integer> result) {
        result.entrySet().stream()
                .filter(grade -> grade.getKey() != Grade.MISS)
                .sorted(Comparator.comparing(grade -> grade.getKey().ordinal()))
                .forEach(value -> {
                    Grade grade = value.getKey();
                    String format = "%d개 일치 (%,d원) - %d";

                    if (grade == Grade.SECOND) {
                        format = "%d개 일치, 보너스 볼 일치 (%,d원) - %d";
                    }

                    System.out.printf((format) + "%n", grade.getMatchCount(), grade.getPrize(), value.getValue());
                });
    }

    public void printPrizeRatio(Map<Grade, Integer> result, int prize) {
        Double sum = Calculation.sum(result);
        Double rate = Calculation.rate(sum, prize);
        System.out.printf("수익률 %.1f", rate);
    }
}
