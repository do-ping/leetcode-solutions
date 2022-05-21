package medium;

import topics.TMath;

/**
 * <h1>7. Reverse Integer</h1>
 * <p>Given a signed 32-bit integer <code>x</code>, return <code>x</code> <i>with its digits
 * reversed.</i> If reversing <code>x</code> causes the value to go outside the signed 32-bit
 * integer range <code>[-2<sup>31</sup>, 2<sup>31</sup> - 1]</code>, then return <code>0</code></p>
 * <p><strong>Assume the environment does not allow you to store 64-bit integers (signed or
 * unsigned).</strong></p>
 * <h2>Example 1:</h2>
 * <pre>
 * <strong>Input:</strong> x = 123
 * <strong>Output:</strong> 321
 * </pre>
 * <h2>Example 2:</h2>
 * <pre>
 * <strong>Input:</strong> x = -123
 * <strong>Output:</strong> -321
 * </pre>
 * <h2>Example 3:</h2>
 * <pre>
 * <strong>Input:</strong> x = 120
 * <strong>Output:</strong> 21
 * </pre>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>-2<sup>31</sup> <= x <= 2<sup>31</sup> - 1</code></li>
 * </ul>
 */
@TMath
public class ReverseInteger {

  public int reverse(int x) {
    long rev = 0;

    // write down number signum, remove it temporarily for negative numbers
    // and if the number overflows, simply return
    final boolean isNegative = ((x >> 31) | (-x >>> 31)) < 0;
    if (isNegative) {
      if (x == Integer.MIN_VALUE) {
        return 0;
      }
      x = -x;
    }

    // get last number of digit with %10, write last number to first,
    // divide original number by 10 to get number without last digit
    while (x > 0) {
      rev = rev * 10 + x % 10;
      x /= 10;
    }

    if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
      return 0;
    }

    return (int) (isNegative ? rev * -1: rev);
  }
}
