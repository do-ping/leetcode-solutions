package easy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RichestCustomerWealthTest {

  private static Stream<Arguments> args() {
    return Stream.of(
        arguments(new int[][]{new int[]{1, 2, 3}, new int[]{3, 2, 1}}, 6),
        arguments(new int[][]{new int[]{1, 5}, new int[]{7, 3}, new int[]{3, 5}}, 10),
        arguments(new int[][]{new int[]{2, 8, 7}, new int[]{7, 1, 3}, new int[]{1, 9, 5}}, 17)
    );
  }

  private final RichestCustomerWealth solution = new RichestCustomerWealth();

  @DisplayName("Given customers' accounts, should return wealth (sum of all accounts) of the "
      + "richest customer")
  @ParameterizedTest(name = "{index}. accounts={0} maxWealth={1}")
  @MethodSource("args")
  void maximumWealth(int[][] accounts, int expected) {
    assertEquals(expected, solution.maximumWealth(accounts));
  }
}