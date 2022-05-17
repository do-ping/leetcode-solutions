package easy;

import java.util.Arrays;
import java.util.List;
import topics.TMath;
import topics.TString;

/**
 * <h1>412. Fizz Buzz</h1>
 * <p>Given an integer <code>n</code>, return <i>a string array</i> <code>answer</code> <i>
 * (<b>1-indexed</b>) where:</i>
 * <ul>
 *   <li><code>answer[i] == "FizzBuzz"</code> if <code>i</code> is divisible by <code>3</code>
 *   and <code>5</code>.</li>
 *   <li><code>answer[i] == "Fizz"</code> if <code>i</code> is divisible by <code>3</code>.</li>
 *   <li><code>answer[i] == "Buzz"</code> if <code>i</code> is divisible by <code>5</code>.</li>
 *   <li><code>answer[i] == i</code> (as string) if none of the above conditions are true.</li>
 * </ul>
 * </p>
 * <h2>Example 1:</h2>
 * <pre>
 *     <b>Input:</b> n = 3
 *     <b>Output:</b> ["1", "2", "Fizz"]
 * </pre>
 * <h2>Example 2:</h2>
 *  <pre>
 *      <b>Input:</b> n = 5
 *      <b>Output:</b> ["1", "2", "Fizz", "4", "Buzz"]
 *  </pre>
 *  <h2>Example 3:</h2>
 *  <pre>
 *      <b>Input:</b> n = 15
 *      <b>Output:</b> ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11",
 *      "Fizz", "13", "14", "FizzBuzz"]
 *  </pre>
 *  <h3>Constraints:</h4>
 *  <ul>
 *    <li><code>1 <= n <= 10^4</code></li>
 *  </ul>
 *  <h3>Related topics:</h4>
 *  <ul>
 *    <li>Math</li>
 *    <li>String</li>
 *    <li>Simulation</li>
 *  </ul>
 */
@TMath
@TString
public class FizzBuzz {

  public List<String> fizzBuzz(int n) {
    String[] result = new String[n];
    do {
      result[n - 1] = n % 15 == 0 ? "FizzBuzz"
          : n % 5 == 0 ? "Buzz"
              : n % 3 == 0 ? "Fizz"
                  : Integer.toString(n);
      n--;
    } while (n > 0);
    return Arrays.asList(result);
  }
}
