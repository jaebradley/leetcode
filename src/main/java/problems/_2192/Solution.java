package problems._2192;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        final Map<Integer, Set<Integer>> adjacencyList = Arrays.stream(edges)
                .map(edge -> Map.entry(edge[0], edge[1]))
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue, Collectors.toSet())
                        )
                );

        final List<List<Integer>> results = IntStream
                .range(0, n)
                .boxed()
                .map(v -> new ArrayList<Integer>())
                .collect(Collectors.toList());

        IntStream.range(0, n)
                .forEach(v -> dfs(v, v, results, adjacencyList));

        return results;
    }

    private static void dfs(final int ancestor, final int currentChild, final List<List<Integer>> results, final Map<Integer, Set<Integer>> adjacencyList) {
        for (final int nextChild : adjacencyList.getOrDefault(currentChild, Collections.emptySet())) {
            final List<Integer> nextChildResults = results.get(nextChild);
            if (nextChildResults.isEmpty() || ancestor != nextChildResults.get(nextChildResults.size() - 1)) {
                results.get(nextChild).add(ancestor);
                dfs(ancestor, nextChild, results, adjacencyList);
            }
        }
    }

}
