package problems;

import java.util.*;

/**
 * https://leetcode.com/problems/happy-number/description/
 *
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number
 * by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or
 * it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 */

public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> sums = new HashSet<>();
        List<Integer> digits = getDigits(n);
        int sum = sumSquares(digits);

        while (!sums.contains(sum) && sum > 1) {
            sums.add(sum);
            sum = sumSquares(getDigits(sum));
        }

        return sum == 1;
    }

    private static int sumSquares(List<Integer> values) {
        int sum = 0;
        for (Integer value : values) {
            if (value != null) {
                sum += value * value;
            }
        }
        return sum;
    }

    private static List<Integer> getDigits(int number) {
        int temp = number;
        Stack<Integer> digits = new Stack<>();

        while (temp > 0) {
            int remainder = temp % 10;
            digits.add(remainder);
            temp /= 10;
        }

        return new ArrayList<>(digits);
    }
}
