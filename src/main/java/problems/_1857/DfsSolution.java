package problems._1857;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
 */

public class DfsSolution {
    enum NodeVisitState {
        STARTED,
        FINISHED,
    }

    public int largestPathValue(String colors, int[][] edges) {
        final Map<Integer, Set<Integer>> adjacencyList = Arrays.stream(edges)
                .map(v -> Map.entry(v[0], v[1]))
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue, Collectors.toSet()))
                );

        final Map<Integer, NodeVisitState> visitedNodes = new HashMap<>();
        final Map<Integer, Map<Integer, Integer>> colorCountsByNode = new HashMap<>();

        int result = 0;
        for (int currentNode = 0; currentNode < colors.length(); currentNode += 1) {
            final Optional<Integer> value = dfs(currentNode, colors, adjacencyList, visitedNodes, colorCountsByNode);
            if (value.isEmpty()) {
                return -1;
            }
            result = Math.max(result, value.get());
        }

        return result;
    }

    private static Optional<Integer> dfs(
            final int currentNode,
            final String colors,
            final Map<Integer, Set<Integer>> adjacencyList,
            final Map<Integer, NodeVisitState> visitedNodes,
            Map<Integer, Map<Integer, Integer>> colorCountsByNode) {
        if (!visitedNodes.containsKey(currentNode)) {
            visitedNodes.put(currentNode, NodeVisitState.STARTED);

            for (final int adjacentNode : adjacencyList.getOrDefault(currentNode, Collections.emptySet())) {
                final Optional<Integer> adjacentResult = dfs(adjacentNode, colors, adjacencyList, visitedNodes, colorCountsByNode);
                if (adjacentResult.isEmpty()) {
                    return Optional.empty();
                }

                for (int characterIndex = 0; characterIndex < 26; characterIndex += 1) {
                    final Map<Integer, Integer> currentNodeColorCounts = colorCountsByNode.getOrDefault(currentNode, new HashMap<>());
                    currentNodeColorCounts.put(characterIndex, Math.max(
                            colorCountsByNode
                                    .getOrDefault(adjacentNode, Collections.emptyMap())
                                    .getOrDefault(characterIndex, 0),
                            colorCountsByNode
                                    .getOrDefault(currentNode, Collections.emptyMap())
                                    .getOrDefault(characterIndex, 0)));
                    colorCountsByNode.put(currentNode, currentNodeColorCounts);
                }
            }

            final Map<Integer, Integer> currentNodeColorCounts = colorCountsByNode.getOrDefault(currentNode, new HashMap<>());
            final Integer count = currentNodeColorCounts.getOrDefault(colors.charAt(currentNode) - 'a', 0);
            currentNodeColorCounts.put(colors.charAt(currentNode) - 'a', count + 1);
            colorCountsByNode.put(currentNode, currentNodeColorCounts);

            visitedNodes.put(currentNode, NodeVisitState.FINISHED);
        }

        if (visitedNodes.get(currentNode).equals(NodeVisitState.STARTED)) {
            return Optional.empty();
        }

        return Optional.of(
                colorCountsByNode
                        .getOrDefault(
                                currentNode,
                                Collections.emptyMap())
                        .getOrDefault(colors.charAt(currentNode) - 'a', 0)
        );
    }
}
