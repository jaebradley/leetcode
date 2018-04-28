package problems;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/

 * algorithms
 * Easy (32.13%)
 * Total Accepted:    233.2K
 * Total Submissions: 724.8K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'

 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:


 The number of elements initialized in nums1 and nums2 are m and n respectively.
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.


 Example:


 Input:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 Output: [1,2,2,3,5,6]
 */

public class MergeSortedArrays {
    /**
     * Iterate through first and second array starting at ends
     * Whichever value is bigger, add at end of first array
     * If can still iterate through second array, this means that first array was completely moved but second array still has values to process
     * Since second array values need to be added they can just be inserted in first array at the remaining indices (decrementing each step, of course)
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int insertIndex = m + n - 1;

        while (nums1Index >= 0 && nums2Index >= 0) {
            int num1 = nums1[nums1Index];
            int num2 = nums2[nums2Index];

            if (num1 > num2) {
                nums1[insertIndex] = num1;
                nums1Index--;
            } else {
                nums1[insertIndex] = num2;
                nums2Index--;
            }

            insertIndex--;
        }

        while (insertIndex >= 0 && nums2Index >= 0) {
            nums1[insertIndex] = nums2[nums2Index];
            insertIndex--;
            nums2Index--;
        }
    }
}
