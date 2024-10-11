from collections import deque
from typing import List


class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        q = deque([])
        row_count = len(grid)
        column_count = len(grid[0])

        if 0 == grid[0][0]:
            q.appendleft([0, 0, 1])
            grid[0][0] = 1

        while q:
            (row_index, column_index, level) = q.popleft()

            if row_index == row_count - 1 and column_index == column_count - 1:
                return level

            for next_row_index in range(max(0, row_index - 1), min(row_index + 2, row_count)):
                for next_column_index in range(max(0, column_index - 1), min(column_index + 2, column_count)):
                    if 0 == grid[next_row_index][next_column_index]:
                        # setting the level here makes the runtime a lot faster
                        grid[next_row_index][next_column_index] = 1 + level
                        q.append([next_row_index, next_column_index, 1 + level])

        return -1
