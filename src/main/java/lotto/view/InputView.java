package lotto.view;

public class InputView {
    private final static String HOW_MUCH_BUY_MESSAGE = "구입 금액을 입력해주세요.";
    private final static String INPUT_WINNER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void printBuyLottoPrice() {
        System.out.println(HOW_MUCH_BUY_MESSAGE);
    }

    public void printWinnerNumber() {
        System.out.println(INPUT_WINNER_NUMBER_MESSAGE);
    }

    public void printBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }
}
