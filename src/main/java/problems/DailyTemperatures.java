package problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 *
 * Approach:
 *
 * 1. Use a stack - idea is to put temperatures on the stack (along with the temperatures index) if the current temperature
 *    is less than the top element in the stack.
 * 2. If the top element in the stack has a lower temperature than the current temperature, then pop the top element,
 *    and at the top element's index, write the difference between that element's index and the current temperature's
 *    index - this represents the number of days to wait until there's a warmer temperature
 * 3. If the current temperature is not warmer than the top element push it to the stack.
 */

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] daysUntilWarmerTemperature = new int[T.length];

        Stack<Integer> seenTemperatures = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (!seenTemperatures.isEmpty()) {
                while (!seenTemperatures.isEmpty() && T[i] > T[seenTemperatures.peek()]) {
                    int lastSeenTemperatureIndex = seenTemperatures.pop();
                    daysUntilWarmerTemperature[lastSeenTemperatureIndex] = i - lastSeenTemperatureIndex;
                }
            }
            seenTemperatures.push(i);
        }

        return daysUntilWarmerTemperature;
    }
}
