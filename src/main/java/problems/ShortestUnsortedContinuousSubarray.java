package problems;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/

 * algorithms
 * Easy (29.14%)
 * Total Accepted:    31.9K
 * Total Submissions: 109.7K
 * Testcase Example:  '[2,6,4,8,10,9,15]'

 Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:

 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.



 Note:

 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means >=.
 */

public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int startIndex = -1;
        int endIndex = -2;
        int minimumValue = nums[length - 1];
        int maximumValue = nums[0];

        for (int i = 1; i < length; i++) {
            maximumValue = Math.max(maximumValue, nums[i]);
            minimumValue = Math.min(minimumValue, nums[length - 1 - i]);

            if (nums[i] < maximumValue) {
                endIndex = i;
            }

            if (nums[length - 1 - i] > minimumValue) {
                startIndex = length - 1 - i;
            }
        }

        return endIndex - startIndex + 1;
    }
}
