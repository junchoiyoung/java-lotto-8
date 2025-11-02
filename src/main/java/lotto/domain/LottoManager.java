package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class LottoManager {
    private final LottoMatchChecker lottoMatchChecker;

    public LottoManager(int price, List<Integer> winNumber, int bonusNum) {
        List<Lotto> lottos = new LottoMaker().makeLotto(price);
        lottoMatchChecker = new LottoMatchChecker(lottos, winNumber, bonusNum);
    }
}
