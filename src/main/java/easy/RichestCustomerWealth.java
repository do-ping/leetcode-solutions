package easy;

import topics.TArray;
import topics.TMatrix;

/**
 * <h1>1672. Richest Customer Wealth</h1>
 * <p>You are given an <code>m x n</code> integer grid <code>accounts</code> where
 * <code>accounts[i][j]</code> is the amount of money the <code>ith</code> customer has in the
 * <code>jth</code> bank. Return <i>the <b>wealth</b> that the richest customer has.</i></p>
 * <p>A customer's <b>wealth</b> is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum <b>wealth</b>.</p>
 *
 * <h2>Example 1:</h2>
 * <pre>
 * <strong>Input:</strong> accounts = [[1,2,3],[3,2,1]]
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong>
 * 1st customer has wealth = 1 + 2 + 3 = 6
 * 2nd customer has wealth = 3 + 2 + 1 = 6
 * Both customers are considered the richest with a wealth of 6 each, so return 6.
 * </pre>
 * <h2>Example 2:</h2>
 * <pre>
 * <strong>Input:</strong> accounts = [[1,5],[7,3],[3,5]]
 * <strong>Output:</strong> 10
 * <strong>Explanation:</strong>
 * 1st customer has wealth = 6
 * 2nd customer has wealth = 10
 * 3rd customer has wealth =8
 * The 2nd customer is the richest with a wealth of 10.
 * </pre>
 * <h2>Example 3:</h2>
 * <pre>
 * <strong>Input:</strong> accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * <strong>Output:</strong> 17
 * </pre>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>m == accounts.length</code></li>
 *   <li><code>n == accounts[i].length</code></li>
 *   <li><code>1 <= m, n <= 50</code></li>
 *   <li><code>1 <= accounts[i][j] <= 100</code></li>
 * </ul>
 */
@TArray
@TMatrix
public class RichestCustomerWealth {

  public int maximumWealth(int[][] accounts) {
    int result = 0;

    for (int[] customer : accounts) {
      int totalBalance = 0;
      for (int account : customer) {
        totalBalance += account;
      }
      if (totalBalance > result) {
        result = totalBalance;
      }
    }

    return result;
  }
}
