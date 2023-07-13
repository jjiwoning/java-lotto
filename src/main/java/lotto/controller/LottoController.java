package lotto.controller;

import lotto.domain.*;
import lotto.dto.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoService = new LottoService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        MoneyRequestDto moneyRequestDto = inputView.inputMoney();
        Money money = new Money(moneyRequestDto.getMoney());

        ManualLottosRequestDto manualLottosRequestDto = inputView.inputManualLottos();
        List<Lotto> manualLottos = manualLottosRequestDto.getManualLottos()
                .stream().map(lotto -> new Lotto(lotto.getManualLotto()))
                .collect(Collectors.toList());
        LottosCount manualLottosCount = new LottosCount(manualLottosRequestDto.getManualCount());
        Lottos lottos = lottoService.buyLotto(money, new Lottos(manualLottos), manualLottosCount);
        outputView.printBuyStatus(new LottoStatusesResponseDto(lottos, manualLottosCount));

        WinningNumbersRequestDto winningNumbersRequestDto = inputView.inputWinningNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(
                winningNumbersRequestDto.getWinningNumbers(),
                winningNumbersRequestDto.getBonusNumber()
        );
        LottoResults lottoResults = lottoService.matchWinningLotto(lottos, winningNumbers);
        ProfitRate profitRate = lottoService.profitRate(lottoResults, money);
        outputView.printLottoResult(new LottoResultResponseDto(lottoResults, profitRate));
    }
}
