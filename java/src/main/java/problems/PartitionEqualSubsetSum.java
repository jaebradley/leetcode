package problems;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/description/

 * algorithms
 * Medium (38.87%)
 * Total Accepted:    41.3K
 * Total Submissions: 106.2K
 * Testcase Example:  '[1,5,11,5]'

 Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.


 Note:

 Each of the array element will not exceed 100.
 The array size will not exceed 200.



 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].



 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.
 */

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[] subSums = new boolean[target + 1];

        subSums[0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                subSums[j] = subSums[j] || subSums[j - nums[i - 1]];
            }
        }

        return subSums[target];
    }
}
