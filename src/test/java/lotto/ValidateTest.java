package lotto;

import lotto.validate.Validate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidateTest {

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

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
    void 당첨_번호가_7자리_이상일_경우_테스트(String number) {
        assertThatThrownBy(() -> Validate.winnerNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_문자가_있을_경우() {
        String number = "1,2,3,a,5,6";
        assertThatThrownBy(() -> Validate.winnerNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "46"})
    void 보너스_번호가_1보다_작거나_45보다_클_경우_테스트(String number) {
        assertThatThrownBy(() -> Validate.bonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호에_문자가_올_경우_테스트() {
        String number = "a";
        assertThatThrownBy(() -> Validate.bonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_6자리_일_경우() {
        String number = "1,2,3,4,5,6";
        assertThat(Validate.winnerNumber(number)).containsExactly(1,2,3,4,5,6);
    }

    @Test
    void 로또_금액_입력이_정상일_경우_테스트() {
        String inputPrice = "1000";
        int price = Integer.parseInt(inputPrice);

        assertThat(Validate.lottoPrice(inputPrice)).isEqualTo(price);
    }

    @Test
    void 당첨_번호가_정상일_경우_테스트() {
        String number = "1,2,3,4,5,6";
        assertThat(Validate.winnerNumber(number)).containsExactly(1,2,3,4,5,6);
    }

    @Test
    void 보너스_번호가_정상일_경우_테스트() {
        String number = "1";
        assertThat(Validate.bonusNumber(number)).isEqualTo(1);
    }
}
