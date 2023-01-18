package problems._931;

import java.util.Arrays;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        final int[][] values = new int[matrix.length][matrix[0].length];
        values[0] = Arrays.copyOf(matrix[0], matrix[0].length);
        for (int i = 1; i < matrix.length; i += 1) {
            final int[] row = matrix[i];
            for (int j = 0; j < row.length; j += 1) {
                values[i][j] = calculateMinimumSurroundingValue(values, i - 1,  j) + row[j];
            }
        }

        int minimumSum = Integer.MAX_VALUE;
        {
            for (final int value : values[values.length - 1]) {
                minimumSum = Math.min(value, minimumSum);
            }
        }

        return minimumSum;
    }

    private static int calculateMinimumSurroundingValue(final int[][] values, final int rowIndex, final int columnIndex) {
        int minimumValue = Integer.MAX_VALUE;
        for (int i = Math.max(0, columnIndex - 1); i < Math.min(values[rowIndex].length, columnIndex + 2); i += 1) {
            minimumValue = Math.min(values[rowIndex][i], minimumValue);
        }

        return minimumValue;
    }

}
