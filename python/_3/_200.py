"""
https://leetcode.com/problems/number-of-islands/
"""

from collections import deque
from typing import List


class DfsSolution:
    """
    Islands are land ("1") surrounded by water ("0").

    Islands are directly connected components of land.

    To identify directly connected components using DFS, can DFS for a given node.

    For each subsequent land node that has not yet been identified / visited, increment the island count
    and DFS that node.

    Number of islands is the island count after DFSing all nodes.

    Runtime: O(number of nodes) - each node should only be visited once
    Space: O(number of nodes) - each node could be added to the visited nodes set once
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


class UnionFindSolution:
    """
    Iterate over grid and set each node as the parent of itself.
    Calculate the connected components by unioning with the first land node north, east, south, or west.
    Return the distinct counts of parents.
    """

    class UnionFind:
        def __init__(self, nodes):
            self.parents_by_node = dict(map(lambda node: [node, node], range(0, nodes)))

        def find(self, node):
            parent = self.parents_by_node[node]
            if parent == node:
                return node

            parent = self.find(parent)
            self.parents_by_node[node] = parent
            return parent

        def union(self, first, second):
            first_parent = self.find(first)
            second_parent = self.find(second)
            if first_parent != second_parent:
                self.parents_by_node[first_parent] = second_parent
                return True

            return False

    def numIslands(self, grid: List[List[str]]) -> int:
        if 0 == len(grid):
            return 0

        cell_count = len(grid) * len(grid[0])
        union_find = UnionFindSolution.UnionFind(cell_count)
        island_count = 0
        for row_index, row in enumerate(grid):
            for column_index, cell in enumerate(grid[row_index]):
                if "1" == cell:
                    island_count += 1
                    for next_row_index_modifier, next_column_index_modifier in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                        next_row_index = row_index + next_row_index_modifier
                        next_column_index = column_index + next_column_index_modifier
                        if 0 <= next_row_index < len(grid) \
                                and 0 <= next_column_index < len(grid[0]) \
                                and "1" == grid[next_row_index][next_column_index] \
                                and union_find.union(
                            (row_index * len(grid[0])) + column_index,
                            (next_row_index * len(grid[0])) + next_column_index):
                            island_count -= 1

        return island_count


class BfsSolution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited_nodes = set([])
        queue = deque([])
        island_count = 0
        for row_index, row in enumerate(grid):
            for column_index, cell in enumerate(row):
                if "1" == cell and (row_index, column_index) not in visited_nodes:
                    island_count += 1
                    queue.append((row_index, column_index))
                    while 0 < len(queue):
                        coordinates = queue.popleft()
                        if coordinates not in visited_nodes:
                            visited_nodes.add(coordinates)
                            for next_row_index_modifier, next_column_index_modifier in [(-1, 0), (1, 0), (0, -1),
                                                                                        (0, 1)]:
                                next_row_index = coordinates[0] + next_row_index_modifier
                                next_column_index = coordinates[1] + next_column_index_modifier
                                if 0 <= next_row_index < len(grid) \
                                        and 0 <= next_column_index < len(grid[next_row_index]) \
                                        and "1" == grid[next_row_index][next_column_index]:
                                    queue.append((next_row_index, next_column_index))

        return island_count
