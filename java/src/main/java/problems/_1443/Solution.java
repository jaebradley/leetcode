package problems._1443;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
 * <p>
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.
 * <p>
 * The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.
 * <p>
 * Approach:
 * It costs 2 seconds to get to a node that is an apple.
 * It also costs 2 seconds to get to a node that is connected to a node that is an apple
 * If a path does not contain any apples, don't need to add any seconds
 * Root costs 0 seconds to get to
 * Start at root and iterate over all children
 * For each of those children, iterate over their children, keeping track of which children have been visited
 * If any children indicate a positive time, that means there is an apple in their path, which also means that the current
 * node needs to return the sum of all the children + 2, since need to get to the current node.
 */

public class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        return helper(
                0,
                Arrays.stream(edges)
                        .flatMap(v -> Stream.of(
                                Map.entry(v[0], v[1]),
                                Map.entry(v[1], v[0]))
                        )
                        .collect(
                                Collectors.groupingBy(
                                        Map.Entry::getKey,
                                        Collectors.mapping(Map.Entry::getValue, Collectors.toSet()))
                        ),
                new HashSet<>(),
                hasApple);
    }

    private static int helper(final int currentNode,
                              final Map<Integer, Set<Integer>> childrenByParent,
                              final Set<Integer> visitedNodes,
                              final List<Boolean> hasApple) {
        visitedNodes.add(currentNode);

        final List<Integer> childSums = childrenByParent.getOrDefault(currentNode, Collections.emptySet())
                .stream()
                .filter(v -> !visitedNodes.contains(v))
                .map(child -> helper(child, childrenByParent, visitedNodes, hasApple))
                .filter(v -> v > 0)
                .collect(Collectors.toList());
        final int childSumsCount = childSums.size();
        final int sum = childSums.stream().reduce(0, Integer::sum);

        if (0 != currentNode) {
            if (childSumsCount > 0 || hasApple.get(currentNode)) {
                return 2 + sum;
            }
        }

        return sum;
    }
}
