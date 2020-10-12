package problems;

/**
 * https://leetcode.com/problems/redundant-connection/
 *
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 *
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 *
 * Approach:
 *
 * 1. Use Union Find by Rank - union find is the concept where you build a relationship between a node and the root of
 *    the tree the node is in. The "union" part is that if two roots of two trees are different, the trees (i.e. the roots)
 *    are combined
 * 2. The point of using rank is to avoid naively adding root Y to root X - this may grow to be O(n) over time. Instead,
 *    attach the shorter tree to the larger one when "merging" trees
 * 3. The logic in findRootIndex is used to generate path compression. The idea is that since all the elements visited
 *    from some node to the root are part of the same set - they can all point to the root node
 */

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length);

        for (int[] edge : edges) {
            if (!disjointSet.union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }

        throw new RuntimeException("Did not find cycle");
    }

    private static class DisjointSet {
        private final int[] parents;
        private final byte[] rank;

        public DisjointSet(int size) {
            this.parents = new int[size];
            this.rank = new byte[size];
        }

        public int findRootIndex(int childIndex) {
            if (this.parents[childIndex] == 0) {
                return childIndex;
            }

            int rootParentIndex = this.findRootIndex(this.parents[childIndex]);
            this.parents[childIndex] = rootParentIndex;
            return rootParentIndex;
        }

        public boolean union(int firstIndex, int secondIndex) {
            int firstRootIndex = this.findRootIndex(firstIndex);
            int secondRootIndex = this.findRootIndex(secondIndex);

            if (firstRootIndex == secondRootIndex) {
                return false;
            }

            if (this.rank[firstRootIndex] < this.rank[secondRootIndex]) {
                this.parents[firstRootIndex] = secondRootIndex;
            } else if (this.rank[firstRootIndex] > this.rank[secondRootIndex]) {
                this.parents[secondRootIndex] = firstRootIndex;
            } else {
                this.parents[firstRootIndex] = secondRootIndex;
                this.rank[secondRootIndex]++;
            }

            return true;
        }
    }
}
