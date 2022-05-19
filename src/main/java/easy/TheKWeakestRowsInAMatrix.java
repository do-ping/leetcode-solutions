package easy;

import topics.TArray;
import topics.TBinarySearch;
import topics.THeap;
import topics.TMatrix;
import topics.TPriorityQueue;
import topics.TSorting;

/**
 * <h1>1337. The K Weakest Rows in a Matrix</h1>
 * <p>You are given an <code>m x n</code> binary matrix <code>mat</code> of <code>1</code>'s
 * (representing soldiers) and <code>0</code>'s (representing civilians). The soldiers are
 * positioned <b>in front</b> of the civilians. That is, all the <code>1</code>'s will appear to
 * the
 * <b>left</b> of all the <code>0</code>'s in each row.</p>
 * <p>A row <code>i</code> is <b>weaker</b> than a row <code>j</code> if one of the following is
 * true:</p>
 * <ul>
 *   <li>The number of soldiers in row <code>i</code> is less than the number of soldiers in row
 *   <code>j</code>.</li>
 *   <li>Both rows have the same number of soldiers and <code>i < j</code>.</li>
 * </ul>
 * <p>Return <i>the indices of the <code>k</code> <b>weakest</b> rows in the matrix ordered from
 * weakest to strongest</i>.</p>
 * <h2>Example 1:</h2>
 *   <pre>
 *     <b>Input:</b> mat =
 *     [[1,1,0,0,0],
 *      [1,1,1,1,0],
 *      [1,0,0,0,0],
 *      [1,1,0,0,0],
 *      [1,1,1,1,1]],
 *     k = 3
 *     <b>Output:</b> [2,0,3]
 *     <b>Explanation:</b>
 *     The number of soldiers in each row is:
 *     - Row 0: 2
 *     - Row 1: 4
 *     - Row 2: 1
 *     - Row 3: 2
 *     - Row 4: 5
 *     The rows ordered from weakest to strongest are [2,0,3,1,4].
 *   </pre>
 * <h2>Example 2:</h2>
 *   <pre>
 *     <b>Input:</b> mat =
 *     [[1,0,0,0],
 *      [1,1,1,1],
 *      [1,0,0,0],
 *      [1,0,0,0]],
 *     k = 2
 *     <b>Output:</b> [0,2]
 *     <b>Explanation:</b>
 *     The number of soldiers in each row is:
 *     - Row 0: 1
 *     - Row 1: 4
 *     - Row 2: 1
 *     - Row 3: 1
 *     The rows ordered from weakest to strongest are [0,2,3,1].
 *   </pre>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>m == mat.length</code></li>
 *   <li><code>n == mat[i].length</code></li>
 *   <li><code>2 <= n, m <= 100</code></li>
 *   <li><code>1 <= k <= m</code></li>
 *   <li><code>matrix[i][j]</code> is either 0 or 1</li>
 * </ul>
 */
@TMatrix
@TBinarySearch
@TSorting
@THeap
@TPriorityQueue
@TArray
public class TheKWeakestRowsInAMatrix {

  public int[] kWeakestRows(int[][] mat, int k) {
    int[][] queue = new int[mat.length][2];
    for (int i = 0; i < mat.length; i++) {
      queue[i] = new int[]{i, binarySearch(mat[i])};
    }

    int[] result = new int[k];
    int heapSize = mat.length;
    for (int i = k; i > 0; i--) {
      int max = 0;
      for (int j = 1; j < heapSize; j++) {
        if ((queue[max][1] == queue[j][1] && queue[max][0] > queue[j][0]) ||
            queue[max][1] > queue[j][1]) {
          max = j;
        }
      }
      // exchange
      int[] temp = queue[max];
      queue[max] = queue[heapSize - 1];
      queue[heapSize - 1] = temp;
      // get first
      result[result.length - i] = queue[--heapSize][0];
    }
    return result;
  }

  static int binarySearch(int[] row) {
    int lo = 0;
    int hi = row.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (row[mid] == 0) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }
}
