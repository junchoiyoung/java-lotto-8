package lotto;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.Calculator;
import lotto.domain.Grade;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void 더하기_기능_테스트() {
        Map<Grade, Integer> testMap = new HashMap<>();
        testMap.put(Grade.SECOND, 1);
        testMap.put(Grade.THIRD, 1);
        double answer = Grade.SECOND.getPrize() + Grade.THIRD.getPrize();

        assertThat(Calculator.sum(testMap)).isEqualTo(answer);
    }

    @Test
    void 수익률_계산_기능_테스트() {
        double sum = 5000;
        int price = 8000;
        double answer = 62.5;

        assertThat(Calculator.rate(sum, price)).isEqualTo(answer);
    }
}
