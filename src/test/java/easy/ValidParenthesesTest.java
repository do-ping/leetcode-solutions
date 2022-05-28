package easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidParenthesesTest {

  private final ValidParentheses solution = new ValidParentheses();

  @DisplayName("Given input containing just parentheses, should answer whether it's valid")
  @ParameterizedTest
  @CsvSource({
      "(),true",
      "()[]{},true",
      "(],false",
      "{,false",
      "],false",
      "(((,false",
      "}}},false",
      "[()]{}{[()()]()},true",
      "[(]),false"
  })
  void isValid(String input, boolean expected) {
    assertEquals(expected, solution.isValid(input));
  }
}