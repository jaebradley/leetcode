package problems;

/**
 https://leetcode.com/problems/minimum-path-sum/description/

 * algorithms
 * Medium (41.45%)
 * Total Accepted:    159.5K
 * Total Submissions: 381.4K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'

 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example:


 Input:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 Output: 7
 Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/

public class MinimumPathSum {
    /**
     * DP solution: the minimum sum at (i, j) is the value at grid[i, j] + min(sum[i][j - 1]), sum[i - 1][j]) taking
     * into account when j = 0 and i = 0
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[][] sums = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int cell = grid[i][j];
                int value;
                if (i == 0 && j == 0) {
                    value = cell;
                } else if (i <= 0) {
                    value = cell + sums[i][j - 1];
                } else if (j <= 0) {
                    value = cell + sums[i - 1][j];
                } else {
                    value = cell + Math.min(sums[i][j - 1], sums[i - 1][j]);
                }
                sums[i][j] = value;
            }
        }

        return sums[grid.length - 1][grid[grid.length - 1].length - 1];
    }
}
