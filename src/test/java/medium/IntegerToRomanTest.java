package medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class IntegerToRomanTest {

  private final IntegerToRoman integerToRoman = new IntegerToRoman();

  @DisplayName("Should convert given integer to valid roman representation in range (1, 3999)")
  @ParameterizedTest(name = "{index}. intToRoman({0}) => \"{1}\"")
  @CsvSource({
      "0,''",
      "-1,''",
      "3,III",
      "10,X",
      "20,XX",
      "40,XL",
      "50,L",
      "100,C",
      "500,D",
      "1000,M",
      "58,LVIII",
      "504,DIV",
      "1994,MCMXCIV",
      "3999,MMMCMXCIX",
      "2314,MMCCCXIV",
      "4123,''"
  })
  void intToRoman(int input, String expected) {
    assertEquals(expected, integerToRoman.intToRoman(input));
  }
}