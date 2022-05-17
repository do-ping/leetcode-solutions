package easy;

import topics.TLinkedList;
import topics.TTwoPointers;

/**
 * <h1>876. Middle of the Linked List</h1>
 * <p>Given the <code>head</code> of a singly linked list, return <i>the middle node of the linked
 * list</i>.</p>
 * <p>If there are two middle nodes, return <b>the second middle node.</b></p>
 * <h2>Example 1:</h2>
 * <p>①→②→③→④→⑤
 * <br/>
 * <pre>
 *    <b>Input:</b> head = [1,2,3,4,5]
 *    <b>Output:</b> [3,4,5]
 *    <b>Explanation:</b> The middle node of the list is node 3.
 * </pre>
 * </p>
 * <h2>Example 2:</h2>
 * <p>①→②→③→④→⑤→⑥
 * <br/>
 * <pre>
 *    <b>Input:</b> head = [1,2,3,4,5,6]
 *    <b>Output:</b> [4,5,6]
 *    <b>Explanation:</b> Since the list has two middle nodes with values 3 and 4, we return the
 * second node.
 * </pre>
 * </p>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li>The number of nodes in the list is in the range <code>[1, 100]</code></li>
 *   <li><code>1 <= Node.val <= 100</code></li>
 * </ul>
 */
@TLinkedList
@TTwoPointers
public class MiddleOfTheLinkedList {

  public ListNode middleNode(ListNode head) {
    ListNode slowPointer = head;
    ListNode fastPointer = head;

    // when fast pointer reaches the end, slow pointer will be in the middle of the list
    while (fastPointer.next != null) {
      // move slow pointer to the next element after middle in a list with even number of elements
      // 1 2 3 4 5 6
      // i=1: slow=2, fast=3
      // i=2: slow=3, fast=5, fast.next.next = null, slow=slow.next=4
      if (fastPointer.next.next == null) {
        slowPointer = slowPointer.next;
        break;
      }
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }

    return slowPointer;
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
