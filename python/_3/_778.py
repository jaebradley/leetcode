import heapq
from typing import List, Tuple, Mapping

"""
You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any cell with elevation less than equal to t is submerged or reachable.

You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

Example 1:
Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.

Example 2:
Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 50
0 <= grid[i][j] < n2
Each value grid[i][j] is unique.
"""


class UnionFindSolution:
    """
    Each cell is its own parent.
    The cell's value is considered its weight.
    Sort the cell's weights.
    Starting with the smallest weighted cell, process the cell and any neighboring cells that have been visited before.
    Cells with smaller weights will have been visited before.
    If the neighboring cells have been visited then union the neighboring cell with the current cell.
    On each iteration of the loop, check to see if the first and last cells are in the same connected component.
    If they aren't, process the next cell.
    """

    class UnionFind:
        def __init__(self, cells: List[Tuple[int, int]]):
            self.parents_by_cell: Mapping[Tuple[int, int], Tuple[int, int]] = dict(
                map(lambda cell: [cell, cell], cells))

        def find_parent(self, cell: Tuple[int, int]) -> Tuple[int, int]:
            parent = self.parents_by_cell[cell]
            if parent != cell:
                self.parents_by_cell[cell] = self.find_parent(parent)

            return self.parents_by_cell[cell]

        def union(self, cell1: Tuple[int, int], cell2: Tuple[int, int]) -> None:
            cell1_parent, cell2_parent = self.find_parent(cell1), self.find_parent(cell2)
            self.parents_by_cell[cell2_parent] = cell1_parent

    def swimInWater(self, grid: List[List[int]]) -> int:
        cells_sorted_by_weight = []
        cells = []
        for row_index, row in enumerate(grid):
            for column_index, cell in enumerate(row):
                cells.append((row_index, column_index))
                cells_sorted_by_weight.append((cell, row_index, column_index))

        cells_sorted_by_weight.sort(key=lambda cell: cell[0])

        uf = UnionFindSolution.UnionFind(cells)
        visited_cells = set()
        for weight, current_cell_row_index, current_cell_column_index in cells_sorted_by_weight:
            if (current_cell_row_index, current_cell_column_index) not in visited_cells:
                visited_cells.add((current_cell_row_index, current_cell_column_index))

                for row_modification, column_modification in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                    next_row_index, next_column_index = current_cell_row_index + row_modification, current_cell_column_index + column_modification
                    if 0 <= next_row_index < len(grid) \
                            and 0 <= next_column_index < len(grid[next_row_index]) \
                            and (next_row_index, next_column_index) in visited_cells:
                        uf.union((current_cell_row_index, current_cell_column_index),
                                 (next_row_index, next_column_index))

                if uf.find_parent((0, 0)) == uf.find_parent((len(grid) - 1, len(grid[0]) - 1)):
                    return grid[current_cell_row_index][current_cell_column_index]

        raise ValueError("Should never get here")


class HeapSolution:
    """
    Keep a min-heap of the cell values seen for the possible cells visited.
    Keep a set of all visited cells.

    Starting with (0,0), BFS through all possible adjacent cells. Keep track of the maximum value between the largest
    minimum level seen up to that point OR the current cell's value.

    Push this maximum value to the min-heap and pop the next minimum level seen from the heap. Eventually, the minimum
    value in the min-heap should also contain the last grid cell. The minimum level seen associated with the last grid
    cell is the minimum water level to wait until the last grid cell is reachable.

    Runtime: O(# of grid cells x # of grid cells x log(# of grid cells))
    In worst case, add adjacent grid cells multiple times before processing them off the queue. Each additional grid
    cell calls the heapify operation, which is logarithmic.
    Space: O(# of grid cells x # of grid cells)
    """

    def swimInWater(self, grid: List[List[int]]) -> int:
        pq = [(grid[0][0], 0, 0)]
        visited = set()
        while pq:
            largest_minimum_level_seen, row_index, column_index = heapq.heappop(pq)
            if (row_index, column_index) not in visited:
                visited.add((row_index, column_index))
                if row_index == len(grid) - 1 and column_index == len(grid[row_index]) - 1:
                    return largest_minimum_level_seen

                for row_index_modifier, column_index_modifier in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                    next_row_index, next_column_index = row_index_modifier + row_index, column_index_modifier + column_index
                    if 0 <= next_row_index < len(grid) and 0 <= next_column_index < len(grid[next_row_index]):
                        next_max_level = max(largest_minimum_level_seen, grid[next_row_index][next_column_index])
                        heapq.heappush(pq, (next_max_level, next_row_index, next_column_index))

        raise ValueError("Should never reach here")
