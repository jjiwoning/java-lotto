package lottery.domain;

import java.util.List;
import java.util.Objects;

public class LotteryResult {
    private final List<Integer> winNumbers;
    private final int numberOfLottery;

    public LotteryResult(List<Integer> winNumbers, int numberOfLottery) {
        this.winNumbers = winNumbers;
        this.numberOfLottery = numberOfLottery;
    }

    @Override
    public String toString() {
        return winNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryResult that = (LotteryResult) o;
        return Objects.equals(winNumbers, that.winNumbers);
    }

    public List<Integer> winNumbers() {
        return winNumbers;
    }

    public int numberOfLottery() {
        return numberOfLottery;
    }
}