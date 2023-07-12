package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateDuplicatedBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validateDuplicatedBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호와 당첨 번호가 중복 됩니다.");
        }
    }

    public LottoRank match(Lotto lotto) {
        long matchCount = lotto.countMatchNumber(winningNumbers);
        boolean bonusCount = lotto.matchBonusNumber(bonusNumber);

        return findLottoRank(matchCount, bonusCount);
    }

    private LottoRank findLottoRank(long matchCount, boolean bonusCount) {
        return LottoRank.findLottoRank(matchCount, bonusCount);
    }
}
