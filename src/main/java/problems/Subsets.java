package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/

 * algorithms
 * Medium (44.57%)
 * Total Accepted:    231.2K
 * Total Submissions: 515.5K
 * Testcase Example:  '[1,2,3]'


 Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.


 For example,
 If nums = [1,2,3], a solution is:



 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> values = new ArrayList<>();

        helper(values, new ArrayList<>(), nums, 0);

        return values;
    }

    private static void helper(List<List<Integer>> values, List<Integer> previousLevelValues, int[] numbers, int startIndex) {
        values.add(new ArrayList<>(previousLevelValues));

        for (int index = startIndex; index < numbers.length; index++) {
            previousLevelValues.add(numbers[index]);
            helper(values, previousLevelValues, numbers, index + 1);
            previousLevelValues.remove(previousLevelValues.size() - 1);
        }
    }
}
