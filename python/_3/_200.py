"""
https://leetcode.com/problems/number-of-islands/
"""

from typing import List


class DfsSolution:
    """
    Islands are land ("1") surrounded by water ("0").

    Islands are directly connected components of land.

    To identify directly connected components using DFS, can DFS for a given node.

    For each subsequent land node that has not yet been identified / visited, increment the island count
    and DFS that node.

    Number of islands is the island count after DFSing all nodes.
    """

    def numIslands(self, grid: List[List[str]]) -> int:
        island_count = 0
        visited_nodes = set([])

        for row_index, row in enumerate(grid):
            for column_index, element in enumerate(grid[row_index]):
                if "1" == element:
                    if (row_index, column_index) not in visited_nodes:
                        island_count += 1
                        self.dfs(row_index, column_index, grid, visited_nodes)

        return island_count

    def dfs(self, row_index, column_index, grid, visited_nodes):
        if (row_index, column_index) not in visited_nodes:
            visited_nodes.add((row_index, column_index))

            minimum_next_row_index = max(0, row_index - 1)
            maximum_next_row_index = min(row_index + 2, len(grid))
            for next_row_index in range(minimum_next_row_index, maximum_next_row_index):
                if "1" == grid[next_row_index][column_index]:
                    self.dfs(next_row_index, column_index, grid, visited_nodes)

            minimum_next_column_index = max(0, column_index - 1)
            maximum_next_column_index = min(column_index + 2, len(grid[row_index]))
            for next_column_index in range(minimum_next_column_index, maximum_next_column_index):
                if "1" == grid[row_index][next_column_index]:
                    self.dfs(row_index, next_column_index, grid, visited_nodes)
