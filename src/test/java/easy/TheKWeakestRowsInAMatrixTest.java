package easy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TheKWeakestRowsInAMatrixTest {

  private static Stream<Arguments> argumentsStream() {
    return Stream.of(
        arguments(new int[][]{
            new int[]{1, 1, 0, 0, 0},
            new int[]{1, 1, 1, 1, 0},
            new int[]{1, 0, 0, 0, 0},
            new int[]{1, 1, 0, 0, 0},
            new int[]{1, 1, 1, 1, 1},}, 3, new int[]{2, 0, 3}),
        arguments(new int[][]{
            new int[]{1, 0, 0, 0},
            new int[]{1, 1, 1, 1},
            new int[]{1, 0, 0, 0},
            new int[]{1, 0, 0, 0}
        }, 2, new int[]{0, 2}),
        arguments(new int[][]{
            new int[]{1, 0},
            new int[]{1, 0},
            new int[]{1, 0},
            new int[]{1, 1}
        }, 4, new int[]{0, 1, 2, 3})
    );
  }

  private final TheKWeakestRowsInAMatrix solution = new TheKWeakestRowsInAMatrix();

  @DisplayName("Given binary matrix (mat) and desired number of weakest rows (k) to show, then "
      + "should return expected rows")
  @ParameterizedTest(name = "{index}. k={1} mat={0} result={2}")
  @MethodSource("argumentsStream")
  void kWeakestRows(int[][] mat, int k, int[] expected) {
    int[] result = solution.kWeakestRows(mat, k);
    assertArrayEquals(expected, result,
        "%s %s".formatted(Arrays.toString(expected), Arrays.toString(result)));
  }

  @Test
  void search() {
    assertEquals(3, TheKWeakestRowsInAMatrix.binarySearch(new int[]{1, 1, 1, 0, 0}));
  }
}