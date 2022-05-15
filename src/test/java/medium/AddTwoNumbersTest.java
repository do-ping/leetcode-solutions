package medium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import medium.AddTwoNumbers.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AddTwoNumbersTest {

  /**
   * Build Linked List from given array of integers.
   *
   * @param array linked list represented as array of integers
   * @return head of {@link ListNode}
   */
  private static ListNode buildList(int[] array) {
    ListNode first = new ListNode(array[0]);
    ListNode current = first;
    for (int i = 1; i < array.length; i++) {
      current.next = new ListNode(array[i]);
      current = current.next;
    }
    return first;
  }

  /**
   * Build {@link List} from given linked list.
   *
   * @param head first {@link ListNode} of linked list
   * @return {@link List} representation of given linked list
   */
  private static List<Integer> toList(ListNode head) {
    List<Integer> result = new LinkedList<>();
    while (head != null) {
      result.add(head.val);
      head = head.next;
    }
    return result;
  }

  private final AddTwoNumbers solution = new AddTwoNumbers();

  private static Stream<Arguments> argsSource() {
    return Stream.of(
        arguments(
            new int[]{2, 4, 3},
            new int[]{5, 6, 4},
            new int[]{7, 0, 8}),
        arguments(new int[]{0}, new int[]{0}, new int[]{0}),
        arguments(
            new int[]{9, 9, 9, 9, 9, 9, 9},
            new int[]{9, 9, 9, 9},
            new int[]{8, 9, 9, 9, 0, 0, 0, 1}),
        arguments(
            new int[]{9, 8, 1},
            new int[]{1, 1},
            new int[]{0, 0, 2}),
        arguments(
            new int[]{5},
            new int[]{5},
            new int[]{0, 1})
    );
  }

  @DisplayName("Given two Linked Lists (l1, l2) representing integers, when applied, then should "
      + "return Linked List (sum) representing sum of these numbers")
  @ParameterizedTest(name = "{index}. l1={0} l2={1} sum={2}")
  @MethodSource("argsSource")
  void addTwoNumbers(int[] l1, int[] l2, int[] expected) {
    List<Integer> e = Arrays.stream(expected).boxed().toList();
    List<Integer> actual = toList(solution.addTwoNumbers(buildList(l1), buildList(l2)));
    assertEquals(e, actual, "Sum differs: expected - %s, got - %s".formatted(e, actual));
  }
}