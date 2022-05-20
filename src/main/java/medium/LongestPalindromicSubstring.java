package medium;

import topics.TDynamicProgramming;
import topics.TString;

/**
 * <h1>5. Longest Palindromic Substring</h1>
 * <p>Given a string <code>s</code>, return <i>the longest palindromic substring</i> in
 * <code>s</code>.</p>
 * <h2>Example 1:</h2>
 * <pre>
 * <strong>Input:</strong> s = "babad"
 * <strong>Output:</strong> "bab"
 * <strong>Explanation:</strong> "aba" is also a valid answer.
 * </pre>
 * <h2>Example 2:</h2>
 * <pre>
 * <strong>Input:</strong> s = "cbbd"
 * <strong>Output:</strong> "bb"
 * </pre>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>1 <= s.length <= 1000</code></li>
 *   <li><code>s</code> consist of only digits and English letters.</li>
 * </ul>
 *
 * @version 1
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/">on leetcode</a>
 * @see "Manacher's algorithm"
 */
@TString
@TDynamicProgramming
public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    final int length = s.length();
    if (s.isEmpty() || length > 1000) {
      return "";
    }
    if (length == 1) {
      return s;
    }
    // separator to be inserted around every char (level -> |l|e|v|e|l|)
    final char separator = '|';
    final char[] T = new char[(length << 1) + 1]; // T - separated string
    final int n = T.length;
    for (int i = 0; i < n; i++) {
      T[i] = (i & 1) == 0 ? separator : s.charAt(i >> 1);
    }
    // P = palindrome centers length
    // P[i] equals to the length of the palindrome centers at T[i].
    // The longest palindromic substring would then be the maximum element in P.
    final int[] P = new int[n];
    int C = 0, R = 0, left, right;
    for (int i = 1; i < n - 1; i++) {
      int iMirror = 2 * C - i; // i' = C - (i-C)
      P[i] = (R > i) ? Math.min(R - i, P[iMirror]) : 0;

      // attempt to extend palindrome centered at i
      while (true) {
        left = i - 1 - P[i];
        right = i + 1 + P[i];
        if (left >= 0 && right < n && T[left] == T[right]) {
          ++P[i];
        } else {
          break;
        }
      }

      // if palindrome centered at i expand past R, adjust center based on expanded palindrome
      if ((i + P[i]) > R) {
        C = i;
        R = i + P[i];
      }
    }

    // find the maximum element in P
    int maxLength = 0;
    int centerIndex = 0;
    for (int i = 0; i < n; i++) {
      if (P[i] > maxLength) {
        maxLength = P[i];
        centerIndex = i;
      }
    }

    return s.substring((centerIndex - maxLength) >> 1, (centerIndex + maxLength) >> 1);
  }
}
