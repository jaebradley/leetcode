package problems._1466;

import java.util.*;

public class Solution {
    static class Pair {
        public final int node;
        public final boolean inOrder;

        public Pair(final int node, final boolean inOrder) {
            this.node = node;
            this.inOrder = inOrder;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return node == pair.node && inOrder == pair.inOrder;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, inOrder);
        }
    }

    public int minReorder(int n, int[][] connections) {
        final Set<Integer> visitedNodes = new HashSet<>();
        final Map<Integer, Set<Pair>> adjacencyList = new HashMap<>();
        for (final int[] connection : connections) {
            final int firstNode = connection[0];
            final int secondNode = connection[1];

            final Set<Pair> adjacentNodesToFirstNode = adjacencyList.getOrDefault(firstNode, new HashSet<>());
            adjacentNodesToFirstNode.add(new Pair(secondNode, true));
            adjacencyList.put(firstNode, adjacentNodesToFirstNode);

            final Set<Pair> adjacentNodesToSecondNode = adjacencyList.getOrDefault(secondNode, new HashSet<>());
            adjacentNodesToSecondNode.add(new Pair(firstNode, false));
            adjacencyList.put(secondNode, adjacentNodesToSecondNode);
        }
        return dfs(visitedNodes, adjacencyList, 0);
    }

    private static int dfs(final Set<Integer> visitedNodes, final Map<Integer, Set<Pair>> adjacencyList, final int currentNode) {
        int counter = 0;
        visitedNodes.add(currentNode);
        final Set<Pair> adjacentNodes = adjacencyList.get(currentNode);
        if (null != adjacentNodes) {
            for (final Pair adjacentNode : adjacentNodes) {
                if (!visitedNodes.contains(adjacentNode.node)) {
                    if (adjacentNode.inOrder) {
                        counter += 1;
                    }

                    counter += dfs(visitedNodes, adjacencyList, adjacentNode.node);
                }
            }
        }
        return counter;
    }
}
