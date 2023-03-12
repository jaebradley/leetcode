"""
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
"""

from typing import List


class Solution:
    """
    Approach:

    DFS over each cell.
    Evaluate qualifying cells in the four cardinal directions.
    Cache the length for each cell.
    Add length of current path with length of cached cell.
    """

    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        longest_increasing_path = 1
        length_matrix = [[0 for _ in range(len(matrix[row_index]))] for row_index in range(len(matrix))]
        for row_index in range(len(matrix)):
            row = matrix[row_index]

            for column_index in range(len(row)):
                longest_increasing_path = max(longest_increasing_path,
                                              self.dfs(row_index, column_index, matrix, length_matrix))

        return longest_increasing_path

    def dfs(self, row_index: int, column_index: int, matrix: List[List[int]], lengths: List[List[int]]) -> int:
        if 0 == lengths[row_index][column_index]:
            longest_path_length = 1

            for (row_adjustment, column_adjustment) in [
                (0, 1),
                (0, -1),
                (1, 0),
                (-1, 0)
            ]:
                next_row_index = row_index + row_adjustment
                next_column_index = column_index + column_adjustment

                if 0 <= next_row_index < len(matrix) and 0 <= next_column_index < len(matrix[next_row_index]) \
                        and ((next_row_index, next_column_index) != (row_index, column_index)) \
                        and matrix[next_row_index][next_column_index] > matrix[row_index][column_index]:
                    longest_path_length = max(
                        longest_path_length,
                        1 + self.dfs(next_row_index, next_column_index, matrix, lengths))

            lengths[row_index][column_index] = longest_path_length

        return lengths[row_index][column_index]
