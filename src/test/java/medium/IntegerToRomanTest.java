package medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
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

  @DisplayName("How many thousands/hundreds/dozens current integer holds")
  @ParameterizedTest(name = "{index}. int {0} contains {1} {2}s")
  @CsvSource({
      "0,0,1000",
      "0,0,100",
      "0,0,10",
      "3,0,1000",
      "3,0,100",
      "3,0,10",
      "58,0,1000",
      "58,0,100",
      "58,5,10",
      "20,0,100",
      "20,2,10",
      "504,0,1000",
      "504,5,100",
      "1000,1,1000",
      "1994,1,1000",
      "994,9,100",
      "94,9,10",
      "3999,3,1000",
      "999,9,100",
      "99,9,10",
  })
  void howMany(int num, int expected, int what) {
    assertEquals(expected, IntegerToRoman.howMany(num, what));
  }


  @DisplayName("Represent given hundreds/dozens/digits in roman")
  @ParameterizedTest(name = "{index}. {0} before {1} is {2}")
  @CsvSource({
      "4,1000,CD",
      "5,100,L",
      "7,10,VII",
      "2,100,XX",
      "3,100,XXX"
  })
  void toRoman(int numberOf, int firstNumberWithPlusOneDigit, String expected) {
    assertEquals(expected,
        IntegerToRoman.toRoman(numberOf, firstNumberWithPlusOneDigit).stream().map(String::valueOf)
            .collect(Collectors.joining("")));
  }
}