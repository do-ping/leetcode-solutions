package easy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestCommonPrefixTest {

  private final LongestCommonPrefix solution = new LongestCommonPrefix();

  private static Stream<Arguments> argsSource() {
    return Stream.of(
        arguments(new String[]{"flower", "flow", "flight"}, "fl"),
        arguments(new String[]{"dog", "racecar", "car"}, ""),
        arguments(new String[]{"better", "behave", "best", "bee", "beetroot"}, "be"),
        arguments(new String[0], ""),
        arguments(new String[]{"string"}, "string"),
        arguments(new String[]{"test", "", "tempo"}, ""),
        arguments(new String[]{"", "b"}, ""),
        arguments(new String[]{"test", "test", "test", "testimonial", "testosterone"}, "test")
    );
  }

  @DisplayName("Given array of strings, should return longest common prefix or empty string if "
      + "none exist")
  @ParameterizedTest(name = "{index}. \"{1}\" is longest prefix of {0}")
  @MethodSource("argsSource")
  void longestCommonPrefix(String[] input, String expected) {
    assertEquals(expected, solution.longestCommonPrefix(input));
  }
}