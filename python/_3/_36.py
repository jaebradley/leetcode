"""
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
"""
from collections import defaultdict
from typing import List


class Solution:
    """
    Only filled cells need to be validated.
    Rows and columns cannot contain duplicates.
    3x3 cells must also not contain duplicates.
    Set of digits by row index: Dict[RowIndex, Set[ColumnIndex]]
    Set of digits by column index: Dict[ColumnIndex, Set[RowIndex]]
    Set of digits by grid index: Dict[GridIndex, Set[GridIndex]]

    Iterate over each cell.
    Check if the cell's value already exists in the row, column or grid sets. Will need to calculate the grid set from
    the row + column index.
    Add the cell's value to the appropriate row + column + grid digits.
    If no duplicate cells are found, then the board is valid. Return True.

    Runtime: O(# of cells)
    Space: O(# of filled cells)

    Calculating grid set:
    0: (0, 0) to (2, 2) (row index // 3 = 0 and column index // 3 = 0)
    1: (0, 3) to (2, 5) (row index // 3 = 0 and column index // 3 = 1)
    2: (0, 6) to (2, 8) (row index // 3 = 0 and column index // 3 = 2)
    So the key for grid sets is (row index // 3, column index // 3)
    """

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        values_by_row_index = defaultdict(set)
        values_by_column_index = defaultdict(set)
        values_by_grid_set = defaultdict(set)

        for row_index, row in enumerate(board):
            for column_index, cell_value in enumerate(row):
                if cell_value != '.':
                    grid_set = row_index // 3, column_index // 3
                    if cell_value in values_by_row_index[row_index] \
                            or cell_value in values_by_column_index[column_index] \
                            or cell_value in values_by_grid_set[grid_set]:
                        return False

                    values_by_row_index[row_index].add(cell_value)
                    values_by_column_index[column_index].add(cell_value)
                    values_by_grid_set[grid_set].add(cell_value)

        return True
