package lotto.cotroller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.LottoManager;
import lotto.validate.Validate;
import lotto.view.InputView;

public class LottoController {

    InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        inputView.printBuyLottoPrice();
        int price = inputView.inputPrice();
        inputView.printWinnerNumber();
        List<Integer> winNum = inputView.inputWinnerNumber();
        inputView.printBonusNumber();
        int bonusNum = inputView.inputBonusNumber();

        LottoManager lottoManager = new LottoManager(price, winNum, bonusNum);
    }
}
