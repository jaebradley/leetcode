package problems._1277;

public class Solution {
    public int countSquares(int[][] matrix) {
        int count = 0;
        final int[][] counts = new int[matrix.length][matrix[0].length];

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex += 1) {
            final int[] row = matrix[rowIndex];

            for (int columnIndex = 0; columnIndex < row.length; columnIndex += 1) {
                final int cell = row[columnIndex];

                if (0 == rowIndex || 0 == columnIndex) {
                    counts[rowIndex][columnIndex] = cell;
                    count += cell;
                } else if (1 == cell) {
                    final int cellCount = Math.min(
                            counts[rowIndex - 1][columnIndex],
                            Math.min(
                                    counts[rowIndex - 1][columnIndex - 1],
                                    counts[rowIndex][columnIndex - 1]
                            )
                    ) + 1;

                    counts[rowIndex][columnIndex] = cellCount;
                    count += cellCount;
                }
            }
        }

        return count;
    }
}