package problems._1559;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.
 * <p>
 * A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.
 * <p>
 * Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.
 * <p>
 * Return true if any cycle of the same value exists in grid, otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
 * Output: true
 * Explanation: There are two valid cycles shown in different colors in the image below:
 * <p>
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
 * Output: true
 * Explanation: There is only one valid cycle highlighted in the image below:
 * <p>
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid consists only of lowercase English letters.
 */

public class Solution {
    private static class Cell {
        private final int verticalIndex;
        private final int horizontalIndex;

        public Cell(int verticalIndex, int horizontalIndex) {
            this.verticalIndex = verticalIndex;
            this.horizontalIndex = horizontalIndex;
        }

        public int getVerticalIndex() {
            return verticalIndex;
        }

        public int getHorizontalIndex() {
            return horizontalIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return getVerticalIndex() == cell.getVerticalIndex() && getHorizontalIndex() == cell.getHorizontalIndex();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getVerticalIndex(), getHorizontalIndex());
        }
    }

    private static class Tuple {
        private final Cell value1;
        private final Cell value2;

        public Tuple(Cell value1, Cell value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return Objects.equals(value1, tuple.value1) && Objects.equals(value2, tuple.value2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value1, value2);
        }

        public Cell getValue1() {
            return value1;
        }

        public Cell getValue2() {
            return value2;
        }
    }

    public boolean containsCycle(char[][] grid) {
        final int[][] visited = new int[grid.length][grid[0].length];

        final Stack<Tuple> cells = new Stack<>();
        cells.push(new Tuple(new Cell(0, 0), new Cell(0, 0)));

        while (!cells.empty()) {
            final Tuple pair = cells.pop();
            {
                final char value1 = grid[pair.getValue1().getVerticalIndex()][pair.getValue1().getHorizontalIndex()];
                final char value2 = grid[pair.getValue2().getVerticalIndex()][pair.getValue2().getHorizontalIndex()];
                final int visitedCount1 = visited[pair.getValue1().getVerticalIndex()][pair.getValue1().getHorizontalIndex()];
                final int visitedCount2 = visited[pair.getValue2().getVerticalIndex()][pair.getValue2().getHorizontalIndex()];
                if (value1 == value2 && (visitedCount1 - visitedCount2) >= 3) {
                    return true;
                }
            }
            Stream.of(
                            new Cell(pair.getValue1().getVerticalIndex() - 1, pair.getValue1().getHorizontalIndex()),
                            new Cell(pair.getValue1().getVerticalIndex(), pair.getValue1().getHorizontalIndex() - 1),
                            new Cell(pair.getValue1().getVerticalIndex() + 1, pair.getValue1().getHorizontalIndex()),
                            new Cell(pair.getValue1().getVerticalIndex(), pair.getValue1().getHorizontalIndex() + 1)
                    )
                    .filter(nextCell -> 0 <= nextCell.getVerticalIndex() && 0 <= nextCell.getHorizontalIndex())
                    .filter(nextCell -> grid.length > nextCell.getVerticalIndex() && grid[nextCell.getVerticalIndex()].length > nextCell.getHorizontalIndex())
                    .forEach(
                            nextCell -> cells.push(
                                    new Tuple(
                                            nextCell,
                                            pair.getValue1()
                                    )
                            )
                    );

            visited[pair.getValue1().getVerticalIndex()][pair.getValue1().getHorizontalIndex()] += 1;
        }

        return false;
    }
}
