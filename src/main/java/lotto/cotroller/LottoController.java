package lotto.cotroller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validate.Validate;
import lotto.view.InputView;

public class LottoController {

    InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        inputView.printBuyLottoPrice();
        int price = Validate.lottoPrice(Console.readLine());
        inputView.printWinnerNumber();
        List<Integer> winNum = Validate.winnerNumber(Console.readLine());
        inputView.printBonusNumber();
        int bonusNumber = Validate.bonusNumber(Console.readLine());
    }
}
