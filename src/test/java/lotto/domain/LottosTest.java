package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottosTest {

    @Test
    @DisplayName("정상적인 입력이 들어오면 Lottos 객체가 생성된다.")
    void create() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThatNoException()
                .isThrownBy(() -> new Lottos(lottos));
    }

    @Test
    @DisplayName("로또 당첨 통계를 계산한다.")
    void matchWinningNumbers() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoResults lottoResults = lottos.matchWinningNumbers(winningNumbers);

        LottoResults expectedResults = new LottoResults();
        expectedResults.add(LottoRank.FIRST, 1);

        Assertions.assertThat(lottoResults).isEqualTo(expectedResults);
    }
}
