package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/possible-bipartition/
 *
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 *
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 *
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 * Approach:
 *
 * 1. Dislikes basically represent the edges between nodes to consider, so use 1 / -1 to indicate which group a node is in
 * 2. Start with an arbitrary node and mark it as 1 - for all the related nodes (need to create an adjacency list) mark them as -1
 * 3. If any related node is not marked as 0 (i.e. it HAS been visited) and it is not the opposite value, then the graph is not a
 *    bipartite graph.
 */

public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] partitionTracker = new int[N + 1];
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

        for (int node = 1; node <= N; node++) {
            adjacencyList.put(node, new HashSet<>());
        }

        for (int[] dislike : dislikes) {
            Set<Integer> relatedNodes = adjacencyList.getOrDefault(dislike[0], new HashSet<>());
            relatedNodes.add(dislike[1]);
            adjacencyList.put(dislike[0], relatedNodes);

            Set<Integer> relatedNodes2 = adjacencyList.getOrDefault(dislike[1], new HashSet<>());
            relatedNodes2.add(dislike[0]);
            adjacencyList.put(dislike[1], relatedNodes2);
        }

        for (int node = 1; node <= N; node++) {
            if (partitionTracker[node] == 0 && !this.dfs(partitionTracker, adjacencyList, node, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[] partitionTracker, Map<Integer, Set<Integer>> adjacencyList, int node, int expectedPartitionValue) {
        if (partitionTracker[node] != 0) {
            return partitionTracker[node] == expectedPartitionValue;
        }

        partitionTracker[node] = expectedPartitionValue;

        for (int nextNode : adjacencyList.get(node)) {
            if (!this.dfs(partitionTracker, adjacencyList, nextNode, -expectedPartitionValue)) {
                return false;
            }
        }

        return true;
    }
}
