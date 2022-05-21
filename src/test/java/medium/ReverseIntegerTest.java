package medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReverseIntegerTest {

  private final ReverseInteger solution = new ReverseInteger();

  @DisplayName("Given a signed 32-bit integer, then should return it with digits reversed, or "
      + "zero if value goes outside the signed 32-bit integer")
  @ParameterizedTest
  @CsvSource({
      "0,0",
      "123,321",
      "-123,-321",
      "120,21",
      "1989,9891",
      "147483647,746384741",
      "-2147483648,0",
      "2100000000,12",
      "2147483647,0",
      "2147447412,2147447412",
      "2147447422,0"
  })
  void reverse(int input, int expected) {
    assertEquals(expected, solution.reverse(input));
  }
}