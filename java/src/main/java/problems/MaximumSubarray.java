package problems;

/**
 * https://leetcode.com/problems/maximum-subarray/description/

 * algorithms
 * Easy (40.27%)
 * Total Accepted:    301.4K
 * Total Submissions: 747.9K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'


 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.


 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.


 click to show more practice.

 More practice:

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class MaximumSubarray {

    /** To calculate sum(0,i), you have 2 choices: either adding sum(0,i-1) to a[i], or not.
     * If sum(0,i-1) is negative, adding it to a[i] will only make a smaller sum, so we add only if it’s non-negative.
    **/

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int[] previousMaxSubarrays = new int[nums.length + 1];
        previousMaxSubarrays[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentMax = (previousMaxSubarrays[i] > 0 ? previousMaxSubarrays[i] : 0) + nums[i];
            previousMaxSubarrays[i + 1] = currentMax;
            maxSum = Math.max(maxSum, currentMax);
        }

        return maxSum;
    }
}
