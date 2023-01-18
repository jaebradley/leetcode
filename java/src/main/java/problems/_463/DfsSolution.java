package problems._463;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class DfsSolution {
    private static class Cell {
        public final int horizontalCoordinate;
        public final int verticalCoordinate;

        public Cell(final int horizontalIndex, final int verticalIndex) {
            this.horizontalCoordinate = horizontalIndex;
            this.verticalCoordinate = verticalIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return horizontalCoordinate == cell.horizontalCoordinate && verticalCoordinate == cell.verticalCoordinate;
        }

        @Override
        public int hashCode() {
            return Objects.hash(horizontalCoordinate, verticalCoordinate);
        }
    }

    private static final Set<Cell> adjacentCoordinates = Set.of(
            new Cell(0, -1),
            new Cell(-1, 0),
            new Cell(0, 1),
            new Cell(1, 0)
    );

    public int islandPerimeter(int[][] grid) {
        final AtomicInteger perimeter = new AtomicInteger(0);
        final Set<Cell> visitedCells = new HashSet<>();
        for (int verticalIndex = 0; verticalIndex < grid.length; verticalIndex += 1) {
            final int[] row = grid[verticalIndex];
            for (int horizontalIndex = 0; horizontalIndex < row.length; horizontalIndex += 1) {
                final int cellValue = row[horizontalIndex];
                if (1 == cellValue) {
                    final Cell cell = new Cell(verticalIndex, horizontalIndex);
                    if (!visitedCells.contains(cell)) {
                        visit(cell, perimeter, row.length, grid.length, grid, visitedCells);
                    }
                }
            }
        }
        return perimeter.get();
    }

    private static void visit(final Cell cell, final AtomicInteger perimeter, final int maxHeight, final int maxWidth, final int[][] grid, final Set<Cell> visitedCells) {
        if (!visitedCells.contains(cell)) {
            visitedCells.add(cell);

            for (final Cell adjacentCoordinate : adjacentCoordinates) {
                final int nextHorizontalCoordinate = cell.horizontalCoordinate + adjacentCoordinate.horizontalCoordinate;
                if (maxWidth > nextHorizontalCoordinate && 0 <= nextHorizontalCoordinate) {
                    final int nextVerticalCoordinate = cell.verticalCoordinate + adjacentCoordinate.verticalCoordinate;
                    if (maxHeight > nextVerticalCoordinate && 0 <= nextVerticalCoordinate) {
                        final int nextCellValue = grid[nextHorizontalCoordinate][nextVerticalCoordinate];
                        if (0 == nextCellValue) {
                            perimeter.incrementAndGet();
                        } else {
                            visit(new Cell(nextHorizontalCoordinate, nextVerticalCoordinate), perimeter, maxHeight, maxWidth, grid, visitedCells);
                        }
                    } else {
                        perimeter.incrementAndGet();
                    }
                } else {
                    perimeter.incrementAndGet();
                }
            }

        }
    }

}
