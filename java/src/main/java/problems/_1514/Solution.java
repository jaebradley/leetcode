package problems._1514;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        final Map<Integer, Map<Integer, Double>> adjacentNodes = new HashMap<>();
        for (int index = 0; index < edges.length; index += 1) {
            final int[] edge = edges[index];
            final int firstNode = edge[0];
            final int secondNode = edge[1];
            final double probability = succProb[index];

            adjacentNodes.putIfAbsent(firstNode, new HashMap<>());
            adjacentNodes.putIfAbsent(secondNode, new HashMap<>());
            adjacentNodes.get(firstNode).put(secondNode, probability);
            adjacentNodes.get(secondNode).put(firstNode, probability);
        }
        final double[] maximumProbabilities = new double[n];
        maximumProbabilities[start] = 1;

        final PriorityQueue<Integer> nodes = new PriorityQueue<>(Comparator.comparing(v -> -maximumProbabilities[v]));
        nodes.add(start);
        while (!nodes.isEmpty()) {
            final int currentNode = nodes.remove();
            final double currentNodeProbability = maximumProbabilities[currentNode];
            if (currentNode == end) {
                return currentNodeProbability;
            }

            final Map<Integer, Double> surroundingNodes = adjacentNodes.getOrDefault(currentNode, new HashMap<>());

            for (final Map.Entry<Integer, Double> node : surroundingNodes.entrySet()) {
                final double currentMaximumProbability = maximumProbabilities[node.getKey()];
                final double adjacentNodeProbability = node.getValue() * currentNodeProbability;

                if (adjacentNodeProbability > currentMaximumProbability) {
                    maximumProbabilities[node.getKey()] = adjacentNodeProbability;
                    nodes.add(node.getKey());
                }
            }
        }

        return 0;
    }

}
