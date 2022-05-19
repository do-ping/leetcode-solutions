package easy;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwoSumTest {

  private final TwoSum solution = new TwoSum();

  private static Stream<Arguments> argsSource() {
    return Stream.of(
        arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
        arguments(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
        arguments(new int[]{3, 3}, 6, new int[]{0, 1}),
        arguments(new int[]{1, 2, 55, 77, 90, 3, 99}, 176, new int[]{3, 6})
    );
  }

  @DisplayName("Given array of numbers and target sum, then should return array of indices of two "
      + "numbers from \"numbers\" that sum up to \"sum\"")
  @ParameterizedTest(name = "{index}. numbers={0} sum={1} indices={2}")
  @MethodSource("argsSource")
  void twoSum(int[] input, int target, int[] expected) {
    int[] result = solution.twoSum(input, target);
    assertArrayEquals(expected, result,
        "%s %s".formatted(Arrays.toString(expected), Arrays.toString(result)));
  }
}