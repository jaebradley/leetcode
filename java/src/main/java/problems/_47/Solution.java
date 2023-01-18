package problems._47;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations-ii/
 * <p>
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * Example 2:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        if (0 < nums.length) {
            permute(0, nums, result);
        }
        return result;
    }

    private static void permute(int currentIndex, int[] nums, List<List<Integer>> result) {
        if (currentIndex == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        final Set<Integer> seen = new HashSet<>();
        for (int index = currentIndex; index < nums.length; index += 1) {
            if (seen.add(nums[index])) {
                swap(nums, index, currentIndex);
                permute(currentIndex + 1, nums, result);
                swap(nums, index, currentIndex);
            }
        }
    }

    private static void swap(int[] nums, int currentIndex, int nextIndex) {
        final int currentValue = nums[currentIndex];
        nums[currentIndex] = nums[nextIndex];
        nums[nextIndex] = currentValue;
    }
}
