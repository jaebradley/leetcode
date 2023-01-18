package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/
 *
 * * algorithms
 * * Medium (48.15%)
 * * Total Accepted:    250.1K
 * * Total Submissions: 516.1K
 * * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(permutations, new ArrayList<>(), nums);
        return permutations;
    }

    /**
     * Approach is to build up all permutations one element at a time, by calling backtrack recursively if temporary
     * permutation is not at length of distinct numbers.
     *
     * Once backtracking using one element has completed, remove that element from the list of temporary permutations and
     * add the next element in the list of inputted distinct numbers.
     */

    private static void backtrack(List<List<Integer>> permutations, List<Integer> temporaryPermutations, int[] nums) {
        if (temporaryPermutations.size() == nums.length) {
            permutations.add(new ArrayList<>(temporaryPermutations));
        } else {
            for (int num : nums) {
                if (!temporaryPermutations.contains(num)) {
                    temporaryPermutations.add(num);
                    backtrack(permutations, temporaryPermutations, nums);
                    temporaryPermutations.remove(temporaryPermutations.size() - 1);
                }
            }
        }
    }
}
