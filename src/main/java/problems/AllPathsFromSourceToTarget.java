package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Example 2:
 *
 *
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * Example 3:
 *
 * Input: graph = [[1],[]]
 * Output: [[0,1]]
 * Example 4:
 *
 * Input: graph = [[1,2,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,2,3],[0,3]]
 * Example 5:
 *
 * Input: graph = [[1,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,3]]
 *
 *
 * Constraints:
 *
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * The input graph is guaranteed to be a DAG.
 *
 * Approach:
 *
 * 1. Because it's a DAG don't have to worry about cycles
 * 2. Just BFS for graph traversal - but track "paths" in a List. Start the queue with a List with value 0; the index value
 *    of the start node
 * 3. When a path is pulled from the queue, inspect the last value added to the List - if that index value has dependencies
 *    create N paths for each dependency where each new List is added back to the start of the queue
 * 4. If the last index for a given List is the last index value, remove it from the queue and add the path to the solution
 *    list of all the possible paths
 * 5. When there are no more paths in the queue, return the solution list of possible paths
 */

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();

        if (graph != null && graph.length > 0) {
            Queue<List<Integer>> existingPaths = new LinkedList<>();
            existingPaths.add(List.of(0));

            while (!existingPaths.isEmpty()) {
                List<Integer> currentPath = existingPaths.poll();

                int dependentIndex = currentPath.get(currentPath.size() - 1);
                if (dependentIndex == graph.length - 1) {
                    paths.add(currentPath);
                } else {
                    int[] dependentIndices = graph[dependentIndex];

                    if (dependentIndices.length > 0) {
                        for (int nextDependentIndex : dependentIndices) {
                            List<Integer> nextPath = new ArrayList<>(currentPath);
                            nextPath.add(nextDependentIndex);
                            existingPaths.add(nextPath);
                        }
                    }
                }
            }
        }


        return paths;
    }
}
