package problems;

import java.util.*;

/**
 * https://leetcode.com/problems/count-servers-that-communicate/
 *
 * You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.
 *
 * Return the number of servers that communicate with any other server.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: grid = [[1,0],[0,1]]
 * Output: 0
 * Explanation: No servers can communicate with others.
 * Example 2:
 *
 *
 *
 * Input: grid = [[1,0],[1,1]]
 * Output: 3
 * Explanation: All three servers can communicate with at least one other server.
 * Example 3:
 *
 *
 *
 * Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * Output: 4
 * Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 *
 * Approach:
 *
 * 1. Create two arrays that represent the count of servers at a given row or column index
 * 2. For each server, increment the total server count
 * 3. Then, iterate through the grid and for each server, if there's only a single matching row and single matching column
 *    decrement the total server count - this means that the server is the only server in that row and column
 */

public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[] rowIndices = new int[grid.length];
        int[] columnIndices = new int[grid[0].length];
        int totalServersCount = 0;

        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    rowIndices[i]++;
                    columnIndices[j]++;
                    totalServersCount++;
                }
            }
        }

        for (int rowIndex = 0; rowIndex < rowIndices.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columnIndices.length; columnIndex++) {
                if (grid[rowIndex][columnIndex] == 1) {
                    if (rowIndices[rowIndex] == 1 && columnIndices[columnIndex] == 1) {
                        totalServersCount--;
                    }
                }
            }
        }

        return totalServersCount;
    }
}
