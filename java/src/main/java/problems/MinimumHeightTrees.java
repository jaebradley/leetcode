package problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 *
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
 *
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 *
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 *
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, edges = [[1,0],[1,2],[1,3]]
 * Output: [1]
 * Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
 * Example 2:
 *
 *
 * Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * Output: [3,4]
 * Example 3:
 *
 * Input: n = 1, edges = []
 * Output: [0]
 * Example 4:
 *
 * Input: n = 2, edges = [[0,1]]
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 104
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * All the pairs (ai, bi) are distinct.
 * The given input is guaranteed to be a tree and there will be no repeated edges.
 *
 * Approach:
 *
 * 1. Find the leaves (i.e. nodes with a single degree)
 * 2. Move to the next set of nodes on each "step"
 * 3. If multiple nodes find their way to a common node, use that common node
 * 4. When there are two nodes left, find the spot where they meet, or the roots that are 1 away
 * 5. Use adjacency matrix to store undirected edges
 * 6. Keep track of leaves - when moving "inwards" can remove "outer" leaves from any related edges and only consider
 *    new leaves that are "inside" the tree. This means iterating through the existing collection of leaves, finding
 *    the one related node, removing the leaf from that node's collection of related nodes and adding that node to the
 *    set of new leaves if it has a single remaining related node
 */

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(1);
        }
        
        Map<Integer, Set<Integer>> adjacencyMatrix = new HashMap<>();

        for (int[] edge : edges) {
            if (adjacencyMatrix.containsKey(edge[0])) {
                adjacencyMatrix.get(edge[0]).add(edge[1]);
            } else {
                Set<Integer> nodes = new HashSet<>();
                nodes.add(edge[1]);
                adjacencyMatrix.putIfAbsent(edge[0], nodes);
            }

            if (adjacencyMatrix.containsKey(edge[1])) {
                adjacencyMatrix.get(edge[1]).add(edge[0]);
            } else {
                Set<Integer> nodes = new HashSet<>();
                nodes.add(edge[0]);
                adjacencyMatrix.putIfAbsent(edge[1], nodes);
            }
        }

        Set<Integer> leaves =  adjacencyMatrix
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        while (n > 2) {
            n -= leaves.size();

            Set<Integer> nextLeaves = new HashSet<>();

            for (int leaf : leaves) {
                int relatedNode = adjacencyMatrix.get(leaf).iterator().next();
                adjacencyMatrix.get(relatedNode).remove(leaf);
                if (adjacencyMatrix.get(relatedNode).size() == 1) {
                    nextLeaves.add(relatedNode);
                }
            }

            leaves = nextLeaves;
        }

        return new ArrayList<>(leaves);
    }
}
