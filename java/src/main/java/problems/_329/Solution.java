package problems._329;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    private static class Cell {
        private final int horizontalIndex;
        private final int verticalIndex;
        private final int value;

        public Cell(int horizontalIndex, int verticalIndex, int value) {
            this.horizontalIndex = horizontalIndex;
            this.verticalIndex = verticalIndex;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return horizontalIndex == cell.horizontalIndex && verticalIndex == cell.verticalIndex && value == cell.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(horizontalIndex, verticalIndex, value);
        }
    }

    public int longestIncreasingPath(int[][] matrix) {
        final Map<Cell, Set<Cell>> adjacencyList = buildAdjacencyList(matrix);
        final Map<Cell, Integer> longestPathsByCell = new HashMap<>();
        int maxPathLength = 1;
        for (final Cell currentCell : adjacencyList.keySet()) {
            if (!longestPathsByCell.containsKey(currentCell)) {
                maxPathLength = Math.max(
                        dfs(currentCell, adjacencyList, longestPathsByCell),
                        maxPathLength
                );
            }
        }
        return maxPathLength;
    }

    private static Map<Cell, Set<Cell>> buildAdjacencyList(int[][] matrix) {
        final Map<Cell, Set<Cell>> adjacencyList = new HashMap<>();
        for (int verticalIndex = 0; verticalIndex < matrix.length; verticalIndex += 1) {
            for (int horizontalIndex = 0; horizontalIndex < matrix[verticalIndex].length; horizontalIndex += 1) {
                adjacencyList.put(
                        new Cell(
                                horizontalIndex,
                                verticalIndex,
                                matrix[verticalIndex][horizontalIndex]
                        ),
                        identifyLargerNeighbors(matrix, verticalIndex, horizontalIndex)
                );
            }
        }
        return adjacencyList;
    }

    private static Set<Cell> identifyLargerNeighbors(int[][] matrix, int verticalIndex, int horizontalIndex) {
        final int cellValue = matrix[verticalIndex][horizontalIndex];
        return IntStream.rangeClosed(-1, 1)
                .boxed()
                .filter(v -> 0 != v)
                .flatMap(
                        v -> Stream.of(
                                new int[]{verticalIndex + v, horizontalIndex},
                                new int[]{verticalIndex, horizontalIndex + v}
                        )
                )
                .filter(
                        v -> 0 <= v[0] && 0 <= v[1]
                )
                .filter(
                        v -> matrix.length > v[0] && matrix[0].length > v[1]
                )
                .filter(
                        v -> matrix[v[0]][v[1]] > cellValue
                )
                .map(
                        v -> new Cell(
                                v[1],
                                v[0],
                                matrix[v[0]][v[1]]
                        )
                )
                .collect(Collectors.toSet());
    }

    private static int dfs(
            final Cell currentCell,
            final Map<Cell, Set<Cell>> adjacencyList,
            final Map<Cell, Integer> longestPathsByCell
    ) {
        if (longestPathsByCell.containsKey(currentCell)) {
            return longestPathsByCell.get(currentCell);
        }

        final int maxPath = adjacencyList
                .getOrDefault(currentCell, Collections.emptySet())
                .stream()
                .map(
                        neighbor -> dfs(neighbor, adjacencyList, longestPathsByCell)
                )
                .max(
                        Comparator.comparingInt(v -> v)
                )
                .orElse(0);

        longestPathsByCell.put(
                currentCell,
                1 + maxPath
        );

        return 1 + maxPath;
    }
}
