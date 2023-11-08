package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningResultTest {
    private static final WinningNumber WINNING_NUMBER = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 11);

    @ParameterizedTest
    @CsvSource({"SIXTH,3", "FIFTH,0", "FOURTH,0", "THIRD,1", "SECOND,1", "FIRST,1"})
    void countNumberOfWinning_메서드로_등수별_당첨_갯수를_확인(String prize, int expected) {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(List.of(12, 13, 14, 15, 16, 17)));
        lottoTickets.add(new Lotto(List.of(6, 7, 8, 9, 10, 11)));
        lottoTickets.add(new Lotto(List.of(5, 6, 7, 8, 9, 10)));
        lottoTickets.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
        lottoTickets.add(new Lotto(List.of(2, 3, 4, 5, 6, 11)));
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        WinningResult winningResult = new WinningResult();

        Map<PrizeCategory, Integer> actual = winningResult.countNumberOfWinning(lottoTickets, WINNING_NUMBER);

        assertThat(actual.get(PrizeCategory.valueOf(prize))).isEqualTo(expected);
    }
}