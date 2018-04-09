package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * https://leetcode.com/problems/subarray-sum-equals-k/solution/

 * algorithms
 * Medium (40.07%)
 * Total Accepted:    32.3K
 * Total Submissions: 80.7K
 * Testcase Example:  '[1,1,1]\n2'

 Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

 Example 1:

 Input:nums = [1,1,1], k = 2
 Output: 2



 Note:

 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCounts = new HashMap<>();

        sumCounts.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            Integer sumMinusKCount = sumCounts.get(sum - k);

            if (sumMinusKCount != null) {
                count += sumMinusKCount;
            }

            sumCounts.merge(sum, 1, (a, b) -> a + b);
        }

        return count;
    }
}
