package problems;

/**
 * https://leetcode.com/problems/number-of-islands/description/

 * algorithms
 * Medium (36.54%)
 * Total Accepted:    171.7K
 * Total Submissions: 468.7K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'

 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:
 11110110101100000000
 Answer: 1
 Example 2:
 11000110000010000011
 Answer: 3

 Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.
 */

public class NumberOfIslands {
    /**
     * If there's a land cell, it indicates that there's an island.
     * By "drowning" (aka changing to 0) all connected land cells, avoid potentially "double-counting" land cells
     * as iterate through each cell on grid
     */

    public static int numIslands(char[][] grid) {
        int islandCount = 0;

        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            char[] row = grid[rowIndex];
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                char cell = row[columnIndex];
                if (cell == '1') {
                    islandCount++;
                    drownIslands(rowIndex, columnIndex, grid);
                }
            }
        }

        return islandCount;

    }

    private static boolean invalidCoordinate(int x, int y, char[][] grid) {
        return x < 0 || y < 0 || x > grid.length - 1 || y > grid[x].length - 1;
    }

    private static void drownIslands(int x, int y, char[][] grid) {
        if (invalidCoordinate(x, y, grid) || grid[x][y] != '1') {
            return;
        }

        grid[x][y] = '0';

        drownIslands(x - 1, y, grid);
        drownIslands(x + 1, y, grid);
        drownIslands(x, y - 1, grid);
        drownIslands(x, y + 1, grid);
    }
}
