package problems._2049;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int countHighestScoreNodes(int[] parents) {
        final Map<Integer, Set<Integer>> childrenByParent = IntStream
                .range(0, parents.length)
                .boxed()
                .map(currentNode -> Map.entry(parents[currentNode], currentNode))
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue, Collectors.toSet())
                        )
                );

        final Map<Long, Integer> countsByScore = new HashMap<>();

        calculateCount(0, childrenByParent, countsByScore, parents.length);

        return countsByScore.get(
                countsByScore
                        .keySet()
                        .stream()
                        .max(Long::compareTo)
                        .orElseThrow(() -> new IllegalStateException("max value not found"))
        );
    }

    private static int calculateCount(
            final int currentNode,
            final Map<Integer, Set<Integer>> childrenByParent,
            final Map<Long, Integer> countsByScore,
            final int nodesCount
    ) {
        final AtomicLong product = new AtomicLong(1);
        final AtomicInteger sum = new AtomicInteger();

        childrenByParent.getOrDefault(currentNode, Collections.emptySet())
                .forEach(child -> {
                    final int childCount = calculateCount(child, childrenByParent, countsByScore, nodesCount);
                    product.updateAndGet(v -> v * childCount);
                    sum.addAndGet(childCount);
                });

        countsByScore.merge(
                product.get() * Math.max(1, nodesCount - 1 - sum.get()),
                1,
                Integer::sum
        );

        return sum.get() + 1;
    }

}
