package problems._547;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 * <p>
 * <p>
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */

class Solution {
    static class DisjointSet {
        static class Node {
            private Node parent;
            private final int value;

            public Node(final Node parent, final int value) {
                this.parent = parent;
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

        public DisjointSet(final int initialGroupCount) {
            if (0 >= initialGroupCount) {
                throw new IllegalArgumentException("initial group count of " + initialGroupCount + "must be a positive value");
            }
            this.nodesByValue = IntStream
                    .range(0, initialGroupCount)
                    .boxed()
                    .collect(
                            Collectors.toMap(
                                    Function.identity(),
                                    v -> new Node(null, v)
                            )
                    );
        }

        private Node findRoot(final int value) {
            final Node node = nodesByValue.get(value);
            if (null == node) {
                throw new RuntimeException("unexpected");
            }

            if (null == node.parent) {
                return node;
            }

            final Node root = findRoot(node.parent.value);
            node.setParent(root);
            return root;
        }

        public void union(final int value1, final int value2) {
            final Node root1 = findRoot(value1);
            final Node root2 = findRoot(value2);

            if (!root1.equals(root2)) {
                root2.setParent(root1);
            }
        }

        public int calculateGroupsCount() {
            return (int) this.nodesByValue
                    .values()
                    .stream()
                    .filter(node -> null == node.parent)
                    .distinct()
                    .count();
        }
    }

    public int findCircleNum(int[][] isConnected) {
        final int numberOfCities = isConnected.length;
        final DisjointSet disjointSet = new DisjointSet(numberOfCities);
        for (int verticalIndex = 0; verticalIndex < numberOfCities; verticalIndex += 1) {
            for (int horizontalIndex = 0; horizontalIndex < numberOfCities; horizontalIndex += 1) {
                if (1 == isConnected[verticalIndex][horizontalIndex]) {
                    disjointSet.union(
                            verticalIndex,
                            horizontalIndex
                    );
                }
            }
        }
        return disjointSet.calculateGroupsCount();
    }
}
