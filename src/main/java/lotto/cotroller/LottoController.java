package lotto.cotroller;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.Grade;
import lotto.domain.LottoMaker;
import lotto.domain.LottoManager;
import lotto.domain.LottoMatchChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView;
    OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        inputView.printBuyLottoPrice();
        int price = inputView.inputPrice();
        inputView.printWinnerNumber();
        List<Integer> winNum = inputView.inputWinnerNumber();
        inputView.printBonusNumber();
        int bonusNum = inputView.inputBonusNumber();

        LottoMaker lottoMaker = new LottoMaker();
        LottoMatchChecker lottoMatchChecker = new LottoMatchChecker();
        LottoManager lottoManager = new LottoManager(lottoMaker, lottoMatchChecker);

        List<Lotto> lottos = lottoManager.getLottos(price);
        Map<Grade, Integer> result = lottoManager.getResult(lottos, winNum, bonusNum);

        outputView.printLotto(lottos);
        outputView.printResult(result);
        outputView.printPrizeRatio(result, price);
    }
}
