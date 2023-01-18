package problems;

/**
 * https://leetcode.com/problems/maximal-square/description/

 * algorithms
 * Medium (30.28%)
 * Total Accepted:    86.7K
 * Total Submissions: 285.4K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'


 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.


 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 Return 4.


 Credits:Special thanks to @Freezen for adding this problem and creating all test cases.
 */

public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length < 1) {
            return 0;
        }

        int maxSquareLength = 0;
        int[][] squareLengths = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 1; i <= matrix.length; i++) {
            char[] row = matrix[i - 1];
            for (int j = 1; j <= row.length; j++) {
                if (row[j - 1] == '1') {
                    int squareLength = Math.min(squareLengths[i][j-1], Math.min(squareLengths[i-1][j-1], squareLengths[i-1][j])) + 1;
                    maxSquareLength = Math.max(maxSquareLength, squareLength);
                    squareLengths[i][j] = squareLength;
                }
            }
        }

        return (int) Math.pow(maxSquareLength, 2);
    }
}
