"""
There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return the shortest distance for the ball to stop at the destination. If the ball cannot stop at destination, return -1.
The distance is the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included).
You may assume that the borders of the maze are all walls (see examples).

Example 1:
Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
Output: 12
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
The length of the path is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

Example 2:
Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
Output: -1
Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.

Example 3:
Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]
Output: -1

Constraints:

m == maze.length
n == maze[i].length
1 <= m, n <= 100
maze[i][j] is 0 or 1.
start.length == 2
destination.length == 2
0 <= startrow, destinationrow < m
0 <= startcol, destinationcol < n
Both the ball and the destination exist in an empty space, and they will not be in the same position initially.
The maze contains at least 2 empty spaces.
"""
import heapq
import sys
from typing import List


class Solution:
    class TravelDistance:
        def __init__(self, distance: int, row_index: int, column_index: int):
            self.distance = distance
            self.row_index = row_index
            self.column_index = column_index

    """
    Approach:
    Execute Dijkstra's algorithm to find the shortest distance in the maze.
    Iterate over the maze, and set each cell as having an infinite distance initially (use sys.maxsize), in a dictionary.
    Set the starting cell distance to 0. Add the starting cell + distance to a min-heap priority queue.
    While the priority queue is not empty:
        Pop the cell with the smallest distance from the priority queue.
        For each of the four possible directions (up, down, left, right):
            Roll the ball in that direction until it hits a wall, counting the distance traveled.
            If the new distance to the stopping cell is less than the previously recorded distance:
                Update the distance in the dictionary.
                Add the stopping cell + new distance to the priority queue.
    After processing all reachable cells, check the distance to the destination cell.
    If it is still infinite, return -1. Otherwise, return the recorded distance.
    """

    def shortestDistance(self, maze: List[List[int]], start: List[int], destination: List[int]) -> int:
        def calculate_rolling_distances(row_index: int, column_index: int):
            left_travel_distance = Solution.TravelDistance(distance=0, row_index=row_index, column_index=column_index)
            while (left_travel_distance.column_index - 1) >= 0 and maze[left_travel_distance.row_index][
                left_travel_distance.column_index - 1] == 0:
                left_travel_distance.distance += 1
                left_travel_distance.column_index -= 1

            right_travel_distance = Solution.TravelDistance(distance=0, row_index=row_index, column_index=column_index)
            while (right_travel_distance.column_index + 1) < len(maze[row_index]) and \
                    maze[right_travel_distance.row_index][
                        right_travel_distance.column_index + 1] == 0:
                right_travel_distance.distance += 1
                right_travel_distance.column_index += 1

            up_travel_distance = Solution.TravelDistance(distance=0, row_index=row_index, column_index=column_index)
            while (up_travel_distance.row_index - 1) >= 0 and maze[up_travel_distance.row_index - 1][
                up_travel_distance.column_index] == 0:
                up_travel_distance.distance += 1
                up_travel_distance.row_index -= 1

            down_travel_distance = Solution.TravelDistance(distance=0, row_index=row_index, column_index=column_index)
            while (down_travel_distance.row_index + 1) < len(maze) and maze[down_travel_distance.row_index + 1][
                down_travel_distance.column_index] == 0:
                down_travel_distance.distance += 1
                down_travel_distance.row_index += 1

            return list(filter(lambda td: td.distance > 0, [
                left_travel_distance,
                right_travel_distance,
                up_travel_distance,
                down_travel_distance
            ]))

        distances_by_node = {}
        distances = []
        for row_index, row in enumerate(maze):
            for column_index, cell in enumerate(row):
                if cell == 0:
                    distances.append((sys.maxsize, row_index, column_index))
                    distances_by_node[(row_index, column_index)] = sys.maxsize

        distances.append((0, start[0], start[1]))
        distances_by_node[(start[0], start[1])] = 0

        heapq.heapify(distances)

        while distances:
            smallest_distance, start_row, start_column = heapq.heappop(distances)
            rolling_distances = calculate_rolling_distances(start_row, start_column)
            for travel_distance in rolling_distances:
                combined_distance = smallest_distance + travel_distance.distance
                if distances_by_node[(travel_distance.row_index, travel_distance.column_index)] > combined_distance:
                    distances_by_node[(travel_distance.row_index, travel_distance.column_index)] = combined_distance
                    heapq.heappush(distances,
                                   (combined_distance, travel_distance.row_index, travel_distance.column_index))

        destination_distance = distances_by_node[(destination[0], destination[1])]
        if destination_distance == sys.maxsize:
            return -1
        return destination_distance
