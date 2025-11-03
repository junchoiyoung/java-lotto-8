package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class LottoManager {
    private final LottoMaker lottoMaker;
    private final LottoMatchChecker lottoMatchChecker;

    public LottoManager(LottoMaker lottoMaker, LottoMatchChecker lottoMatchChecker) {
        this.lottoMaker = lottoMaker;
        this.lottoMatchChecker = lottoMatchChecker;
    }

    public List<Lotto> getLottos(int price) {
        return lottoMaker.makeLotto(price);
    }

    public Map<Grade, Integer> getResult(List<Lotto> lottos, List<Integer> winNumber, int bonusNum) {
        lottoMatchChecker.calculate(lottos, winNumber, bonusNum);
        return lottoMatchChecker.getGradeCount();
    }
}
