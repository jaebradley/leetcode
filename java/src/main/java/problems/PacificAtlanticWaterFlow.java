package problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * <p>
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * <p>
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * Note:
 * <p>
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * <p>
 * <p>
 * Example:
 * <p>
 * Given the following 5x5 matrix:
 * <p>
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * Atlantic
 * <p>
 * Return:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 * <p>
 * Approach:
 * <p>
 * 1. Start by putting all pacific cells into one queue and all the atlantic cells into another queue
 * 2. Iterate through queue, keeping track of visited cells - only add cells to the queue if they have a value that is
 * equal to or greater than the current value
 * 3. Compare visited cells between pacific and atlantic
 */

public class PacificAtlanticWaterFlow {
    private static class Cell {
        private final int x;
        private final int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        final Set<Cell> pacificBorderCells = new HashSet<>();
        final Set<Cell> atlanticBorderCells = new HashSet<>();

        for (int row = 0; row < matrix.length; row++) {
            pacificBorderCells.add(new Cell(0, row));
            atlanticBorderCells.add(new Cell(matrix[row].length - 1, row));
        }

        for (int column = 0; column < matrix[0].length; column++) {
            pacificBorderCells.add(new Cell(column, 0));
            atlanticBorderCells.add(new Cell(column, matrix.length - 1));
        }

        final Set<Cell> visitedFromPacific = calculateVisitedCells(pacificBorderCells, matrix);
        final Set<Cell> visitedFromAtlantic = calculateVisitedCells(atlanticBorderCells, matrix);

        return visitedFromPacific
                .stream()
                .filter(visitedFromAtlantic::contains)
                .map(
                        v -> List.of(v.y, v.x)
                )
                .collect(Collectors.toList());
    }

    private Set<Cell> calculateVisitedCells(final Set<Cell> initialCells, final int[][] matrix) {
        final int height = matrix.length;
        final int length = matrix[matrix.length - 1].length;

        final Set<Cell> visited = new HashSet<>();

        final Queue<Cell> cellsToVisit = new LinkedList<>(initialCells);

        while (!cellsToVisit.isEmpty()) {
            final Cell currentCell = cellsToVisit.poll();
            if (!visited.contains(currentCell)) {
                visited.add(currentCell);
                final int currentValue = matrix[currentCell.y][currentCell.x];

                if (0 < currentCell.y) {
                    if (matrix[currentCell.y - 1][currentCell.x] >= currentValue) {
                        cellsToVisit.add(new Cell(currentCell.x, currentCell.y - 1));
                    }
                }

                if (0 < currentCell.x) {
                    if (matrix[currentCell.y][currentCell.x - 1] >= currentValue) {
                        cellsToVisit.add(new Cell(currentCell.x - 1, currentCell.y));
                    }
                }

                if (length - 1 > currentCell.x) {
                    if (matrix[currentCell.y][currentCell.x + 1] >= currentValue) {
                        cellsToVisit.add(new Cell(currentCell.x + 1, currentCell.y));
                    }
                }

                if (height - 1 > currentCell.y) {
                    if (matrix[currentCell.y + 1][currentCell.x] >= currentValue) {
                        cellsToVisit.add(new Cell(currentCell.x, currentCell.y + 1));
                    }
                }
            }
        }

        return visited;
    }
}
