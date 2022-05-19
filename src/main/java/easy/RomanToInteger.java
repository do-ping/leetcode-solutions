package easy;

import topics.THashTable;
import topics.TMath;
import topics.TString;

/**
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
 */
@THashTable
@TMath
@TString
public class RomanToInteger {

  public int romanToInt(String s) {
    int result = 0;
    if (s == null || s.isBlank() || s.length() < 1 || s.length() > 15) {
      return result;
    }

    int previous = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      int current = switch (s.charAt(i)) {
        case 'I' -> 1;
        case 'V' -> 5;
        case 'X' -> 10;
        case 'L' -> 50;
        case 'C' -> 100;
        case 'D' -> 500;
        case 'M' -> 1000;
        default -> 0;
      };
      result = previous > current ? result - current : result + current;
      previous = current;
    }

    return result;
  }
}
