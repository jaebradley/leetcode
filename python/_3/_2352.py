from typing import List


class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        columns = [[0] * len(grid) for _ in range(len(grid[0]))]
        row_hashes = {}
        for row_index, row in enumerate(grid):
            hashed_row = str(row)
            count = row_hashes.get(hashed_row, 0)
            row_hashes[hashed_row] = 1 + count
            for column_index, value in enumerate(row):
                columns[column_index][row_index] = value

        pair_counter = 0

        for column in columns:
            hashed_column = str(column)
            hashed_column_count = row_hashes.get(hashed_column, 0)
            pair_counter += hashed_column_count

        return pair_counter
