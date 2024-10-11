class Solution:
    """
    The idea is that you really only need to know the previous row's unique paths to calculate the next row's unique
    paths.

    The unique paths for a given cell is the number of unique paths to the cell directly above the cell
    (current row[row index - 1][column index]) + the number of unique paths to the cell directly to the left
    of the current cell (current row[row index][column index - 1]).

    Have to take into account the first cell not having a cell to its left, and need to initialize the first row as all
    1 (there is a single unique path to get to all the cells in the first row).

    The last element of the last row should be the number of unique paths to reach the "bottom-right corner".
    """

    def uniquePaths(self, m: int, n: int) -> int:
        current_row = [1] * (n + 1)

        for row in range(m - 1):
            next_row = [0] * (n + 1)
            for column in range(1, n + 1):
                next_row[column] = current_row[column] + next_row[column - 1]
            current_row = next_row

        return current_row[-1]
