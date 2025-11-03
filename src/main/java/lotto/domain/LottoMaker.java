package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.Lotto;

public class LottoMaker {
    private final static int RANDOM_LOTTO_NUM_MIN = 1;
    private final static int RANDOM_LOTTO_NUM_MAX = 45;
    private final static int RANDOM_LOTTO_INDEX = 6;
    private final static int LOTTO_PRICE = 1000;

    public List<Lotto> makeLotto(int price) {
        int lottoCount = dividePrice(price);
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(makeLottoNum()))
                .toList();
    }

    private static List<Integer> makeLottoNum() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_LOTTO_NUM_MIN
                , RANDOM_LOTTO_NUM_MAX, RANDOM_LOTTO_INDEX);
    }

    private int dividePrice(int price) {
        return price / LOTTO_PRICE;
    }
}
