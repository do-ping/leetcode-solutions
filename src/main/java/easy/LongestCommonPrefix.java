package easy;

import java.util.Arrays;
import topics.TString;

/**
 * <h1>14. Longest Common Prefix</h1>
 * <p>Write a function to find the longest common prefix string amongst an array of strings.</p>
 * <p>If there is no common prefix, return an empty string <code>""</code>.</p>
 * <h2>Example 1:</h2>
 * <pre>
 * <strong>Input:</strong> strs = ["flower","flow","flight"]
 * <strong>Output:</strong> "fl"
 * </pre>
 * <h2>Example 2:</h2>
 * <pre>
 * <strong>Input:</strong> strs = ["dog","racecar","car"]
 * <strong>Output:</strong> ""
 * <strong>Explanation:</strong> There is no common prefix among the input strings.
 * </pre>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>1 <= strs.length <= 200</code></li>
 *   <li><code>0 <= strs[i].length <= 200</code></li>
 *   <li><code>strs[i]</code> consists of only lower-case English letters.</li>
 * </ul>
 */
@TString
public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0 || strs.length > 200) {
      return "";
    } else if (strs.length == 1) {
      return strs[0];
    }

    String firstWord = strs[0];
    if (firstWord.isEmpty()) {
      return "";
    }
    final char[] firstWordChars = strs[0].toCharArray();
    int currentLongest = firstWordChars.length;

    for (int i = 1; i < strs.length; i++) {
      String str = strs[i];
      // break on empty string or mismatching first character
      if (str.isEmpty() || str.charAt(0) != firstWordChars[0]) {
        return "";
      }
      // skip on the same word
      if (str.equals(firstWord)) {
        continue;
      }
      // reduce current longest prefix if current string is shorter than first
      if (str.length() < currentLongest) {
        currentLongest = str.length();
      }
      // compare first word with current char by char
      for (int j = 1; j < currentLongest; j++) {
        if (firstWordChars[j] != str.charAt(j)) {
          currentLongest = j;
          break;
        }
      }
    }

    return String.valueOf(Arrays.copyOfRange(firstWordChars, 0, currentLongest));
  }
}
