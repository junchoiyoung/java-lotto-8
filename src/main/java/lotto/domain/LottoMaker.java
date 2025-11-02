package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoMaker {
    private final static int RANDOM_LOTTO_NUM_MIN = 1;
    private final static int RANDOM_LOTTO_NUM_MAX = 45;
    private final static int RANDOM_LOTTO_INDEX = 6;
    private final static int LOTTO_PRICE = 1000;

    public List<Lotto> makeLotto(int price) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = dividePrice(price);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(makeLottoNum()));
        }
        return lottos;
    }

    private static List<Integer> makeLottoNum() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_LOTTO_NUM_MIN
                , RANDOM_LOTTO_NUM_MAX, RANDOM_LOTTO_INDEX);
    }

    private int dividePrice(int price) {
        return price / LOTTO_PRICE;
    }
}
