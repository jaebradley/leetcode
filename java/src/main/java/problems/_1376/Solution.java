package problems._1376;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 * <p>
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.
 * <p>
 * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.
 * <p>
 * The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.
 * <p>
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).
 * <p>
 * Return the number of minutes needed to inform all the employees about the urgent news.
 * <p>
 * Approach:
 * If current node is non-null, add current path sum and current node inform time
 * This newly calculated value is the path sum for all of the direct subordinates of the current node
 * Add newly calculated value to sum value
 * Call all direct subordinates recursively
 * Iterate over manager array to build Map of manager to direct subordinates
 */

public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        final Map<Integer, Set<Integer>> subordinatesByManager = IntStream.range(0, manager.length)
                .boxed()
                .map(index -> Map.entry(manager[index], index))
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue, Collectors.toSet()))
                );
        return helper(headID, informTime, subordinatesByManager);
    }

    private static int helper(final int currentManager,
                              final int[] informTime,
                              final Map<Integer, Set<Integer>> subordinatesByManager) {
        return subordinatesByManager.getOrDefault(currentManager, Collections.emptySet())
                .stream()
                .map(subordinate -> helper(subordinate, informTime, subordinatesByManager))
                .max(Integer::compare)
                .orElse(0)
                + informTime[currentManager];
    }
}
