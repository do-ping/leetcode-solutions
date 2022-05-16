package easy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import easy.PalindromeLinkedList.ListNode;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PalindromeLinkedListTest {

  private final PalindromeLinkedList solution = new PalindromeLinkedList();

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

  private static Stream<Arguments> argsStream() {
    return Stream.of(
        arguments(List.of(1), true),
        arguments(List.of(1, 1), true),
        arguments(List.of(1, 4, 7, 4, 1), true),
        arguments(List.of(2, 2, 2), true),
        arguments(List.of(1, 2, 2, 1), true),
        arguments(List.of(9, 8, 1, 2, 7, 6, 4, 5, 5, 4, 6, 7, 2, 1, 8, 9), true),
        arguments(List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1), true),
        arguments(List.of(5, 1, 2, 5, 2, 1, 5), true),
        arguments(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1), true),
        arguments(List.of(1, 2), false),
        arguments(List.of(2, 3, 5), false),
        arguments(List.of(7, 0, 0), false),
        arguments(List.of(1, 1, 2, 1), false),
        arguments(List.of(1, 2, 3, 4, 5), false),
        arguments(List.of(2, 0, 2, 0, 2, 1), false)
    );
  }

  @ParameterizedTest(name = "{index}. {0} is palindrome: {1}")
  @MethodSource(value = "argsStream")
  void isPalindrome(List<Integer> numbers, boolean expected) {
    ListNode firstNode = buildList(numbers);
    assertEquals(expected, solution.isPalindrome(firstNode));
  }
}