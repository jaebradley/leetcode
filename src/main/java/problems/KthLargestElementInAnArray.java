package problems;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/

 * algorithms
 * Medium (40.52%)
 * Total Accepted:    206.7K
 * Total Submissions: 507.9K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'

 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.

 Credits:
 Special thanks to @mithmatt for adding this problem and creating all test cases.
 */

public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        return nums[partition(nums, 0, nums.length - 1, nums.length - k + 1)];
    }

    private static int partition(int[] nums, int startIndex, int endIndex, int k) {
        int lo = startIndex;
        int hi = endIndex;
        int pivot = nums[endIndex];

        while (lo < hi) {
            if (nums[lo++] > pivot) {
                swap(nums, --lo, --hi);
            }
        }

        swap(nums, lo, endIndex);

        int numbersGTELo = lo - startIndex + 1;

        if (k == numbersGTELo) {
            return lo;
        }

        if (k < numbersGTELo) {
            return partition(nums, startIndex, lo - 1, k);
        }

        return partition(nums, lo + 1, endIndex, k - numbersGTELo);
    }

    private static void swap(int[] nums, int firstIndex, int secondIndex) {
        int firstValue = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = firstValue;
    }
}
