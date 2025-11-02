package lotto;

import lotto.validate.Validate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"999", "1001"})
    void 로또_금액_입력이_1000_단위가_아닐_경우_테스트(String price) {
        assertThatThrownBy(() -> Validate.lottoPrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 로또_금액_입력이_문자일_경우_테스트() {
        String inputPrice = "1000j";

        assertThatThrownBy(() -> Validate.lottoPrice(inputPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 로또_금액_입력이_정상일_경우_테스트() {
        String inputPrice = "1000";
        int price = Integer.parseInt(inputPrice);

        assertThat(Validate.lottoPrice(inputPrice)).isEqualTo(price);
    }
}
