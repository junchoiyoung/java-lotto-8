package lotto;

import lotto.domain.LottoMaker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoMakerTest {

    @Test
    void 로또_금액에_따라_뽑는_로또_갯수_테스트() {
        int price = 1000;
        int answer = 1;

        LottoMaker lottoMaker = new LottoMaker();

        assertThat(lottoMaker.makeLotto(price)).hasSize(answer);
    }
}
