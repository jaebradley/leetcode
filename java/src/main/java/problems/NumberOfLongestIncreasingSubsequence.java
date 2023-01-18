package problems;

/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 *
 * Given an integer array nums, return the number of longest increasing subsequences.
 *
 * Notice that the sequence has to be strictly increasing.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2000
 * -106 <= nums[i] <= 106
 *
 * Approach:
 *
 * 1. Two arrays to keep track of - lengths and counts. The value at index i of each indicate the length of the longest
 *    increasing subsequence at index i and the counts of the longest increasing subsequence at index i, respectively.
 * 2. For each element in the input array, the initial length value at that index is 1. Then iterate through each
 *    previous value.
 *      * if the previous value is less than the current value
 *      * and if the length of LIS at the previous index is equal to the current value's length - 1, then add the count
 *        at that value to the count for the current index, but no need to adjust the length value, as the "new" length
 *        value would simply be the previous length + 1 (which is what the current length value anyways)
 *      * if the length of LIS at the previous index is greater than or equal to the current value's length, then the
 *        current value's length is length at previous index + 1, and the count is the count at the previous index,
 *        as the LISes that include the previous index will now include the current index
 * 3. If the length of the current index after processing previous indices is greater than the current max length, update
 *    the count to point to the current index value and update the current max length
 *      * If the current max length is equal to the length value at the current index, add the count to the current count
 */

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int lisCount = 0;
        int lisLength = 0;
        final int[] subsequenceLengths = new int[nums.length];
        final int[] subsequenceCounts = new int[nums.length];

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            subsequenceLengths[currentIndex] = 1;
            subsequenceCounts[currentIndex] = 1;

            final int currentValue = nums[currentIndex];

            for (int previousIndex = 0; previousIndex < currentIndex; previousIndex++) {
                final int previousValue = nums[previousIndex];

                if (previousValue < currentValue) {
                    final int currentIndexLength = subsequenceLengths[currentIndex];
                    final int previousIndexLength = subsequenceLengths[previousIndex];

                    if (currentIndexLength - 1 == previousIndexLength) {
                        subsequenceCounts[currentIndex] += subsequenceCounts[previousIndex];
                    } else if (currentIndexLength <= previousIndexLength) {
                        subsequenceLengths[currentIndex] = previousIndexLength + 1;
                        subsequenceCounts[currentIndex] = subsequenceCounts[previousIndex];
                    }
                }
            }

            if (lisLength < subsequenceLengths[currentIndex]) {
                lisLength = subsequenceLengths[currentIndex];
                lisCount = subsequenceCounts[currentIndex];
            } else if (lisLength == subsequenceLengths[currentIndex]) {
                lisCount += subsequenceCounts[currentIndex];
            }
        }

        return lisCount;
    }
}
