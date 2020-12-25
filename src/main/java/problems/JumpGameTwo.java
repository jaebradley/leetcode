package problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 *
 * Approach:
 *
 * 1. Put all possible jumps from the initial value in a queue
 * 2. Keep track of visited indices
 * 3. For each element in the queue, add all the potential next jumps in the queue - for each potential next jump, keep
 *    track of the position of the result of the jump and the number of steps that jump would be from the start
 * 4. If an element in the queue has been visited before don't process it
 * 5. If an element in the queue has a position that is equal to the length of the input array (minus one) return the
 *    step count associated with the "pair" of data that represents each element in the queue
 * 6. The idea is that if visiting index X, that indices X-1 to 0 should have been visited.
 *    So no need to visit or even consider any of the previous indices.
 * 7. Since each index should be visited once, this algorithm should be O(n)
 */

public class JumpGameTwo {
    private static class Pair {
        private final int position;
        private final int stepCount;

        public Pair(final int position, final int stepCount) {
            this.position = position;
            this.stepCount = stepCount;
        }

        public int getPosition() {
            return position;
        }

        public int getStepCount() {
            return stepCount;
        }
    }

    public int jump(int[] nums) {
        Queue<Pair> indicesToVisit = new LinkedList<>();
        indicesToVisit.add(new Pair(0, 0));
        int maxPositionIndex = 0;

        while (!indicesToVisit.isEmpty()) {
            final Pair value = indicesToVisit.poll();
            if (value.getPosition() == nums.length - 1) {
                return value.getStepCount();
            }
            final int maximumNextIndex = Math.min(nums.length - 1, value.getPosition() + nums[value.getPosition()]);
            for (int nextPositionIndex = maxPositionIndex + 1; nextPositionIndex <= maximumNextIndex; nextPositionIndex++) {
                indicesToVisit.add(new Pair(nextPositionIndex, value.getStepCount() + 1));
                maxPositionIndex = Math.max(maxPositionIndex, nextPositionIndex);
            }
        }

        throw new RuntimeException("unexpected");
    }
}
