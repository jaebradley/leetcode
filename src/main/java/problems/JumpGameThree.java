package problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/jump-game-iii/
 *
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 * Example 2:
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 * Example 3:
 *
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 *
 * Approach:
 *
 * 1. From start index, push possible indices to queue
 * 2. Pop from queue and push back any possible indices that haven't been visited - keep track of visited indices, and if
 *    the next index is one of the zero indices, return true
 * 3. Else, if the queue is empty, return false
 */

public class JumpGameThree {
    public boolean canReach(int[] arr, int start) {
        Set<Integer> zeroIndices = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroIndices.add(i);
            }
        }

        Set<Integer> visitedIndices = new HashSet<>();
        Queue<Integer> nextIndices = new LinkedList<>();

        nextIndices.add(start);

        while (!nextIndices.isEmpty()) {
            int nextIndex = nextIndices.poll();
            if (zeroIndices.contains(nextIndex)) {
                return true;
            }

            visitedIndices.add(nextIndex);

            int value = arr[nextIndex];
            int nextIncrementedValue = nextIndex + value;
            if (nextIncrementedValue < arr.length && !visitedIndices.contains(nextIncrementedValue)) {
                nextIndices.offer(nextIncrementedValue);
            }

            int nextDecrementedValue = nextIndex - value;
            if (nextDecrementedValue >= 0 && !visitedIndices.contains(nextDecrementedValue)) {
                nextIndices.offer(nextDecrementedValue);
            }
        }

        return false;
    }
}
