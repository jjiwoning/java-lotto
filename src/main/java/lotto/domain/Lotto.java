package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validateLotto(List<Integer> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        validateDuplicatedLottoNumbers(lottoNumbers);
    }

    private void validateLottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(
                    String.format("로또 번호의 개수는 6개여야 합니다. 현재 %d개의 로또를 입력했습니다.", lottoNumbers.size())
            );
        }
    }

    private void validateDuplicatedLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> numbers = new HashSet<>(lottoNumbers);
        if (numbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(
                    String.format(
                            "로또 번호는 중복되면 안 됩니다. 현재 %d개의 로또 번호가 중복됩니다.",
                            lottoNumbers.size() - numbers.size()
                    )
            );
        }
    }

    public long countMatchNumber(Lotto winningNumbers) {
        return lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean matchBonusNumber(LottoNumber bonusNumber) {
        return this.contains(bonusNumber);
    }

    private boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
