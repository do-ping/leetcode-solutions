package easy;

import topics.TLinkedList;
import topics.TRecursion;
import topics.TStack;
import topics.TTwoPointers;

/**
 * <h1>234. Palindrome Linked List</h1>
 * <p>Given the <pre>head</pre> of a singly linked list, return <pre>true</pre> if it is a
 * palindrome.</p>
 *
 * <h2>Example 1:</h2>
 * <p>❶→❷→❷→❶
 * <br/>
 * <pre>
 *   <b>Input:</b> head = [1,2,2,1]
 *   <b>Output:</b> true
 * </pre></p>
 *
 * <h2>Example 2:</h2>
 * <p>❶→❷
 * <br/>
 * <pre>
 *   <b>Input:</b> head = [1,2]
 *   <b>Output:</b> false
 * </pre></p>
 *
 * <h3>Constraints:</h3>
 * <ul>
 *   <li>The number of nodes in the list is in the range [1, 10^5].</li>
 *   <li><code>0 <= Node.val <= 9</code></li>
 * </ul>
 *
 * <p><b>Follow up:</b> Could you do it in <code>O(n)</code> time and <code>O(1)</code> space?</p>
 * <p><b>Note to self:</b>
 * Runtime: 11 ms, faster than 43.00% of Java online submissions for Palindrome Linked List.
 * Memory Usage: 100.1 MB, less than 33.54% of Java online submissions for Palindrome Linked List.
 */
@TLinkedList
@TTwoPointers
@TStack
@TRecursion
public class PalindromeLinkedList {

  public boolean isPalindrome(ListNode head) {
    if (head.next == null) {
      return true;
    }
    if (head.next.next == null) {
      return head.val == head.next.val;
    }
    ListNode slowPointer = head;
    ListNode fastPointer = head;

    // after cycle, fast pointer is at the end of the list, slow - in the middle
    while (fastPointer.next != null) {
      if (fastPointer.next.next == null) {
        break;
      }
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }

    // reverse second half of the given list starting from slow pointer that sits in the middle
    ListNode last = reverse(slowPointer);

    // starting from the end of the list, traverse to the middle, simultaneously comparing
    // equally distanced digits: 1 2 3 2 1 -> 1=1 2=2.
    // As long as each pair of values equals, we got palindrome
    while (last.next != null) {
      if (head.val != last.val) {
        return false;
      }
      head = head.next;
      last = last.next;
    }

    return true;
  }

  static ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode rest = reverse(head.next);
    head.next.next = head;

    head.next = null;
    return rest;
  }

  static class ListNode {

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
