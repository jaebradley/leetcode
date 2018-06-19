package problems;

/**
 * https://leetcode.com/problems/jump-game/description/
 *
 * * algorithms
 * * Medium (29.76%)
 * * Total Accepted:    174K
 * * Total Submissions: 583.9K
 * * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 *
 * Example 2:
 *
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */

public class JumpGame {
    public static boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        boolean[] canReachEndFromIndex = new boolean[nums.length - 1];
        canReachEndFromIndex[canReachEndFromIndex.length - 1] = nums[nums.length - 2] > 0;

        for (int i = nums.length - 3; i >= 0; i--) {
            int maximumJump = nums[i];

            if (i + maximumJump >= nums.length - 1) {
                canReachEndFromIndex[i] = true;
            } else {
                for (int j = 1; j <= maximumJump; j++) {
                    if (canReachEndFromIndex[i + j]) {
                        canReachEndFromIndex[i] = true;
                        break;
                    }
                }
            }
        }

        return canReachEndFromIndex[0];
    }

    public static boolean canJump2(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
