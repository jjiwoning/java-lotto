package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 46;
    private static final int START_INDEX = 0;
    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> lottoNumbers = IntStream.range(START_NUMBER, END_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private RandomGenerator() {
    }

    public static Lotto generateLotto() {
        Collections.shuffle(lottoNumbers);
        return new Lotto(lottoNumbers.subList(START_INDEX, LOTTO_SIZE));
    }
}