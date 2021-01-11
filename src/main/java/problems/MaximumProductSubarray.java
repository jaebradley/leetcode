package problems;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Approach:
 *
 * 1. Keep track of two values - the maximum product seen that is a combination of contiguous indices prior to the current index
 *    * Keep track of the minimum product that is a combination of contiguous indices prior to current index
 * 2. If current value is less than zero, swap the max and minimum values
 * 3. Calculate the maximum / minimum products using the current value - or use current value, if it is larger / smaller
 * 4. If maximum product is greater than the maximum seen so far, replace it
 */

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int maximumProduct = nums[0];
        int minimumProduct = nums[0];

        for (int currentIndex = 1; currentIndex < nums.length; currentIndex++) {
            final int currentValue = nums[currentIndex];
            if (0 > currentValue) {
                int currentMaximumProduct = maximumProduct;
                maximumProduct = minimumProduct;
                minimumProduct = currentMaximumProduct;
            }

            maximumProduct = Math.max(maximumProduct * currentValue, currentValue);
            minimumProduct = Math.min(minimumProduct * currentValue, currentValue);

            result = Math.max(result, maximumProduct);
        }

        return result;
    }
}
