package medium;

import topics.TString;

/**
 * <h1>8. String to Integer (atoi)</h1>
 * <p>Implement the <code>myAtoi(string s)</code> function, which converts a string to a 32-bit
 * signed integer (similar to C/C++'s <code>atoi</code> function).</p>
 * <p>The algorithm for <code>myAtoi(string s)</code> is as follows:</p>
 * <ol>
 *   <li>Read in and ignore any leading whitespace.</li>
 *   <li>Check if the next character (if not already at the end of the string) is
 *   <code>'-'</code> or <code>'+'</code>. Read this character in if it is either. This
 *   determines if the final result is negative or positive respectively. Assume the result is
 *   positive if neither is present.</li>
 *   <li>Read in next the characters until the next non-digit character or the end of the input
 *   is reached. The rest of the string is ignored.</li>
 *   <li>Convert these digits into an integer (i.e. <code>"123" -> 123, "0032" -> 32</code>). If
 *   no  digits were read, then the integer is <code>0</code>. Change the sign as necessary
 *   (from step 2).</li>
 *   <li>If the integer is out of the 32-bit signed integer range <code>[-2<sup>31</sup>,
 *   2<sup>31</sup> - 1]</code>, then clamp the integer so that it remains in the range.
 *   Specifically, integers less than <code>-2<sup>31</sup></code> should be clamped to
 *   <code>-2<sup>31</sup></code>, and integers greater than <code>2<sup>31</sup> - 1</code>
 *   should be clamped to <code>2<sup>31</sup> - 1</code>.</li>
 *   <li>Return the integer as the final result.</li>
 * </ol>
 * <h2>Note:</h2>
 * <ul>
 *   <li>Only the space character <code>' '</code> is considered a whitespace character.</li>
 *   <li><strong>Do not ignore</strong> any characters other than the leading whitespace or the
 *   rest of the string after the digits.</li>
 * </ul>
 * <h2>Example 1:</h2>
 * <pre>
 * <strong>Input:</strong> s = "42"
 * <strong>Output:</strong> 42
 * <strong>Explanation:</strong> The underlined characters are what is read in, the caret is the
 * current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * The parsed integer is 42.
 * Since 42 is in the range [-2<sup>31</sup>, 2<sup>31</sup> - 1], the final result is 42.
 * </pre>
 * <h2>Example 2:</h2>
 * <pre>
 * <strong>Input:</strong> s = "   -42"
 * <strong>Output:</strong> -42
 * <strong>Explanation:</strong>
 * Step 1: "   -42" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -42" ("42" is read in)
 *                ^
 * The parsed integer is -42.
 * Since -42 is in the range [-2<sup>31</sup>, 2<sup>31</sup> - 1], the final result is -42.
 * </pre>
 * <h2>Example 3:</h2>
 * <pre>
 * <strong>Input:</strong> s = "4193 with words"
 * <strong>Output:</strong> 4193
 * <strong>Explanation:</strong>
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
 *              ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-2<sup>31</sup>, 2<sup>31</sup> - 1], the final result is 4193.
 * </pre>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>0 <= s.length <= 200</code></li>
 *   <li><code>s</code> consists of English letters (lower-case and upper-case), digits
 *   (<code>0-9</code>), <code>' '</code>, <code>'+'</code>, <code>'-'</code>, and
 *   <code>'.'</code>.</li>
 * </ul>
 */
@TString
public class StringToIntegerATOI {

  public int myAtoi(String s) {
    long result = 0;
    if (s.isBlank()) {
      return 0;
    }

    int currentIndex = 0;
    while (s.charAt(currentIndex) == ' ') {
      ++currentIndex;
    }

    boolean isNegative = false;
    char currentChar = s.charAt(currentIndex);
    if (currentChar < '0') {
      if (currentChar == '-') {
        isNegative = true;
      } else if (currentChar != '+') {
        return (int) result;
      }
      currentIndex++;
    }

    while (currentIndex < s.length()) {
      currentChar = s.charAt(currentIndex);
      if (currentChar < '0' || currentChar > '9') {
        break;
      }

      int currentInt = switch (currentChar) {
        case '1' -> 1;
        case '2' -> 2;
        case '3' -> 3;
        case '4' -> 4;
        case '5' -> 5;
        case '6' -> 6;
        case '7' -> 7;
        case '8' -> 8;
        case '9' -> 9;
        default -> 0;
      };
      result = result * 10 + currentInt;

      if (result > Integer.MAX_VALUE) {
        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      if (result < Integer.MIN_VALUE) {
        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }

      ++currentIndex;
    }

    return isNegative ? -(int) result : (int) result;
  }
}
