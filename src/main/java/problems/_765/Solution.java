package problems._765;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/couples-holding-hands/discuss/117520/Java-union-find-easy-to-understand-5-ms
 *
 * Concept is to use think of each pair of nodes as a node / component.
 * Each node that is not next to its pair is "connected" to a node that contains its pair.
 * The number of swaps is equal to the number of nodes - the number of connected components.
 * The number of connected components is the number of nodes whose roots are empty (i.e. that node is the root).
 * Can calculate this using Union Find.
 */

class Solution {
    private static class UnionFind {
        private static class Node {
            private Optional<Node> parent;
            private final int value;

            public Node(final Optional<Node> parent, final int value) {
                this.parent = parent;
                this.value = value;
            }

            public Optional<Node> getParent() {
                return parent;
            }

            public void setParent(final Optional<Node> parent) {
                this.parent = parent;
            }

            public int getValue() {
                return value;
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
        }

        private final Set<Node> nodes;
        private final Map<Integer, Node> nodesByValue;

        public UnionFind(final Set<Node> nodes) {
            this.nodes = nodes;
            this.nodesByValue = nodes
                    .stream()
                    .collect(
                            Collectors.toMap(
                                    Node::getValue,
                                    Function.identity()
                            )
                    );
        }

        public Set<Node> getNodes() {
            return nodes;
        }

        public Node find(final Node node) {
            if (node.getParent().isEmpty()) {
                return node;
            }

            final Node root = find(node.getParent().get());
            node.setParent(Optional.of(root));

            return root;
        }

        public void union(final int first, final int second) {
            final Node firstRoot = find(nodesByValue.get(first));
            final Node secondRoot = find(nodesByValue.get(second));

            if (firstRoot.value != secondRoot.value) {
                firstRoot.setParent(Optional.of(secondRoot));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UnionFind unionFind = (UnionFind) o;
            return Objects.equals(nodes, unionFind.nodes);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nodes);
        }
    }

    public int minSwapsCouples(int[] row) {
        final int pairCount = row.length / 2;
        final UnionFind unionFind = new UnionFind(
                IntStream.range(0, pairCount)
                        .boxed()
                        .map(v -> new UnionFind.Node(Optional.empty(), v))
                        .collect(Collectors.toSet())
        );
        for (int pairIndex = 0; pairIndex < pairCount; pairIndex += 1) {
            final int firstValue = row[2 * pairIndex];
            final int secondValue = row[2 * pairIndex + 1];
            unionFind.union(firstValue / 2, secondValue / 2);
        }

        return pairCount - (int) unionFind.getNodes().stream().filter(v -> v.getParent().isEmpty()).count();
    }
}
