package problems._2285;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/maximum-total-importance-of-roads/
 * <p>
 * You are given an integer n denoting the number of cities in a country. The cities are numbered from 0 to n - 1.
 * <p>
 * You are also given a 2D integer array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional road connecting cities ai and bi.
 * <p>
 * You need to assign each city with an integer value from 1 to n, where each value can only be used once. The importance of a road is then defined as the sum of the values of the two cities it connects.
 * <p>
 * Return the maximum total importance of all roads possible after assigning the values optimally.
 * <p>
 * Approach:
 * Calculate the indegree for all cities
 * Order the cities by indegree
 * Assign the largest integer values to cities in decreasing order
 * Iterate over roads again and calculate importance
 */

public class Solution {
    public long maximumImportance(int n, int[][] roads) {
        final Map<Integer, Integer> indegreeByCity = IntStream.range(0, n)
                .boxed()
                .collect(
                        Collectors.toMap(
                                v -> v,
                                v -> 0
                        )
                );
        for (final int[] road : roads) {
            indegreeByCity.merge(road[0], 1, Integer::sum);
            indegreeByCity.merge(road[1], 1, Integer::sum);
        }

        final List<Integer> sortedCities = indegreeByCity
                .entrySet()
                .stream()
                .sorted((firstCity, secondCity) -> secondCity.getValue() - firstCity.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        final Map<Integer, Integer> valueByCity = new HashMap<>();
        for (int cityIndex = 0; cityIndex < n; cityIndex += 1) {
            final int city = sortedCities.get(cityIndex);
            valueByCity.put(city, n - cityIndex);
        }

        return Arrays.stream(roads)
                .reduce(
                        0L,
                        (sum, road) -> sum + valueByCity.get(road[0]) + valueByCity.get(road[1]),
                        Long::sum
                );
    }
}
