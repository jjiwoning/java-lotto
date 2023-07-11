package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("Money 객체 전달받으면 로또 발급 테스트")
    void generateLotto() {
        Money money = new Money(5000);
        Lottos lottos = lottoService.buyLotto(money);
        Assertions.assertThat(lottos.size()).isEqualTo(5);
    }
}