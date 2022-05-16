package easy;

import topics.THashTable;
import topics.TString;

/**
 * <h1>383. Ransom Note</h1>
 * <p> Given two strings <code>ransomNote</code> and <code>magazine</code>, return
 * <code>true</code> <i>if <code>ransomNote</code> can be constructed from <code>magazine</code>
 * and <code>false</code> otherwise.</i></p>
 * <p>Each letter in <code>magazine</code> can only be used once in <code>ransomNote</code>.</p>
 *
 * <h3>Example 1:</h3>
 * <pre>
 *  <b>Input:</b> ransomNode = "a", magazine = "b"
 *  <b>Output:</b> false
 * </pre>
 * <h2>Example 2:</h2>
 * <pre>
 *  <b>Input:</b> ransomNode = "aa", magazine = "ab"
 *  <b>Output:</b> false
 * </pre>
 * <h2>Example 2:</h2>
 * <pre>
 *  <b>Input:</b> ransomNode = "aa", magazine = "aab"
 *  <b>Output:</b> true
 * </pre>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>1 <= ransomNote.length, magazine.length <= 10^5</code></li>
 *   <li><code>ransomNote</code> and <code>magazine</code> consists of lowercase English
 *   letters</li>
 * </ul>
 * <h4>Related topics:</h4>
 * <ul>
 *   <li>Hash Table</li>
 *   <li>String</li>
 *   <li>Counting</li>
 * </ul>
 */
@THashTable
@TString
public class RansomNote {

  public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote.isEmpty() || magazine.isEmpty()) {
      return false;
    }
    if (ransomNote.length() > magazine.length()) {
      return false;
    }
    if (ransomNote.length() == 1 && magazine.length() == 1) {
      return ransomNote.charAt(0) == magazine.charAt(0);
    }
    if (ransomNote.length() == 1) {
      return magazine.contains(ransomNote);
    }

    int[] chars = new int[26];
    for (int i = 0; i < ransomNote.length(); i++) {
      ++chars[ransomNote.charAt(i) - 97];
    }

    for (int i = 0; i < magazine.length(); i++) {
      --chars[magazine.charAt(i) - 97];
    }

    for (int i : chars) {
      if (i > 0) {
        return false;
      }
    }

    return true;
  }
}
