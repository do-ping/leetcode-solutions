package easy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class FizzBuzzTest {

  private static class Args implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
      return Stream.of(
          arguments(1, List.of("1")),
          arguments(3, List.of("1", "2", "Fizz")),
          arguments(5, List.of("1", "2", "Fizz", "4", "Buzz")),
          arguments(15, List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz",
              "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"))
      );
    }
  }

  private final FizzBuzz solution = new FizzBuzz();

  @DisplayName("Given integer n, should return string array with 3 5 and 15 replaced with "
      + "\"Fizz\", \"Buzz\" and \"FizzBuzz\" respectively, and other digits as strings")
  @ParameterizedTest(name = "{index}. n={0} array={1}")
  @ArgumentsSource(value = Args.class)
  void fizzBuzz(int n, List<String> expected) {
    assertEquals(expected, solution.fizzBuzz(n));
  }
}