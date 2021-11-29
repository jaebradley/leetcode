package problems._1334;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static class Edge {
        public final int destinationNode;
        public final int cost;

        public Edge(int destinationNode, int cost) {
            this.destinationNode = destinationNode;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return destinationNode == edge.destinationNode && cost == edge.cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(destinationNode, cost);
        }
    }


    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        final List<Map<Integer, Integer>> costsByDestinationNodes = new ArrayList<>(n);
        final List<List<Integer>> minimumCosts = new ArrayList<>(n);
        for (int i = 0; i < n; i += 1) {
            costsByDestinationNodes.add(i, new HashMap<>());
            int finalI = i;
            minimumCosts.add(
                    i,
                    IntStream.range(0, n)
                            .boxed()
                            .map(
                                    index -> {
                                        if (index == finalI) {
                                            return 0;
                                        }

                                        return Integer.MAX_VALUE;
                                    }
                            )
                            .collect(Collectors.toList())
            );
        }

        for (int[] edge : edges) {
            final int sourceNode = edge[0];
            final int destinationNode = edge[1];
            final int cost = edge[2];

            costsByDestinationNodes.get(sourceNode).put(destinationNode, cost);
            costsByDestinationNodes.get(destinationNode).put(sourceNode, cost);
        }

        for (int i = 0; i < n; i += 1) {
            djikstra(i, minimumCosts.get(i), costsByDestinationNodes);
        }

        return IntStream.range(0, n)
                .boxed()
                .map(v -> Map.entry(v, minimumCosts.get(v).stream().filter(c -> c <= distanceThreshold).filter(c -> c != 0).count()))
                .sorted(Comparator.<Map.Entry<Integer, Long>>comparingLong(Map.Entry::getValue).thenComparingInt(v -> -v.getKey()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("unexpected"));
    }

    private static void djikstra(final int sourceNode, final List<Integer> minimumCosts, final List<Map<Integer, Integer>> costsByDestinationNodes) {
        final PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(v -> v.cost));
        priorityQueue.add(new Edge(sourceNode, 0));
        while (!priorityQueue.isEmpty()) {
            final Edge edge = priorityQueue.remove();
            if (edge.cost <= minimumCosts.get(edge.destinationNode)) {
                for (final Map.Entry<Integer, Integer> adjacentNode : costsByDestinationNodes.get(edge.destinationNode).entrySet()) {
                    int candidateAdjacentNodeCost = edge.cost + adjacentNode.getValue();
                    if (candidateAdjacentNodeCost < minimumCosts.get(adjacentNode.getKey())) {
                        minimumCosts.set(adjacentNode.getKey(), candidateAdjacentNodeCost);
                        priorityQueue.add(new Edge(adjacentNode.getKey(), candidateAdjacentNodeCost));
                    }
                }
            }
        }
    }
}
