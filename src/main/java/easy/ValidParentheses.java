package easy;

import java.util.Stack;
import topics.TStack;
import topics.TString;

/**
 * <h1>20. Valid Parentheses</h1>
 * <p>Given a string <code>s</code> containing just the characters <code>'(', ')', '{', '}', '['
 * and ']'</code>, determine if the input string is valid.</p>
 * <p>An input string is valid if:</p>
 * <ol>
 *   <li>Open brackets must be closed by the same type of brackets.</li>
 *   <li>Open brackets must be closed in the correct order.</li>
 * </ol>
 * <h2>Example 1:</h2>
 * <pre>
 * <strong>Input:</strong> s = "()"
 * <strong>Output:</strong> true
 * </pre>
 * <h2>Example 2:</h2>
 * <pre>
 * <strong>Input:</strong> "()[]{}"
 * <strong>Output:</strong> true
 * </pre>
 * <h2>Example 3:</h2>
 * <pre>
 * <strong>Input:</strong> s = "(]"
 * <strong>Output:</strong> false
 * </pre>
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>1 <= s.length <= 10<sup>4</sup></code></li>
 *   <li><code>s</code> consists of parentheses only <code>'()[]{}'</code></li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/valid-parentheses/">on leetcode</a>
 */
@TString
@TStack
public class ValidParentheses {

  static final char OPEN_PAREN = '(';
  static final char CLOSE_PAREN = ')';
  static final char OPEN_BRACKET = '[';
  static final char CLOSE_BRACKET = ']';
  static final char OPEN_BRACE = '{';
  static final char CLOSE_BRACE = '}';

  public boolean isValid(String s) {
    final int length = s.length();
    if (1 > length || length > (10000)) {
      return false;
    }

    final Stack<Character> stack = new Stack<>();
    char current;
    char fromStack;
    for (int i = 0; i < length; i++) {
      current = s.charAt(i);

      switch (current) {
        case OPEN_PAREN, OPEN_BRACKET, OPEN_BRACE -> stack.push(current);
        case CLOSE_PAREN, CLOSE_BRACKET, CLOSE_BRACE -> {
          if (stack.empty()) {
            return false;
          }
          fromStack = stack.pop();
          if (current == CLOSE_PAREN && fromStack != OPEN_PAREN) {
            return false;
          }
          if (current == CLOSE_BRACKET && fromStack != OPEN_BRACKET) {
            return false;
          }
          if (current == CLOSE_BRACE && fromStack != OPEN_BRACE) {
            return false;
          }
        }
      }
    }

    return stack.empty();
  }
}
