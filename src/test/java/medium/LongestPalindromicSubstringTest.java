package medium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LongestPalindromicSubstringTest {

  private final LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

  @DisplayName("Given string (input), then should find the longest palindromic substring")
  @ParameterizedTest(name = "{index}. \"{1}\" is the longest palindrome in \"{0}\"")
  @CsvSource({
      "'','',",
      "a,a,",
      "11,11,",
      "babad,bab,aba",
      "cbbd,bb,",
      "radar,radar,",
      "multiLeveL,LeveL,",
      "StringWithEnglishLettersomoAnd12321Digits,12321,",
      "qwewqqwewqwe,qwewqqwewq,",
      "bananas,anana,",
      "abracadabra,aca,ada",
      "abacaba,abacaba,",
      "NoPalindrome,N,"
  })
  void longestPalindrome(String input, String expected, String expected2) {
    String actual = solution.longestPalindrome(input);
    assertTrue(expected.equals(actual) ||
        (expected2 != null && !expected2.isEmpty() && expected2.equals(actual)), actual);
  }
}