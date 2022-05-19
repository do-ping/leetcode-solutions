package easy;

import topics.TBitManipulation;
import topics.TMath;

/**
 * <h1>1342. Number of Steps to Reduce a Number to Zero</h1>
 * <p>Given an integer <code>num</code>, return <i>the number of steps to reduce it to zero</i>.
 * In one step, if the current number is even, you have to divide it by <code>2</code>, otherwise,
 * you have to subtract <code>1</code> from it.</p>
 * <h2>Example 1:</h2>
 * <pre>
 *  <b>Input:</b> num = 14
 *  <b>Output:</b> 6
 *  <b>Explanation:</b>
 * Step 1) 14 is even; divide by 2 and obtain 7.
 * Step 2) 7 is odd; subtract 1 and obtain 6.
 * Step 3) 6 is even; divide by 2 and obtain 3.
 * Step 4) 3 is odd; subtract 1 and obtain 2.
 * Step 5) 2 is even; divide by 2 and obtain 1.
 * Step 6) 1 is odd; subtract 1 and obtain 0.
 * </pre>
 * <h2>Example 2:</h2>
 * <pre>
 * <b>Input:</b> num = 8
 * <b>Output:</b> 4
 * <b>Explanation:</b>
 * Step 1) 8 is even; divide by 2 and obtain 4.
 * Step 2) 4 is even; divide by 2 and obtain 2.
 * Step 3) 2 is even; divide by 2 and obtain 1.
 * Step 4) 1 is odd; subtract 1 and obtain 0.
 * </pre>
 * <h2>Example 3:</h2>
 * <pre>
 * <b>Input:</b> num = 123
 * <b>Output:</b> 12
 * </pre>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>0 <= num <= 10^6</code></li>
 * </ul>
 */
@TBitManipulation
@TMath
public class NumberOfStepsToReduceNumberToZero {

  public int numberOfSteps(int num) {
    if (num <= 2) {
      return num;
    }

    int result = 0;
    // even or odd: i & 1 = 0 - even | 1 - odd
    // divide number by two: num >> 1 == num / 2
    // num ^ 1 == num - 1 - because we subtract 1, we don't need "borrow" bit and loop until it's 0
    while (num != 0) {
      num = (num & 1) == 0 ? num >> 1 : num ^ 1;
      result++;
    }

    return result;
  }
}
