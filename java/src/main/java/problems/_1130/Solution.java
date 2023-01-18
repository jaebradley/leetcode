package problems._1130;

import java.util.Stack;

public class Solution {
    public int mctFromLeafValues(int[] arr) {
        int result = 0;
        final Stack<Integer> decreasingElementValues = new Stack<>();
        decreasingElementValues.push(Integer.MAX_VALUE);
        for (final int value : arr) {
            while (value > decreasingElementValues.peek() ) {
                result += decreasingElementValues.pop() * Math.min(value, decreasingElementValues.peek());
            }
            decreasingElementValues.push(value);
        }
        while (decreasingElementValues.size() > 2) {
            result += decreasingElementValues.pop() * decreasingElementValues.peek();
        }
        return result;
    }
}
