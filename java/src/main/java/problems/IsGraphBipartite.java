package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/is-graph-bipartite/
 *
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
 *
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 *
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 *
 *
 * Note:
 *
 * graph will have length in range [1, 100].
 * graph[i] will contain integers in range [0, graph.length - 1].
 * graph[i] will not contain i or duplicate values.
 * The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 *
 * Approach:
 *
 * 1. Idea is to imagine that each set is a color (so "red" or "blue"). If a graph is bipartite, no two connected nodes
 *    in the graph should have the same color.
 * 2. Traverse the graph (DFS is fine) - start with whichever color. If a node being considered and it does not have a color,
 *    choose a color for it. If it does have a color, choose the opposite color for all the connected nodes.
 * 3. If a connected node already has a color and it has the same color as the current node's color, the graph cannot
 *    be bipartite
 */

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        for (int currentNodeIndex = 0; currentNodeIndex < graph.length; currentNodeIndex++) {
            if (colors[currentNodeIndex] == 0 && !this.dfs(currentNodeIndex, colors, graph, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int currentNode, int[] colors, int[][] graph, int expectedCurrentNodeColor) {
        if (colors[currentNode] != 0) {
            return colors[currentNode] == expectedCurrentNodeColor;
        }

        colors[currentNode] = expectedCurrentNodeColor;

        for (int connectedNode : graph[currentNode]) {
            if (!this.dfs(connectedNode, colors, graph, -expectedCurrentNodeColor)) {
                return false;
            }
        }

        return true;
    }
}
