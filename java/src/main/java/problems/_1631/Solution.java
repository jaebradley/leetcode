package problems._1631;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * https://leetcode.com/problems/path-with-minimum-effort/
 * <p>
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 * <p>
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * <p>
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
 * Example 3:
 * <p>
 * <p>
 * Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * Output: 0
 * Explanation: This route does not require any effort.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 */
public class Solution {
    private static class Cell {
        public final int verticalIndex;
        public final int horizontalIndex;

        public Cell(final int verticalIndex, final int horizontalIndex) {
            this.verticalIndex = verticalIndex;
            this.horizontalIndex = horizontalIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return verticalIndex == cell.verticalIndex && horizontalIndex == cell.horizontalIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(verticalIndex, horizontalIndex);
        }
    }

    public int minimumEffortPath(int[][] heights) {
        final int[][] minimumEfforts = new int[heights.length][heights[0].length];
        for (int verticalIndex = 0; verticalIndex < heights.length; verticalIndex += 1) {
            for (int horizontalIndex = 0; horizontalIndex < heights[verticalIndex].length; horizontalIndex += 1) {
                minimumEfforts[verticalIndex][horizontalIndex] = Integer.MAX_VALUE;
            }
        }
        minimumEfforts[0][0] = 0;
        final Queue<Cell> cellsToEvaluate = new LinkedList<>();
        cellsToEvaluate.add(new Cell(0, 0));

        while (!cellsToEvaluate.isEmpty()) {
            final Cell cell = cellsToEvaluate.poll();
            final int height = heights[cell.verticalIndex][cell.horizontalIndex];
            int currentCellMinimumEffort = minimumEfforts[cell.verticalIndex][cell.horizontalIndex];
            for (int i = -1; i <= 1; i += 1) {
                for (int y = -1; y <= 1; y += 1) {
                    final int nextVerticalIndex = cell.verticalIndex + i;
                    final int nextHorizontalIndex = cell.horizontalIndex + y;
                    if (nextVerticalIndex >= 0 && nextHorizontalIndex >= 0 && nextVerticalIndex < heights.length && nextHorizontalIndex < heights[nextVerticalIndex].length && Math.abs(i) != Math.abs(y)) {
                        final Cell neighbor = new Cell(nextVerticalIndex, nextHorizontalIndex);
                        final int neighborHeightDifference = Math.abs(heights[neighbor.verticalIndex][neighbor.horizontalIndex] - height);
                        final int nextNeighborEffort = Math.max(currentCellMinimumEffort, neighborHeightDifference);
                        if (nextNeighborEffort < minimumEfforts[neighbor.verticalIndex][neighbor.horizontalIndex]) {
                            minimumEfforts[neighbor.verticalIndex][neighbor.horizontalIndex] = nextNeighborEffort;
                            cellsToEvaluate.add(neighbor);
                        }
                    }
                }
            }

        }
        return minimumEfforts[minimumEfforts.length - 1][minimumEfforts[minimumEfforts.length - 1].length - 1];
    }
}
