package hard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MedianOfTwoSortedArraysTest {

  private static Stream<Arguments> argsSource() {
    return Stream.of(
        arguments(new int[0], new int[0], 0f),            // both empty
        arguments(new int[]{1}, new int[0], 1f),                 // 1st one element, 2d empty
        arguments(new int[]{1, 2, 3}, new int[0], 2f),           // 1st odd, 2d empty
        arguments(new int[]{1, 2, 3, 4}, new int[0], 2.5f),      // 1st even, 2d empty
        arguments(new int[0], new int[]{1}, 1f),                 // 1st empty, 2d one element
        arguments(new int[0], new int[]{2, 4, 6}, 4f),           // 1st empty, 2d odd
        arguments(new int[0], new int[]{11, 22, 33, 44}, 27.5f), // 1st empty, 2d even
        arguments(new int[]{3}, new int[]{33}, 18f),             // both one element
        arguments(new int[]{1, 3}, new int[]{2}, 2.0f),          // total odd
        arguments(new int[]{1, 2}, new int[]{3, 4}, 2.5f),       // total even
        arguments(new int[]{44, 55, 99, 222}, new int[]{66, 77, 88, 111}, 82.5f),
        arguments(new int[]{0, 0, 0, 0, 0}, new int[]{-1, 0, 0, 0, 0, 0, 1}, 0f)
    );
  }

  private final MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

  @DisplayName("Given two sorted arrays, should return their median")
  @ParameterizedTest(name = "{index}. {2} is median of nums1={0} and nums2={1}")
  @MethodSource("argsSource")
  void findMedianSortedArrays(int[] nums1, int[] nums2, float expectedMedian) {
    assertEquals(expectedMedian, solution.findMedianSortedArrays(nums1, nums2));
  }
}