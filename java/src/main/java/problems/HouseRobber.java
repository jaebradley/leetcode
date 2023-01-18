package problems;

/**
 * https://leetcode.com/problems/house-robber/description/

 * algorithms
 * Easy (39.93%)
 * Total Accepted:    192.9K
 * Total Submissions: 483.1K
 * Testcase Example:  '[]'

 You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 Credits:Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.
 */

public class HouseRobber {
    public static int rob(int[] nums) {
        int[][] maximumAmounts = new int[nums.length + 1][2];
        maximumAmounts[0][0] = 0;
        maximumAmounts[0][1] = 0;

        for (int i = 0; i < nums.length; i++) {
            maximumAmounts[i + 1][0] = Math.max(maximumAmounts[i][0], maximumAmounts[i][1]);
            maximumAmounts[i + 1][1] = nums[i] + maximumAmounts[i][0];
        }

        return Math.max(maximumAmounts[maximumAmounts.length - 1][0], maximumAmounts[maximumAmounts.length - 1][1]);
    }
}
