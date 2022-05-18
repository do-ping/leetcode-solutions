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

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    final int m = nums1.length;
    final int n = nums2.length;
    double result = 0d;

    if (m == 0 && n == 0) {
      return result;
    } else if (m == 0) {
      // for even n: (nums[n/2+1]+nums[n/2]) / 2, for odd n: nums[nums.length/2]
      return (n & 1) == 0 ? (double) (nums2[n >> 1] + nums2[(n >> 1) - 1]) / 2 : nums2[n >> 1];
    } else if (n == 0) {
      // for even m: (nums[m/2+1]+nums[m/2]) / 2, for odd m: nums[m/2+1]
      return (m & 1) == 0 ? (double) (nums1[m >> 1] + nums1[(m >> 1) - 1]) / 2 : nums1[m >> 1];
    }

    int l = m + n;
    int[] mn = new int[l];
    System.arraycopy(nums1, 0, mn, 0, m);
    System.arraycopy(nums2, 0, mn, m, n);

    Arrays.sort(mn);

    return (l & 1) == 0 ? (double) (mn[l >> 1] + mn[(l >> 1) - 1]) / 2 : mn[l >> 1];
  }

  public static void main(String[] args) {
    var s = new MedianOfTwoSortedArrays();
    s.findMedianSortedArrays(new int[]{0, 0, 0, 0, 0}, new int[]{-1, 0, 0, 0, 0, 0, 1});
  }
}
