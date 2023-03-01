"""
https://leetcode.com/problems/rotting-oranges/
"""

from collections import deque
from typing import List


class Solution:
    """
    Approach:

    Iterate over the cells and keep track of all the fresh cells.
    For each of the rotten cells, if its neighbors have not already been visited, add the coordinates to the queue.
    If the current cell popped from the queue is a fresh cell, remove the cell from the set of fresh cells.
    Before iterating the next level, check if the set of fresh cells is empty.
    If the set is empty, return the count of levels.
    If the queue is empty this means that not all rotting oranges could be converted, so return -1.
    """

    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = deque([])
        fresh_cells = set([])
        visited_cells = set([])

        for row_index in range(len(grid)):
            for column_index in range(len(grid[row_index])):
                cell_value = grid[row_index][column_index]

                if 2 == cell_value:
                    q.appendleft((row_index, column_index))
                elif 1 == cell_value:
                    fresh_cells.add((row_index, column_index))

        if 0 == len(fresh_cells):
            return 0

        level_count = 0
        while q:
            current_size = len(q)

            for _ in range(current_size):
                current_cell = q.pop()
                visited_cells.add(current_cell)

                if current_cell in fresh_cells:
                    fresh_cells.remove(current_cell)

                    if 0 == len(fresh_cells):
                        return level_count

                for next_cell in [
                    (max(0, current_cell[0] - 1), current_cell[1]),
                    (min(len(grid) - 1, current_cell[0] + 1), current_cell[1]),
                    (current_cell[0], max(0, current_cell[1] - 1)),
                    (current_cell[0], min(len(grid[0]) - 1, current_cell[1] + 1))
                ]:
                    if next_cell not in visited_cells and 0 != grid[next_cell[0]][next_cell[1]]:
                        q.appendleft(next_cell)

            level_count += 1

        return -1
