package medium;

import topics.TLinkedList;
import topics.TMath;
import topics.TRecursion;

/**
 * <h1>2. Add Two Numbers</h1>
 * <p>You are given two <code>non-empty</code> linked lists representing two non-negative integers.
 * The digits are stored in <code>reverse order</code>, and each of their nodes contains a single
 * digit. Add the two numbers and return the sum as a linked list.</p>
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0
 * itself.</p>
 * <h2>Example 1:</h2>
 * <p>
 * ②→④→③<br/> ⑤→⑥→④<br/> -----------<br/> ⑦→⓪→⑧<br/>
 * <code>
 * <strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]<br/>
 * <strong>Output:</strong> [7,0,8]<br/>
 * <strong>Explanation:</strong> 342 + 465 = 807.
 * </code>
 * </p>
 * <h2>Example 2:</h2>
 * <p>
 * <code>
 * <strong>Input:</strong> l1 = [0], l2 = [0]<br/>
 * <strong>Output:</strong> [0]
 * </code>
 * </p>
 * <h2>Example 3:</h2>
 * <p>
 * <code>
 * <strong>Input:</strong> l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]<br/>
 * <strong>Output:</strong> [8,9,9,9,0,0,0,1]
 * </code>
 * </p>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li>
 *   <li><code>0 <= Node.val <= 9</code></li>
 *   <li>It is guaranteed that the list represents a number that does not have leading zeros.</li>
 * </ul>
 * <h4>Related topics:</h4>
 * <ul>
 *   <li>Linked List</li>
 *   <li>Math</li>
 *   <li>Recursion</li>
 * </ul>
 */
@TLinkedList
@TRecursion
@TMath
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1.next == null && l1.val == 0) {
      return l2;
    }
    if (l2.next == null && l2.val == 0) {
      return l1;
    }

    return add(l1, l2, 0);
  }

  ListNode add(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null && carry == 0) {
      return null;
    }
    int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
    l1 = l1 != null ? l1.next : null;
    l2 = l2 != null ? l2.next : null;
    return new ListNode(sum % 10, add(l1, l2, sum / 10));
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

}
