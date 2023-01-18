package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */

public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> closedParentheses = new Stack<>();
        Map<Character, Character> matchingParentheses = new HashMap<>();
        matchingParentheses.put('(', ')');
        matchingParentheses.put('{', '}');
        matchingParentheses.put('[', ']');

        for (char c : s.toCharArray()) {
            if (matchingParentheses.containsKey(c)) {
                closedParentheses.push(c);
            } else {
                if (closedParentheses.empty()) {
                    return false;
                }

                Character lastClosedParenthesis = closedParentheses.pop();
                Character matchingParenthesis = matchingParentheses.get(lastClosedParenthesis);
                if (c != matchingParenthesis) {
                    return false;
                }
            }
        }

        return closedParentheses.empty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> openParentheses = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    openParentheses.push(')');
                    break;
                case '{':
                    openParentheses.push('}');
                    break;
                case '[':
                    openParentheses.push(']');
                    break;
                default:
                    if (openParentheses.empty() || c != openParentheses.peek()) {
                        return false;
                    }

                    openParentheses.pop();
                    break;
            }
        }
        return openParentheses.empty();
    }
}
