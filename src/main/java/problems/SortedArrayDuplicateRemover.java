package problems;

/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */

public class SortedArrayDuplicateRemover {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int lastIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int currentValue = nums[i];
            int nextValue = nums[i + 1];
            if (currentValue != nextValue) {
                lastIndex++;
                nums[lastIndex] = nextValue;
            }
        }
        return lastIndex + 1;
    }
}
