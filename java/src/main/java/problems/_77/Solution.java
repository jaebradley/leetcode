package problems._77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/combinations/
 *
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> result = new ArrayList<>();
        choose(new LinkedList<>(), result,  1,  n, k);
        return result;
    }

    private static void choose(final LinkedList<Integer> combination, final List<List<Integer>> result, final int startingValue, final int maximumValue, final int targetSize) {
        if (0 == targetSize) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int currentValue = startingValue; currentValue <= maximumValue; currentValue += 1) {
            combination.addLast(currentValue);
            choose(combination, result, currentValue + 1, maximumValue, targetSize - 1);
            combination.removeLast();
        }
    }
}
