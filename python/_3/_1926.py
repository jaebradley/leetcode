from collections import deque
from typing import List


class Solution:
    NEXT_CELLS = {(0, 1), (1, 0), (-1, 0), (0, -1)}
    """
    BFS until first exit is found (where column or row value is 0 and the row and column indices do not match the entrance).
    If queue is exhausted, then return -1.
    """

    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        start = (entrance[0], entrance[1])
        q = deque([start])
        row_count = len(maze)
        column_count = len(maze[0])

        steps = 0
        while q:
            level_count = len(q)
            for _ in range(level_count):
                cell = q.popleft()
                (row_index, column_index) = cell
                if (0 == row_index or (row_count - 1) == row_index or 0 == column_index or (
                        column_count - 1) == column_index) and cell != start:
                    return steps

                for (next_cell_row_index_modifier, next_cell_column_index_modifier) in Solution.NEXT_CELLS:
                    next_row_index = row_index + next_cell_row_index_modifier
                    next_column_index = column_index + next_cell_column_index_modifier
                    if 0 <= next_row_index < row_count and 0 <= next_column_index < column_count and "." == \
                            maze[next_row_index][next_column_index]:
                        next_cell = (next_row_index, next_column_index)
                        maze[next_row_index][next_column_index] = "+"
                        q.append(next_cell)

            steps += 1

        return -1
