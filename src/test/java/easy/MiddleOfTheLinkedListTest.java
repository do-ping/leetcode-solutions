package easy;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import easy.MiddleOfTheLinkedList.ListNode;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MiddleOfTheLinkedListTest {

  private static ListNode buildList(List<Integer> numbers) {
    ListNode first = null;
    for (int num : numbers) {
      if (first == null) {
        first = new ListNode(num);
        continue;
      }
      ListNode last = first;
      while (last.next != null) {
        last = last.next;
      }
      last.next = new ListNode(num);
    }

    return first;
  }

  private static boolean linkedListsEqual(ListNode first, ListNode other) {
    while (first != null && other != null) {
      if (first.val != other.val) {
        return false;
      }
      first = first.next;
      other = other.next;
    }

    return true;
  }

  private static Stream<Arguments> argsStream() {
    return Stream.of(
        arguments(
            List.of(1, 2, 3, 4, 5),
            List.of(3, 4, 5)),
        arguments(
            List.of(1, 2, 3, 4, 5, 6),
            List.of(4, 5, 6)),
        arguments(
            List.of(1, 2),
            List.of(2)),
        arguments(
            List.of(9, 15, 23, 56, 3, 10, 25),
            List.of(56, 3, 10, 25)),
        arguments(
            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1),
            List.of(0, 9, 8, 7, 6, 5, 4, 3, 2, 1)),
        arguments(
            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1),
            List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1))
    );
  }

  private final MiddleOfTheLinkedList solution = new MiddleOfTheLinkedList();

  @DisplayName("Given linked list numbers, then should return second half of the list "
      + "starting from the middle element or next after middle if elements qunatity is even")
  @ParameterizedTest(name = "{index}. list={0} fromMiddle={1}")
  @MethodSource("argsStream")
  void middleNode(List<Integer> numbers, List<Integer> fromMiddle) {
    var expected = buildList(fromMiddle);
    var actual = solution.middleNode(buildList(numbers));
    assertTrue(linkedListsEqual(expected, actual), "Got: %s".formatted(actual));
  }
}