package hard;


import java.util.Arrays;
import topics.TArray;
import topics.TBinarySearch;
import topics.TDivideAndConquer;

/**
 * <h1>4. Median of Two Sorted Arrays</h1>
 * <p>Given two sorted arrays <code>nums1</code> and <code>nums2</code> of size <code>m</code>
 * and <code>n</code> respectively, return <strong>the median</strong> of the two sorted
 * arrays.</p>
 * <p>The overall run time complexity should be <code>O(log (m+n))</code>.</p>
 * <h2>Example 1:</h2>
 * <pre>
 * <strong>Input:</strong> nums1 = [1,3], nums2 = [2]
 * <strong>Output:</strong> 2.00000
 * <strong>Explanation:</strong> merged array = [1,2,3] and median is 2.
 * </pre>
 * <h2>Example 2:</h2>
 * <pre>
 * <strong>Input:</strong> nums1 = [1,2], nums2 = [3,4]
 * <strong>Output:</strong> 2.50000
 * <strong>Explanation:</strong> merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * </pre>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>nums1.length == m</code></li>
 *   <li><code>nums2.length == n</code></li>
 *   <li><code>0 <= m <= 1000</code></li>
 *   <li><code>0 <= n <= 1000</code></li>
 *   <li><code>1 <= m + n <= 2000</code></li>
 *   <li><code>-10^6 <= nums1[i], nums2[i] <= 10^6</code></li>
 * </ul>
 */
@TArray
@TBinarySearch
@TDivideAndConquer
public class MedianOfTwoSortedArrays {

  // TODO: get back later
  public float findMedianSortedArrays(int[] nums1, int[] nums2) {
    // https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
    return nums1.length > nums2.length
        ? f(nums2, nums2.length, nums1, nums1.length)
        : f(nums1, nums1.length, nums2, nums2.length);
  }

  private static float findMedium(int[] array, int length) {
    return length == 0 ? 0f : length == 1 ? array[0] : (length & 1) == 0
        ? (float) ((array[length >> 1] + array[(length >> 1) - 1]) / 2)
        : array[length >> 1];
  }

  private static float f(int[] smaller, int s, int[] larger, int l) {
    if (s == 0 && l == 0) {
      return -1f;
    } else if (s == 0) {
      return findMedium(larger, l);
    } else if (l == 0) {
      return findMedium(smaller, s);
    } else if (s == 1) {
      if (l == 1) {
        return (float) (smaller[0] + larger[0]) / 2f;
      }
      int mid = l >> 1;
      return (l & 1) == 0
          ? (float) (smaller[0] + larger[mid] + larger[mid - 1]) / 3f
          : (float) (smaller[0] + larger[mid] + larger[mid + 1] + larger[mid - 1]) / 4f;
    } else if (s == 2) {
      if (l == 2) {
        return (float) (smaller[0] + smaller[1] + larger[0] + larger[1]) / 4f;
      }
      int mid = l >> 1;

      if ((l & 1) != 0) {
        int midL = larger[mid];
        int maxLastSBeforeMidL = Math.max(smaller[1], larger[mid - 1]);
        int minFirstSAfterMidL = Math.min(smaller[0], larger[mid + 1]);
        return Math.max(
            Math.min(midL, maxLastSBeforeMidL),
            Math.max(maxLastSBeforeMidL, minFirstSAfterMidL));
      }
      // l&1 == 0
      return (float) (larger[mid] + larger[mid - 1]
          + Math.max(smaller[0], larger[mid - 2])
          + Math.min(smaller[1], larger[mid + 1])) / 4f;
    }

    int midS = (s >> 1) - 1;
    int midL = (l >> 1) - 1;
    if (smaller[midS] <= larger[midL]) {
      return f(Arrays.copyOfRange(smaller, midS, s), (s >> 1) + 1, larger, l - midS);
    }
    return f(smaller, (s >> 1) + 1, Arrays.copyOfRange(larger, midL, l), l - midS);
  }

  public static void main(String[] args) {
    var s = new MedianOfTwoSortedArrays();
    s.findMedianSortedArrays(new int[]{0, 0, 0, 0, 0}, new int[]{-1, 0, 0, 0, 0, 0, 1});
  }
}
