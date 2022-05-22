package medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringToIntegerATOITest {

  private final StringToIntegerATOI solution = new StringToIntegerATOI();

  @DisplayName("Given string, should parse integer from it")
  @ParameterizedTest(name = "{index}. input={0} result={1}")
  @CsvSource({
      "'',0",
      "' ',0",
      "42,42",
      " word +2,0",
      "+321,321",
      " -2 stop2,-2",
      "   -42,-42",
      "4193 with words,4193",
      "2147483648,2147483647",
      "-2147483649,-2147483648",
      "-91283472332,-2147483648",
      "+-12,0"
  })
  void myAtoi(String input, int expected) {
    assertEquals(expected, solution.myAtoi(input));
  }
}