package easy;

import java.util.HashMap;
import java.util.Map;
import topics.TArray;
import topics.THashTable;

/**
 * <h1>1. Two Sum</h1>
 * <p>Given an array of integers <code>nums</code> and an integer <code>target</code>, return
 * <i>indices of the two numbers such that they add up to <code>target</code></i>.</p>
 * <p>You may assume that each input would have <strong><i>exactly</i> one solution</strong>, and
 * you may not use the <i>same</i> element twice.</p>
 * <p>You can return the answer in any order.</p>
 * <h2>Example 1:</h2>
 * <p>
 * <code>
 * <b>Input:</b> nums = [2,7,11,15], target = 9<br/>
 * <b>Output:</b> [0,1]<br/>
 * <b>Explanation:</b> Because nums[0] + nums[1] == 9, we return [0, 1].
 * </code>
 * </p>
 * <h2>Example 2:</h2>
 * <p>
 * <code>
 * <b>Input:</b> nums = [3,2,4], target = 6<br/>
 * <b>Output:</b> [1,2]<br/>
 * </code>
 * </p>
 * <h2>Example 3:</h2>
 * <p>
 * <code>
 * <b>Input:</b> nums = [3,3], target = 6<br/>
 * <b>Output:</b> [0,1]<br/>
 * </code>
 * </p>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>2 <= nums.length <= 10^4</code></li>
 *   <li><code>-10^9 <= nums[i] <= 10^9</code></li>
 *   <li><code>-10^9 <= target <= 10^9</code></li>
 *   <li><strong>Only one valid answer exists.</strong></li>
 * </ul>
 * <h3>Follow-up:</h3>
 * <p>Can you come up with an algorithm that is less than <code>O(n^2)</code> time complexity?</p>
 * <h4>Related topics:</h4>
 * <ul>
 *   <li>Array</li>
 *   <li>Hash Table</li>
 * </ul>
 */
@TArray
@THashTable
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (map.containsKey(target - diff)) {
        result[0] = map.get(target - diff);
        result[1] = i;
        break;
      }
      map.put(diff, i);
    }
    return result;
  }
}
