package problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * Example 3:
 *
 * Input: m = 7, n = 3
 * Output: 28
 * Example 4:
 *
 * Input: m = 3, n = 3
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 109.
 *
 * Approach:
 *
 * 1. Create an m by n matrix
 * 2. The values at m = 0 and n = 0 are 1
 * 3. For values m = 1 and n = 1, the count at the cell is the sum of the values above and to the left of the cell
 * 4. The count at the bottom-right cell should be the total number of ways to reach that cell
 */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        final int[][] counts = new int[m][n];

        Arrays.fill(counts[0], 1);

        for (int i = 0; i < counts.length; i++) {
            counts[i][0] = 1;
        }

        for (int y = 1; y < counts.length; y++) {
            for (int x = 1; x < counts[y].length; x++) {
                counts[y][x] = counts[y - 1][x] + counts[y][x - 1];
            }
        }

        return counts[counts.length - 1][counts[counts.length - 1].length - 1];
    }
}
