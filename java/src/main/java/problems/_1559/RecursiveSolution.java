package problems._1559;

public class RecursiveSolution {
    public boolean containsCycle(char[][] grid) {
        final boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int verticalIndex = 0; verticalIndex < grid.length; verticalIndex += 1) {
            for (int horizontalIndex = 0; horizontalIndex < grid[verticalIndex].length; horizontalIndex += 1) {
                if (!visited[verticalIndex][horizontalIndex]) {
                    if (hasCycle(grid, verticalIndex, horizontalIndex, -1, -1, grid[verticalIndex][horizontalIndex], visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean hasCycle(final char[][] grid, final int verticalIndex, final int horizontalIndex, final int previousVerticalIndex, final int previousHorizontalIndex, final char startingCharacter, final boolean[][] visited) {
        if ((verticalIndex == previousVerticalIndex && horizontalIndex == previousHorizontalIndex) || 0 > verticalIndex || 0 > horizontalIndex || grid.length <= verticalIndex || grid[verticalIndex].length <= horizontalIndex) {
            return false;
        }

        if (grid[verticalIndex][horizontalIndex] != startingCharacter) {
            return false;
        }

        if (visited[verticalIndex][horizontalIndex]) {
            return true;
        }

        visited[verticalIndex][horizontalIndex] = true;

        for (int nextVerticalIndexOffset = -1; nextVerticalIndexOffset <= 1; nextVerticalIndexOffset += 1) {
            for (int nextHorizontalIndexOffset = -1; nextHorizontalIndexOffset <= 1; nextHorizontalIndexOffset += 1) {
                final int nextVerticalIndex = verticalIndex + nextVerticalIndexOffset;
                final int nextHorizontalIndex = horizontalIndex + nextHorizontalIndexOffset;
                if ((0 == nextVerticalIndexOffset || 0 == nextHorizontalIndexOffset) && !(0 == nextVerticalIndexOffset && 0 == nextHorizontalIndexOffset) && !(previousVerticalIndex == nextVerticalIndex && previousHorizontalIndex == nextHorizontalIndex)) {
                    if (hasCycle(grid, nextVerticalIndex, nextHorizontalIndex, verticalIndex, horizontalIndex, startingCharacter, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
