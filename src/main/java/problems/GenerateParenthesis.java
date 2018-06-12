package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * * algorithms
 * * Medium (48.69%)
 * * Total Accepted:    217.6K
 * * Total Submissions: 447K
 * * Testcase Example:  '3'
 *
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * For example, given n = 3, a solution set is:
 *
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();

        handleOpenClosedParentheses(n, n, "", results);

        return results;
    }

    private static void handleOpenClosedParentheses(int openParenthesesCount, int closedParenthesesCount, String result, List<String> results) {
        if (openParenthesesCount > 0) {
            handleOpenClosedParentheses(openParenthesesCount - 1, closedParenthesesCount, result + "(", results);

        }

        if (openParenthesesCount < closedParenthesesCount) {
            handleOpenClosedParentheses(openParenthesesCount, closedParenthesesCount - 1, result + ")", results);
        }

        if (openParenthesesCount == 0 && openParenthesesCount == closedParenthesesCount) {
            results.add(result);
        }
    }
}
