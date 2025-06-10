import heapq
from typing import List


class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        columns_count, rows_count = len(moveTime[0]), len(moveTime)
        times = [
            [10 ** 10] * columns_count
            for _ in range(rows_count)
        ]
        times[0][0] = 0
        q = []
        heapq.heappush(q, (0, 0, 0))
        while q:
            time, row_index, column_index = heapq.heappop(q)
            if row_index != rows_count or column_index != columns_count:

                for row_index_modifier, column_index_modifier in ((-1, 0), (1, 0), (0, 1), (0, -1)):
                    next_row_index = row_index + row_index_modifier
                    next_column_index = column_index + column_index_modifier
                    if 0 <= next_row_index < rows_count and 0 <= next_column_index < columns_count:
                        next_cell_time = max(
                            time,
                            moveTime[next_row_index][next_column_index]
                        ) + 1
                        if next_cell_time < times[next_row_index][next_column_index]:
                            times[next_row_index][next_column_index] = next_cell_time
                            heapq.heappush(q, (next_cell_time, next_row_index, next_column_index))

        return times[-1][-1]
