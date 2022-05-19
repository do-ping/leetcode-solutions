package medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LongestSubstringWithoutRepeatingCharactersTest {

  private final LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

  @DisplayName("Given string (s), should return the length of the longest substring (expected) "
      + "without repeating characters")
  @ParameterizedTest(name = "{index}. string=\"{0}\" length={1}")
  @CsvSource(textBlock = """
      '',0
      a,1
      12,2
      ' ',1
      dvdf,3
      abcabcbb,3
      bbbbb,1
      pwwkew,3
      pwwkewfaop,7
      ckilbkd,5
      p@$$w00rd!  ?,5
      abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*(){}[]_+-\\|/><`~ ?."'stop,91
      abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*(){}[]_+-\\|/><`~ ?."',91
      """)
  void lengthOfLongestSubstring(String s, int expected) {
    assertEquals(expected, solution.lengthOfLongestSubstring(s));
  }
}