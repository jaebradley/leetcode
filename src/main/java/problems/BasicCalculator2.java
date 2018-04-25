package problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/description/

 * algorithms
 * Medium (30.05%)
 * Total Accepted:    65.1K
 * Total Submissions: 215.9K
 * Testcase Example:  '"3+2*2"'

 Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces  . The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:

 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5




 Note: Do not use the eval built-in library function.


 Credits:Special thanks to @ts for adding this problem and creating all test cases.
 */

public class BasicCalculator2 {
    /**
     * The thing that wasn't obvious to me was using operator to track the "last" operation (at the start, this should
     * be the operation where you add the current number to the stack, so +).
     *
     * Thus, when a non-digit character comes along, it's the new operator, and you actually apply that operation after
     * the NEXT non-digit character is seen.
     *
     * This way, you capture the entire number that the operator should be applied to.
     */
    public static int calculate(String s) {
        Stack<Integer> digits = new Stack<>();
        char[] chars = s.toCharArray();
        int currentNumber = 0;
        char operator = '+';

        for (int index = 0; index < chars.length; index++) {
            char currentChar = chars[index];
            if (Character.isDigit(currentChar)) {
                currentNumber = 10 * currentNumber + currentChar - '0';
            }

            if ((!Character.isDigit(currentChar) && currentChar != ' ') || index == chars.length - 1) {
                switch (operator) {
                    case '*': {
                        digits.push(digits.pop() * currentNumber);
                        break;
                    }

                    case '/': {
                        digits.push(digits.pop() / currentNumber);
                        break;
                    }

                    case '-': {
                        digits.push(-currentNumber);
                        break;
                    }

                    case '+': {
                        digits.push(currentNumber);
                        break;
                    }

                    default:
                        break;
                }

                operator = currentChar;
                currentNumber = 0;
            }

        }

        int value = 0;
        for (Integer digit : digits) {
            value += digit;
        }

        return value;
    }
}
