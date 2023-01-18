package problems;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * * algorithms
 * * Medium (31.95%)
 * * Total Accepted:    267.5K
 * * Total Submissions: 837K
 * * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */

public class SearchRotatedArray {

    /**
     * The idea is that if the target is within the range of the left subsection (i.e. low value is left of the middle
     * value, target is less than the middle value and target is greater than or equal than the low value)
     * then use the left subsection (else use the right subsection).
     *
     * To validate if the left or right subsections are valid, check that the low value is less than or equal to the
     * middle value or the middle value is less than or equal to the high value. For a rotated ordered array, at least
     * one of these should be true.
     */

    public static int search(int[] nums, int target) {
        int lowIndex = 0;
        int highIndex = nums.length - 1;

        while (lowIndex <= highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;
            int middleValue = nums[middleIndex];

            if (target == middleValue) {
                return middleIndex;
            }

            int lowValue = nums[lowIndex];
            int highValue = nums[highIndex];

            if (lowValue <= middleValue) {
                if (target < middleValue && target >= lowValue) {
                    highIndex = middleIndex - 1;
                } else {
                    lowIndex = middleIndex + 1;
                }
            }

            if (middleValue <= highValue) {
                if (target > middleValue && target <= highValue) {
                    lowIndex = middleIndex + 1;
                } else {
                    highIndex = middleIndex - 1;
                }
            }
        }
        return -1;
    }
}
