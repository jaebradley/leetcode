package problems._1615;

/**
 * https://leetcode.com/problems/maximal-network-rank/
 * <p>
 * There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.
 * <p>
 * The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.
 * <p>
 * The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
 * <p>
 * Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
 * <p>
 * Approach:
 * The maximal network rank is the max of pairs of different cities. So combine the indegrees for city 1 + indegrees for city 2, and take the max found.
 * To calculate the indegrees for city X, iterate over roads array, and increment count associated with road.
 * Ensure that directly connected cities are kept track of, to not double-count values.
 */

public class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        final int[] indegreeCountForCity = new int[n];
        final boolean[][] directlyConnectedCities = new boolean[n][n];
        for (final int[] road : roads) {
            indegreeCountForCity[road[0]] += 1;
            indegreeCountForCity[road[1]] += 1;

            directlyConnectedCities[road[0]][road[1]] = true;
            directlyConnectedCities[road[1]][road[0]] = true;
        }

        int maximumRank = 0;
        for (int firstCityIndex = 0; firstCityIndex < n; firstCityIndex += 1) {
            for (int secondCityIndex = 1 + firstCityIndex; secondCityIndex < n; secondCityIndex += 1) {
                maximumRank = Math.max(
                        maximumRank,
                        indegreeCountForCity[firstCityIndex] + indegreeCountForCity[secondCityIndex] - (directlyConnectedCities[firstCityIndex][secondCityIndex] ? 1 : 0)
                );
            }
        }
        return maximumRank;
    }
}
