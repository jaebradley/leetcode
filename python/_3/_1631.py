"""
You are a hiker preparing for an upcoming hike.
You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col).
You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).
You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Example 1:
Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

Example 2:
Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

Example 3:
Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.

Constraints:

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
"""
import heapq
import math
from typing import List


class Solution:
    """
    Minimize the sum of absolute differences in heights amongst all visited cells.

    Data:
    Priority queue of (minimum absolute difference, current cell).
    Cells by minimum absolute difference mapping: HashMap<Cell, Integer>
    Set of visited cells.

    Algorithm:
    Pop off the priority queue. This should be the smallest absolute difference value path (so far).
    Add the cell to the visited set.
    Iterate over all unvisited adjacent neighbor cells.
    Next maximum absolute difference is maximum of
    1. Existing minimum difference for the current cell, or infinity if no value has been stored for the current cell
    2. Absolute value difference between current cell and height of adjacent cell
    If the next maximum absolute difference is less than the existing minimum difference for the next cell, replace
    the existing minimum difference with the smaller maximum absolute difference and add the smaller maximum absolute
    distance and the adjacent cell to the priority queue.

    Time complexity: O(# of cells x log(# of cells))
    Space complexity: O(# of cells)
    """

    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        minimum_difference_by_cell = dict()
        minimum_difference_by_cell[(0, 0)] = 0
        visited = set()
        q = [(0, (0, 0))]
        while q:
            minimum_difference, current_cell = heapq.heappop(q)
            visited.add(current_cell)

            current_row_index, current_column_index = current_cell
            current_cell_value = heights[current_row_index][current_column_index]

            for next_row_index_modifier, next_column_index_modifier in ((0, 1), (1, 0), (-1, 0), (0, -1)):
                next_row_index = current_row_index + next_row_index_modifier
                next_column_index = current_column_index + next_column_index_modifier

                if 0 <= next_row_index < len(heights) and 0 <= next_column_index < len(heights[next_row_index]) and (
                        next_row_index, next_column_index) and (next_row_index, next_column_index) not in visited:
                    next_difference = max(
                        abs(current_cell_value - heights[next_row_index][next_column_index]),
                        minimum_difference_by_cell.get((current_row_index, current_column_index), math.inf)
                    )
                    if next_difference < minimum_difference_by_cell.get((next_row_index, next_column_index),
                                                                        math.inf):
                        minimum_difference_by_cell[(next_row_index, next_column_index)] = next_difference
                        heapq.heappush(q, (next_difference, (next_row_index, next_column_index)))

        return minimum_difference_by_cell[(len(heights) - 1, len(heights[0]) - 1)]
