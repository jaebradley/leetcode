package problems;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 * <p>
 * An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.
 * <p>
 * graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.
 * <p>
 * Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2,3],[0],[0],[0]]
 * Output: 4
 * Explanation: One possible path is [1,0,2,0,3]
 * Example 2:
 * <p>
 * Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * Output: 4
 * Explanation: One possible path is [0,1,4,2,3]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 *
 * Approach:
 *
 * 1. Use a bitmask to keep track of what nodes have been visited already
 *   * 111 - this means that nodes 0-2 were visited
 *   * Can set the bit value to 1 at a given index via the << operator
 *   * The bitwise OR operator (|) produces a value that sets the value of a bit to 1 if the value of the bit at that index
 *     is 1 for at least one of the values being compared.
 *   * The bitwise OR operator allows the ability to take an existing bitmask and set a bit to 1 by combining the value
 *     with a bitmask where 1 is set to a given bit (via the << operator)
 * 2. Need to let nodes visit previous nodes, but to avoid cycles
 *    * When cycles occur, the bitmask does not change
 *    * When a node index is seen again with the same bitmask, this indicates that a cycle has occurred
 * 3. Add all starting points to a queue, where the bitmask for the point is set appropriately using the << operator
 *    * Set the count value associated with the starting points to 0
 * 4. Iterate through the queue, only considering points that have not yet been seen
 * 5. if a bitmask is seen that is equal to "1"s for all possible nodes then return the stored count
 * 6. If a bitmask is not seen that is equivalent, iterate through all possible next values, calculate the next bitmask,
 *    and set the count by incrementing the current point's count by 1
 */

public class ShortestPathVisitingAllNodes {
    public static class NodeVisit {
        private final int nodeIndex;
        private final int bitMask;

        public NodeVisit(int nodeIndex, int bitMask) {
            this.nodeIndex = nodeIndex;
            this.bitMask = bitMask;
        }

        public int getNodeIndex() {
            return nodeIndex;
        }

        public int getBitMask() {
            return bitMask;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NodeVisit nodeVisit = (NodeVisit) o;
            return getNodeIndex() == nodeVisit.getNodeIndex() && getBitMask() == nodeVisit.getBitMask();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getNodeIndex(), getBitMask());
        }
    }

    public static class PathElementVisit {
        private final NodeVisit nodeVisit;
        private final int count;

        public PathElementVisit(NodeVisit nodeVisit, int count) {
            this.nodeVisit = nodeVisit;
            this.count = count;
        }

        public NodeVisit getNodeVisit() {
            return nodeVisit;
        }

        public int getCount() {
            return count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PathElementVisit that = (PathElementVisit) o;
            return getCount() == that.getCount() && Objects.equals(getNodeVisit(), that.getNodeVisit());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getNodeVisit(), getCount());
        }
    }

    public int shortestPathLength(int[][] graph) {
        final Set<NodeVisit> visitedNodes = new HashSet<>();
        final Queue<PathElementVisit> nodesToVisit = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            nodesToVisit.add(new PathElementVisit(new NodeVisit(i, 1 << i), 0));
        }

        while (!nodesToVisit.isEmpty()) {
            final PathElementVisit currentNode = nodesToVisit.poll();
            if (!visitedNodes.contains(currentNode.getNodeVisit())) {
                if ((1 << graph.length) - 1 == currentNode.getNodeVisit().getBitMask()) {
                    return currentNode.getCount();
                }

                visitedNodes.add(currentNode.getNodeVisit());

                for (int relatedNode : graph[currentNode.getNodeVisit().getNodeIndex()]) {
                    final NodeVisit nextNodeVisit = new NodeVisit(
                            relatedNode,
                            currentNode.getNodeVisit().getBitMask() | 1 << relatedNode
                    );

                    nodesToVisit.add(
                            new PathElementVisit(nextNodeVisit, currentNode.getCount() + 1)
                    );
                }
            }
        }

        throw new RuntimeException("should not get here");
    }
}
