from collections import deque
from typing import List

"""
You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

 

Example 1:


Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
Example 2:

Input: rooms = [[-1]]
Output: [[-1]]
 

Constraints:
m == rooms.length
n == rooms[i].length
1 <= m, n <= 250
rooms[i][j] is -1, 0, or 231 - 1.
"""


class Solution:
    """
    Iterate over all rooms and identify gates. O(# of cells)
    BFS starting from gates. Go to cells in four cardinal directions.
    Don't visit cell if its in set of visited cells.
    When visiting a cell, overwrite the value with the level-order value.
    """

    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        infinity = 2147483647
        q = deque([])
        for row_index, row in enumerate(rooms):
            for column_index, cell in enumerate(row):
                if cell == 0:
                    q.append((row_index, column_index))

        level = 0
        while q:
            for _ in range(len(q)):
                (row_index, column_index) = q.popleft()
                room = rooms[row_index][column_index]
                if room == infinity:
                    rooms[row_index][column_index] = level

                for row_index_modifier, column_index_modifier in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                    next_row_index, next_column_index = row_index + row_index_modifier, column_index + column_index_modifier
                    if 0 <= next_row_index < len(rooms) and 0 <= next_column_index < len(rooms[next_row_index]) and \
                            rooms[next_row_index][next_column_index] == infinity:
                        q.append((next_row_index, next_column_index))

            level += 1
