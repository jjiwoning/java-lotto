package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateNumber(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || MAX_NUMBER < lottoNumber) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 이내의 숫자로 구성되어야 합니다.");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
