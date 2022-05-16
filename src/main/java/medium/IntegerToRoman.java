package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import topics.THashTable;
import topics.TMath;
import topics.TString;

/**
 * <h1>12. Integer to Roman</h1>
 * <p>Roman numerals are represented by seven different symbols: <code>I</code>, <code>V</code>,
 * <code>X</code>, <code>L</code>, <code>C</code>, <code>D</code> and <code>M</code>.</p>
 * <p>
 * <pre>
 *   <strong>Symbol</strong>    <strong>Value</strong>
 *   I             1
 *   V             5
 *   X             10
 *   L             50
 *   C             100
 *   D             500
 *   M             1000
 *   </pre>
 * </p>
 * <p>
 * For example, <code>2</code> is written as <code>II</code> in Roman numeral, just two one's added
 * together. <code>12</code> is written as <code>XII</code>, which is simply <code>X + II</code>.
 * The number <code>27</code> is written as <code>XXVII</code>, which is <code>XX + V + II</code>.
 * <br/> Roman numerals are usually written largest to smallest from left to right. However, the
 * numeral for four is not <code>IIII</code>. Instead, the number four is written as
 * <code>IV</code>. Because the one is before the five we subtract it making four. The same
 * principle applies to the number nine, which is written as <code>IX</code>. There are six
 * instances where subtraction is used:
 * <ol>
 *   <li><code>I</code> can be placed before <code>V</code> (5) and <code>X</code> (10) to make
 *   <code>4</code> and <code>9</code>.</li>
 *   <li><code>X</code> can be placed before <code>L</code> (50) and <code>C</code> (100) to
 *   make <code>40</code> and <code>90</code>.</li>
 *   <li><code>C</code> can be placed before <code>D</code> (500) and <code>M</code> (1000) to
 *   make <code>400</code> and <code>900</code>.</li>
 * </ol>
 * </p>
 * <p>Given a roman numeral, convert it to an integer.</p>
 *
 * <h2>Example 1:</h2>
 * <pre>
 *   <strong>Input:</strong> num = 3
 *   <strong>Output:</strong> "III"
 *   <strong>Explanation:</strong> 3 is represented as 3 ones.
 * </pre>
 *
 * <h2>Example 2:</h2>
 * <pre>
 *   <strong>Input:</strong> num = 58
 *   <strong>Output:</strong> "LVIII"
 *   <strong>Explanation:</strong> L = 50, V = 5, III = 3
 * </pre>
 *
 * <h2>Example 3:</h2>
 * <pre>
 *   <strong>Input:</strong> num = 1994
 *   <strong>Output:</strong> "MCMXCIV"
 *   <strong>Explanation:</strong> M = 1000, CM = 900, XC = 90 and IV = 4
 * </pre>
 *
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>1 <= num <= 3999</code></li>
 * </ul>
 *
 * <p><b>Note to self:</b>
 * Runtime: 39 ms, faster than 5.07% of Java online submissions for Integer to Roman.
 * Memory Usage: 51.9 MB, less than 5.28% of Java online submissions for Integer to Roman.</p>
 */
@THashTable
@TMath
@TString
public class IntegerToRoman {

  private static char getRoman(int i) {
    return switch (i) {
      case 1 -> 'I';
      case 5 -> 'V';
      case 10 -> 'X';
      case 50 -> 'L';
      case 100 -> 'C';
      case 500 -> 'D';
      case 1000 -> 'M';
      default -> 0;
    };
  }

  static int howMany(int num, int what) {
    int result = 0;
    if (num < what) {
      return result;
    }

    int i = 0;
    do {
      i += what;
      result++;
    } while (num - i >= what);

    return result;
  }

  static List<Character> toRoman(int numberOf, int firstNumberWithPlusOneDigit) {
    List<Character> result = new ArrayList<>(4);

    if (numberOf == 9) {
      result.add(getRoman(firstNumberWithPlusOneDigit / 10));
      result.add(getRoman(firstNumberWithPlusOneDigit));
    } else if (numberOf < 9 && numberOf >= 5) {
      result.add(getRoman(firstNumberWithPlusOneDigit / 2));
      for (int i = numberOf - 5; i > 0; i--) {
        result.add(getRoman(firstNumberWithPlusOneDigit / 10));
      }
    } else if (numberOf == 4) {
      result.add(getRoman(firstNumberWithPlusOneDigit / 10));
      result.add(getRoman(firstNumberWithPlusOneDigit / 2));
    } else {
      for (int i = numberOf; i > 0; i--) {
        result.add(getRoman(firstNumberWithPlusOneDigit / 10));
      }
    }

    return result;
  }

  public String intToRoman(int num) {
    if (num < 0 || num > 3999) {
      return "";
    }

    int thousands = howMany(num, 1000);
    int hundreds = howMany(num - (thousands * 1000), 100);
    int dozens = howMany(num - (thousands * 1000) - (hundreds * 100), 10);
    int leftover = num - (thousands * 1000) - (hundreds * 100) - (dozens * 10);
    return Stream.of(
        IntStream.range(0, thousands).mapToObj(x -> getRoman(1000)),
        toRoman(hundreds, 1000).stream(),
        toRoman(dozens, 100).stream(),
        toRoman(leftover, 10).stream()
    ).flatMap(s -> s.map(String::valueOf)).collect(Collectors.joining(""));
  }
}
