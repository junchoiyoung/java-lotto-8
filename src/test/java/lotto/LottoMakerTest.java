package lotto;

import java.util.List;
import lotto.domain.LottoMaker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMakerTest {

    @Test
    void 로또_금액에_따라_뽑는_로또_갯수_테스트() {
        int price = 1000;
        int answer = 1;
        LottoMaker lottoMaker = new LottoMaker();
        assertThat(lottoMaker.makeLotto(price)).hasSize(answer);
    }

    @Test
    void 뽑은_로또가_6개인지_확인_테스트() {
        int price = 1000;
        List<Lotto> lottos = new LottoMaker().makeLotto(price);
        Lotto lotto = lottos.getFirst();

        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @Test
    void 뽑은_로또가_1이상_45이하_확인_테스트() {
        int price = 1000;
        List<Lotto> lottos = new LottoMaker().makeLotto(price);
        Lotto lotto = lottos.getFirst();

        assertThat(lotto.getNumbers())
                .allMatch(number -> number >= 1 && number <= 45);
    }
}
