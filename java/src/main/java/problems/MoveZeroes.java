package problems;

/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * Approach:
 * 1. Two pointers - 1 pointer starts at the 0th index and the other pointer starts at the 2nd index
 * 2. One pointer is in charge of pointing to the first zero value and one pointer is in charge of pointing to the first non-zero value
 * 3. If the zero value index is less than the non-zero value index, swap indices, and then increment zero value pointer
 *    until it finds it's next index as well as non-zero value pointer.
 * 4. Continue doing this until zero value pointer index is greater than next non-zero value index / next non-zero value index gets to the end
 */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int nonZeroSwapIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value != 0) {
                nums[i] = nums[nonZeroSwapIndex];
                nums[nonZeroSwapIndex] = value;
                nonZeroSwapIndex++;
            }
        }
    }
}
