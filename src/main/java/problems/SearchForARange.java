package problems;

/**
 * https://leetcode.com/problems/search-for-a-range/description/
 *
 * * algorithms
 * * Medium (31.71%)
 * * Total Accepted:    196.9K
 * * Total Submissions: 620.9K
 * * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        int matchingIndex = binarySearch(nums, target);
        if (matchingIndex < 0) {
            return new int[]{ -1, -1 };
        }
        int startingIndex = matchingIndex;
        int endingIndex = matchingIndex;
        while (nums[startingIndex - 1] == target) {
            startingIndex--;
        }

        while (nums[endingIndex + 1] == target) {
            endingIndex++;
        }

        return new int[]{ startingIndex, endingIndex };
    }

    /**
     * Mostly copied from http://www.java2novice.com/java-search-algorithms/binary-search/
     *
     * Binary search uses the midpoint between a start and an end index to search a sorted array of values.
     *
     * If the midpoint value is less than the target value, then search the interval between the midpoint index + 1 and the end index.
     * If the midpoint value is greater than the target value, then search the interval between the start index and the midpoint index - 1.
     *
     * If the start and end indices are the same, if the "midpoint" value is not equal to the target value,
     * the while loop will exit as the end index will decrement or the start index will increment.
     */

    private static int binarySearch(int[] values, int target) {
        int startIndex = 0;
        int endIndex = values.length - 1;

        while (startIndex <= endIndex) {
            int midPointIndex = (startIndex + endIndex) / 2;
            int value = values[midPointIndex];

            if (value == target) {
                return midPointIndex;
            } else if (target < value) {
                endIndex = midPointIndex - 1;
            } else {
                startIndex = midPointIndex + 1;
            }
        }

        return -1;
    }
}
