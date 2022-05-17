package easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberOfStepsToReduceNumberToZeroTest {

  private final NumberOfStepsToReduceNumberToZero solution = new NumberOfStepsToReduceNumberToZero();

  @DisplayName("Given number (num), then should return number of steps required to reduce this "
      + "number to zero")
  @ParameterizedTest(name = "{index}. num={0} stepsToZero={1}")
  @CsvSource({
      "14,6",
      "8,4",
      "123,12",
      "0,0",
      "1,1",
      "2,2"
  })
  void numberOfSteps(int num, int expected) {
    assertEquals(expected, solution.numberOfSteps(num));
  }
}