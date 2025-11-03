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
        int price = readPrice();
        List<Integer> winNum = readWinnerNumber();
        int bonusNum = readBonusNumber();

        LottoManager lottoManager = createLottoManager();
        List<Lotto> lottos = lottoManager.getLottos(price);
        Map<Grade, Integer> result = lottoManager.getResult(lottos, winNum, bonusNum);

        outputView.printLotto(lottos);
        outputView.printResult(result);
        outputView.printPrizeRatio(result, price);
    }

    private int readPrice() {
        inputView.printPriceMessage();
        return inputView.inputPrice();
    }

    private List<Integer> readWinnerNumber() {
        inputView.printWinnerNumberMessage();
        return inputView.inputWinnerNumber();
    }

    private int readBonusNumber() {
        inputView.printBonusNumberMessage();
        return inputView.inputBonusNumber();
    }

    private LottoManager createLottoManager() {
        LottoMaker lottoMaker = new LottoMaker();
        LottoMatchChecker lottoMatchChecker = new LottoMatchChecker();
        return new LottoManager(lottoMaker, lottoMatchChecker);
    }
}
