package problems._1319;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * There are n computers numbered from 0 to n-1 connected by ethernet cables connections forming a network where connections[i] = [a, b] represents a connection between computers a and b. Any computer can reach any other computer directly or indirectly through the network.
 *
 * Given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected. Return the minimum number of times you need to do this in order to make all the computers connected. If it's not possible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
 * Output: 1
 * Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
 * Example 2:
 *
 *
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * Output: 2
 * Example 3:
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * Output: -1
 * Explanation: There are not enough cables.
 * Example 4:
 *
 * Input: n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^5
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] < n
 * connections[i][0] != connections[i][1]
 * There are no repeated connections.
 * No two computers are connected by more than one cable.
 */

public class Solution {
    static class DisjointSet {
        static class Node {
            private Node parent;
            private final int value;

            public Node(int value) {
                this.value = value;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return value == node.value && Objects.equals(parent, node.parent);
            }

            @Override
            public int hashCode() {
                return Objects.hash(parent, value);
            }

            public void setParent(Node parent) {
                this.parent = parent;
            }
        }


        private final Map<Integer, Node> nodesByValue;
        private int redundantConnectionsCount = 0;

        public DisjointSet(final int n) {
            if (1 > n) {
                throw new IllegalArgumentException("expected a positive value instead of " + n);
            }
            this.nodesByValue = IntStream
                    .range(0, n)
                    .boxed()
                    .collect(
                            Collectors.toMap(
                                    Function.identity(),
                                    Node::new
                            )
                    );
        }

        private Node findRoot(final Node node) {
            if (null == node.parent) {
                return node;
            }

            final Node root = findRoot(node.parent);
            node.setParent(root);
            return root;
        }

        public void union(final int value1, final int value2) {
            final Node root1 = findRoot(nodesByValue.get(value1));
            final Node root2 = findRoot(nodesByValue.get(value2));

            if (!root1.equals(root2)) {
                root2.setParent(root1);
            } else {
                redundantConnectionsCount += 1;
            }
        }

        public int getRedundantConnectionsCount() {
            return this.redundantConnectionsCount;
        }

        public int getDistinctGroupCounts() {
            return (int) nodesByValue.values().stream().filter(node -> null == node.parent).distinct().count();
        }
    }

    public int makeConnected(int n, int[][] connections) {
        final DisjointSet disjointSet = new DisjointSet(n);
        for (final int[] connection : connections) {
            disjointSet.union(connection[0], connection[1]);
        }
        final int redundantConnectionsCount = disjointSet.getRedundantConnectionsCount();
        final int distinctGroupCounts = disjointSet.getDistinctGroupCounts();

        if ((distinctGroupCounts - 1) > redundantConnectionsCount) {
            return -1;
        }

        return distinctGroupCounts - 1;
    }
}
