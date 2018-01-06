package problems;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * O(n) and constant space
 */

public class FindMissingPositiveNumber {
    /**
     * Try to match the numbers in the array up with their respective indices (1 would go in the 0th index, 2 would go in index 1, etc.).
     * If a number doesn't map to an index in the array (it's negative, or it's too big, or it's a duplicate) move it to the end of the array, and shift our max index down
     * Else, if a number does map to an index in the array, we swap the index value with the value at it's index (so swap 2, with the value at the index 2)
     * Only if the value at the current index maps to that index value do we move on (so the first index has to be 1)
     */
    public static int firstMissingPositive(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int indexValue = nums[startIndex] - 1;

            if (startIndex == indexValue) {
                startIndex++;
            } else if (indexValue < 0 || indexValue > endIndex || nums[startIndex] == nums[indexValue]) {
                nums[startIndex] = nums[endIndex];
                endIndex--;
            } else {
                nums[startIndex] = nums[indexValue];
                nums[indexValue] = indexValue + 1;
            }
        }

        return startIndex + 1;
    }
}
