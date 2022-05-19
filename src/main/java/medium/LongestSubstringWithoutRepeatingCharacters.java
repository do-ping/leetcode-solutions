package medium;

import topics.THashTable;
import topics.TString;

/**
 * <h1>3. Longest Substring Without Repeating Characters</h1>
 * <p>Given a string <code>s</code>, find the length of the longest substring without repeating
 * characters.</p>
 * <h2>Example 1:</h2>
 * <pre>
 * <strong>Input:</strong> s = "abcabcbb"
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The answer is "abc", with the length of 3.
 * </pre>
 * <h2>Example 2:</h2>
 * <pre>
 * <strong>Input:</strong> s = "bbbbb"
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The answer is "b", with the length of 1.
 * </pre>
 * <h2>Example 3:</h2>
 * <pre>
 * <strong>Input:</strong> s = "pwwkew"
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>0 <= s.length <= 5 * 10^4</code></li>
 *   <li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
 * </ul>
 */
@TString
@THashTable
public class LongestSubstringWithoutRepeatingCharacters {

  //TODO : add sliding window topic
  public int lengthOfLongestSubstring(String s) {
    if (s.length() < 2) {
      return s.length(); // 0 -> 0, 1 -> 1
    }

    int maxLength = 0;
    int startPointer = 0, endPointer = 0;

    for (int i = 0; i < s.length(); i++) {
      for (int j = startPointer; j < i; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          startPointer = j + 1;
          break;
        }
      }

      ++endPointer;

      if (endPointer - startPointer > maxLength) {
        maxLength = endPointer - startPointer;
      }
    }

    return maxLength;
  }
}
