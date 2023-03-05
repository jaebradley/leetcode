"""
https://leetcode.com/problems/surrounded-regions/description/
"""

from collections import deque
from typing import List


class Solution:
    """
    A region is captured by flipping all 'O's into 'X's in that surrounded region.

    Non-border Os that are surrounded by Xs.
    Compute non-border Os by adding all Os that are

    If a connected component of Os ever 4 directionally touches a border it cannot be captured, otherwise it is capturable.
    For all O cells that are on the border, DFS across these cells for any 4-directionally connected O cells.
    Add any connected cells to a set of cells that should not be modified in-place.
    Iterate over all cells, and modify any cell that is not part of this set in-place.
    """

    def solve(self, board: List[List[str]]) -> None:
        border_cells = set([])
        row_count = len(board)
        for row_index in range(row_count):
            row = board[row_index]
            cell_count = len(row)
            for column_index in range(cell_count):
                cell = row[column_index]
                if 0 == row_index \
                        or (row_count - 1 == row_index) \
                        or 0 == column_index \
                        or (cell_count - 1 == column_index):
                    if cell == 'O':
                        border_cells.add((row_index, column_index))

        uncapturable_cells = set([])
        q = deque(border_cells)
        while q:
            element_count = len(q)
            for _ in range(element_count):
                current_element = q.pop()
                uncapturable_cells.add(current_element)
                (current_element_row_index, current_element_column_index) = current_element
                for index_modification in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                    next_row_index = max(0, min(current_element_row_index + index_modification[0], row_count - 1))
                    next_column_index = max(0, min(current_element_column_index + index_modification[1],
                                                   len(board[next_row_index]) - 1))
                    if "O" == board[next_row_index][next_column_index] \
                            and (next_row_index, next_column_index) not in uncapturable_cells:
                        q.appendleft((next_row_index, next_column_index))

        for row_index in range(row_count):
            row = board[row_index]
            cell_count = len(row)
            for column_index in range(cell_count):
                cell = row[column_index]
                if cell == 'O' and (row_index, column_index) not in uncapturable_cells:
                    board[row_index][column_index] = 'X'
