package problems._743;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Starting node has a cost of 0.
 * All other nodes have a cost of infinity.
 * For each edge, if cost[end node] > cost[start node], then update cost[end node] to be cost[start node] + weight of start node.
 * Repeat this N times.
 * Identify max value of all costs if max value is not Integer.MAX_VALUE
 */

public class BellmanFordSolution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int[] costs = new int[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[k] = 0;

        for (int iteration = 0; iteration < n; iteration += 1) {
            for (int[] edge : times) {
                if (costs[edge[0]] != Integer.MAX_VALUE) {
                    costs[edge[1]] = Math.min(costs[edge[1]], costs[edge[0]] + edge[2]);
                }
            }
        }

        return IntStream.rangeClosed(1, n)
                .boxed()
                .map(index -> costs[index])
                .max(Integer::compare)
                .map(v -> v == Integer.MAX_VALUE ? -1 : v)
                .orElseThrow();
    }
}
