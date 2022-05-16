package medium;

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

  public String intToRoman(int num) {
    if (num < 0 || num > 3999) {
      return "";
    }

    final StringBuilder result = new StringBuilder();
    final int[] nums = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    for (int i = nums.length - 1; i >= 0; i--) {
      int current = nums[i];
      while (num >= current) {
        result.append(switch (current) {
          case 1000 -> "M";
          case 900 -> "CM";
          case 500 -> "D";
          case 400 -> "CD";
          case 100 -> "C";
          case 90 -> "XC";
          case 50 -> "L";
          case 40 -> "XL";
          case 10 -> "X";
          case 9 -> "IX";
          case 5 -> "V";
          case 4 -> "IV";
          case 1 -> "I";
          default -> 0;
        });
        num -= current;
      }
    }

    return result.toString();
  }
}
