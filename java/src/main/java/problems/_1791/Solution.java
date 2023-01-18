package problems._1791;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/find-center-of-star-graph/
 *
 * There is an undirected star graph consisting of n nodes labeled from 1 to n.
 * A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
 *
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi.
 * Return the center of the given star graph.
 */

public class Solution {
    public int findCenter(int[][] edges) {
        final Map<Integer, Long> countsByNode = Arrays.stream(edges)
                .flatMap(v -> Stream.of(
                        Map.entry(v[0], v[1]),
                        Map.entry(v[1], v[0])))
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.counting()
                        ));

        return countsByNode
                .entrySet()
                .stream()
                .filter(v -> v.getValue().equals((long) countsByNode.keySet().size() - 1))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();

    }
}
