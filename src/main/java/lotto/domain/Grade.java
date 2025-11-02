package lotto.domain;

import java.util.Arrays;

public enum Grade {
    MISS(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Grade(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static Grade findGrade(int matchCount, boolean matchBonus) {
        return Arrays.stream(Grade.values())
                .filter(value -> value.matchCount == matchCount)
                .filter(value -> value.matchBonus == matchBonus)
                .findAny()
                .orElse(MISS);
    }
}
