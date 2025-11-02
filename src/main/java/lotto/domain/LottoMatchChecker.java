package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Lotto;

public class LottoMatchChecker {
    private Map<Grade, Integer> gradeCount;

    public LottoMatchChecker(List<Lotto> lottos, List<Integer> winNumber, int bonusNum) {
        makeGradeCount();

        lottos.forEach(lotto -> {
            int matchCount = matchLotto(lotto, winNumber);
            boolean bonusCheck = matchBonus(lotto, bonusNum);
            addGradeCount(matchCount, bonusCheck);
        });
    }

    public Map<Grade, Integer> getGradeCount() {
        return Collections.unmodifiableMap(gradeCount);
    }

    private void makeGradeCount() {
        gradeCount = Arrays.stream(Grade.values())
                .collect(Collectors.toMap(grade -> grade, grade -> 0));
    }

    private int matchLotto(Lotto lotto, List<Integer> winNumber) {
        return (int) lotto.getNumbers().stream()
                .filter(winNumber::contains)
                .count();
    }

    private boolean matchBonus(Lotto lotto, int bonusNum) {
        return lotto.getNumbers().contains(bonusNum);
    }

    private void addGradeCount(int matchCount, boolean bonusCheck) {
        Grade grade = Grade.findGrade(matchCount, bonusCheck);
        gradeCount.put(grade, gradeCount.get(grade) + 1);
    }
}
