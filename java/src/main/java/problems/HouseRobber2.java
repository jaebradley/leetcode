package problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber-ii/
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * Approach:
 * <p>
 * 1. Can think about the problem as calculating the max robbing value from houses 0 to n-1 and max robbing value from
 * 1 to n, and then select the max of the two values.
 * 2. For any given house, there is the decision to rob (if did not rob the previous house), or not to rob.
 * 3. Keep track of two values - if the previous has been robbed or not.
 * 4. Iterate through the house values - take the previously has not been robbed value and add the current house value to it
 * 5. The resultant sum is the new previously has been robbed value.
 * 6. The next previously has not been robbed value is the maximum of the previously has not been robbed value and the
 * previously has been robbed value (since it is now 1 house removed from the current house that is being robbed)
 */

public class HouseRobber2 {
    public int rob(int[] nums) {
        if (0 == nums.length) {
            return 0;
        }

        if (1 == nums.length) {
            return nums[0];
        }

        return Math.max(
                robHouses(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                robHouses(Arrays.copyOfRange(nums, 1, nums.length))
        );
    }

    private int robHouses(final int[] houseValues) {
        int hasPreviouslyNotRobbed = 0;
        int hasPreviouslyRobbed = 0;

        for (final int value : houseValues) {
            final int robCurrentHouseValue = hasPreviouslyNotRobbed + value;
            hasPreviouslyNotRobbed = Math.max(hasPreviouslyNotRobbed, hasPreviouslyRobbed);
            hasPreviouslyRobbed = robCurrentHouseValue;
        }

        return Math.max(hasPreviouslyNotRobbed, hasPreviouslyRobbed);
    }
}
