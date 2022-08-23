package problems._834;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        final Map<Integer, Set<Integer>> adjacencyList = Arrays.stream(edges)
                .flatMap(v -> Stream.of(Map.entry(v[0], v[1]), Map.entry(v[1], v[0])))
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue, Collectors.toSet())
                        )
                );
        final int[] counts = new int[n];
        final int[] results = new int[n];

        counting(0, Optional.empty(), adjacencyList, counts, results);
        calculateResults(0, Optional.empty(), adjacencyList, counts, results);

        return results;
    }

    private static void counting(
            final int currentNode,
            final Optional<Integer> previousNode,
            final Map<Integer, Set<Integer>> adjacencyList,
            final int[] counts,
            final int[] results
    ) {
        adjacencyList
                .getOrDefault(currentNode, Collections.emptySet())
                .stream()
                .filter(v -> previousNode.map(pre -> !v.equals(pre)).orElse(Boolean.TRUE))
                .forEach(
                        v -> {
                            counting(
                                    v,
                                    Optional.of(currentNode),
                                    adjacencyList,
                                    counts,
                                    results
                            );

                            counts[currentNode] += counts[v];
                            results[currentNode] += counts[v];
                            results[currentNode] += results[v];
                        }
                );
        counts[currentNode] += 1;
    }

    private static void calculateResults(
            final int currentNode,
            final Optional<Integer> previousNode,
            final Map<Integer, Set<Integer>> adjacencyList,
            final int[] counts,
            final int[] results
    ) {
        adjacencyList
                .getOrDefault(currentNode, Collections.emptySet())
                .stream()
                .filter(v -> previousNode.map(pre -> !v.equals(pre)).orElse(Boolean.TRUE))
                .forEach(
                        v -> {
                            // When we move our root from parent to its child i, count[i] points get 1 closer to root, n - count[i] nodes get 1 futhur to root.
                            results[v] = results[currentNode] - counts[v] + counts.length - counts[v];

                            calculateResults(
                                    v,
                                    Optional.of(currentNode),
                                    adjacencyList,
                                    counts,
                                    results
                            );
                        }
                );
    }
}
