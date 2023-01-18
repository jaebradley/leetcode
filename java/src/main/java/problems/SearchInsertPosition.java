package problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-insert-position/description/

 * algorithms
 * Easy (40.02%)
 * Total Accepted:    247.3K
 * Total Submissions: 617.9K
 * Testcase Example:  '[1,3,5,6]\n5'

 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Example 1:

 Input: [1,3,5,6], 5
 Output: 2



 Example 2:

 Input: [1,3,5,6], 2
 Output: 1



 Example 3:

 Input: [1,3,5,6], 7
 Output: 4



 Example 1:

 Input: [1,3,5,6], 0
 Output: 0
 */

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int lowIndex = 0;
        int highIndex = nums.length - 1;

        while (lowIndex <= highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;
            int middleValue = nums[middleIndex];

            if (target == middleValue) {
                return middleIndex;
            }

            if (target > middleValue) {
                lowIndex = middleIndex + 1;
            } else {
                highIndex = middleIndex - 1;
            }
        }

        return lowIndex;
    }
}
