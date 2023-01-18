package problems._947;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 *
 * On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
 *
 * A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
 *
 * Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
 *
 * Approach:
 *
 * The intuition is that the number of stones - the number of islands (groups of connected stones) is the number of stones
 * that can be removed.
 */

public class Solution {
    private static class Coordinate {
        private final int rowValue;
        private final int columnValue;

        public Coordinate(final int rowValue, final int columnValue) {
            this.rowValue = rowValue;
            this.columnValue = columnValue;
        }

        public int getRowValue() {
            return rowValue;
        }

        public int getColumnValue() {
            return columnValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return rowValue == that.rowValue && columnValue == that.columnValue;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rowValue, columnValue);
        }
    }

    public int removeStones(int[][] stones) {
        final List<Coordinate> s = Arrays.stream(stones).map(v -> new Coordinate(v[0], v[1])).collect(Collectors.toList());
        final Set<Coordinate> visited = new HashSet<>();
        int islandCount = 0;

        for (int[] stone : stones) {
            final Coordinate currentCoordinate = new Coordinate(stone[0], stone[1]);
            if (!visited.contains(currentCoordinate)) {
                dfs(currentCoordinate, visited, s);
                islandCount += 1;
            }
        }

        return stones.length - islandCount;
    }

    private static void dfs(final Coordinate currentStone,
                            final Set<Coordinate> visitedStones,
                            final List<Coordinate> stones) {

        visitedStones.add(currentStone);
        stones
                .stream()
                .filter(v -> !visitedStones.contains(v))
                .filter(v -> v.getRowValue() == currentStone.getRowValue() || v.getColumnValue() == currentStone.getColumnValue())
                .forEach(v -> dfs(v, visitedStones, stones));

    }
}
