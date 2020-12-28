package problems;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up:
 *
 * Could you come up with the O(n2) solution?
 * Could you improve it to O(n log(n)) time complexity?
 *
 * Approach:
 *
 * 1. Keep track of longest subsequence length in an array where the kth index in the array represents the LIS length at
 *    that index value.
 * 2. Iterate through all values
 *    * Iterate through previous values
 *    * If the current value is greater than a previous value
 *      * The current LIS length is the previous value's LIS length + 1
 *    * If the current value's LIS length is greater than the max LIS length seen, update the max LIS length
 * 3. Return the max LIS length seen
 */

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int maximumLISLength = 0;
        final int[] subsequenceLengths = new int[nums.length];

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            subsequenceLengths[currentIndex] = 1;
            final int currentValue = nums[currentIndex];

            for (int previousIndex = 0; previousIndex < currentIndex; previousIndex++) {
                final int previousValue = nums[previousIndex];

                if (previousValue < currentValue && subsequenceLengths[previousIndex] >= subsequenceLengths[currentIndex]) {
                    subsequenceLengths[currentIndex] = subsequenceLengths[previousIndex] + 1;
                }
            }

            maximumLISLength = Math.max(maximumLISLength, subsequenceLengths[currentIndex]);
        }

        return maximumLISLength;
    }
}
