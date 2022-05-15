package easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RomanToIntegerTest {

  private final RomanToInteger romanToInteger = new RomanToInteger();

  @DisplayName("Given roman number, then should convert to integer")
  @ParameterizedTest(name = "{index}. {0}=>{1}")
  @CsvSource({
      ",0",
      "'',0",
      "III,3",
      "LVIII,58",
      "MCMXCIV,1994",
      "DIV,504",
      "MMMCMXCIX,3999"
  })
  void romanToInt(String roman, int expected) {
    int result = romanToInteger.romanToInt(roman);
    assertEquals(expected, result, "Expected: %d, got: %d".formatted(expected, result));
  }
}