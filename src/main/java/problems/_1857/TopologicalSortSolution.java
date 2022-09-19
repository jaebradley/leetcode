package problems._1857;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Topological Sort
 * Track "indegree"s of a node (the number of incoming edges)
 * The nodes with 0 indegrees are sources
 * Remove the outgoing edges for each source
 * Then pick new set of nodes with 0 indegrees as sources
 * <p>
 * When processing node i:
 * 1. Increase the count for color at ith index (colors[i])
 * 2. Process all adjacent nodes, j
 * 3. Set count for each color to max of color value between i and jth nodes
 * 4. Decrease the indegree of i (i.e. remove the edge from i to j)
 * 5. If the jth node indegree becomes 0, add it as a source for the next round
 * <p>
 * Note that in a cycle, no nodes will ever have zero indegree.
 * As nodes are processed, count them, and at the end, make sure all nodes are processed (or else a cycle exists).
 */

public class TopologicalSortSolution {
    public int largestPathValue(String colors, int[][] edges) {
        final Map<Integer, Set<Integer>> adjacencyList = Arrays.stream(edges)
                .map(v -> Map.entry(v[0], v[1]))
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue, Collectors.toSet())
                        )
                );
        final Map<Integer, Set<Integer>> indegreeNodes = Arrays.stream(edges)
                .map(v -> Map.entry(v[1], v[0]))
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue, Collectors.toSet())));
        final Map<Integer, Map<Integer, Integer>> colorCountsByNode = new HashMap<>();

        int result = 0;
        int processedNodeCount = 0;
        Set<Integer> sourceNodes = IntStream.range(0, colors.length()).boxed().collect(Collectors.toSet());
        sourceNodes.removeAll(
                indegreeNodes
                .entrySet()
                .stream()
                .filter(e -> !e.getValue().isEmpty())
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet()));

        while (!sourceNodes.isEmpty()) {
            final Set<Integer> nextSourceNodes = new HashSet<>();
            for (final int sourceNode : sourceNodes) {
                processedNodeCount += 1;

                final char sourceNodeCharacter = colors.charAt(sourceNode);
                final Map<Integer, Integer> sourceNodeColorCounts = colorCountsByNode.getOrDefault(sourceNode, new HashMap<>());
                final Integer colorCount = sourceNodeColorCounts.getOrDefault(sourceNodeCharacter - 'a', 0);
                sourceNodeColorCounts.put(sourceNodeCharacter - 'a', 1 + colorCount);
                colorCountsByNode.put(sourceNode, sourceNodeColorCounts);

                result = Math.max(result, colorCountsByNode.get(sourceNode).get(sourceNodeCharacter - 'a'));

                final Set<Integer> adjacentNodes = adjacencyList.getOrDefault(sourceNode, Collections.emptySet());
                for (final int adjacentNode : adjacentNodes) {
                    final Map<Integer, Integer> adjacentNodeColorCounts = colorCountsByNode.getOrDefault(adjacentNode, new HashMap<>());
                    for (int colorIndex = 0; colorIndex < 26; colorIndex += 1) {
                        adjacentNodeColorCounts.put(
                                colorIndex,
                                Math.max(
                                        sourceNodeColorCounts.getOrDefault(colorIndex, 0),
                                        adjacentNodeColorCounts.getOrDefault(colorIndex, 0)));
                    }
                    colorCountsByNode.put(adjacentNode, adjacentNodeColorCounts);

                    final Set<Integer> adjacentNodeIndegreeNodes = indegreeNodes.getOrDefault(adjacentNode, new HashSet<>());
                    adjacentNodeIndegreeNodes.remove(sourceNode);
                    indegreeNodes.put(adjacentNode, adjacentNodeIndegreeNodes);
                    if (adjacentNodeIndegreeNodes.isEmpty()) {
                        nextSourceNodes.add(adjacentNode);
                    }
                }
            }

            sourceNodes = nextSourceNodes;
        }

        if (processedNodeCount == colors.length()) {
            return result;
        }

        return -1;
    }
}
