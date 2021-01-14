package problems;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * Follow up: Could you implement the O(n) solution?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 * <p>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * Approach:
 * <p>
 * 1. Put all values in a Set (O(n))
 * 2. Iterate through the numbers until find potential "start" of a streak (i.e. no value is contained in the set of values
 * before the current value)
 * 4. From this streak start value onwards, check to see if the next value is in the Set - if it is, continue counting the
 * streak - if it isn't, record the length of the streak and update the max streak length
 */

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        final Set<Integer> values = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxCount = 0;

        for (final int currentValue : nums) {
            if (!values.contains(currentValue - 1)) {
                int nextStreakValue = currentValue;
                while (values.contains(nextStreakValue + 1)) {
                    nextStreakValue += 1;
                }
                maxCount = Math.max(maxCount, nextStreakValue - currentValue + 1);
            }
        }

        return maxCount;
    }
}
