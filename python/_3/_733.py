from collections import deque
from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        row_count = len(image)
        column_count = len(image[0])
        starting_node_value = image[sr][sc]
        seen_coordinates = set()
        q = deque([(sr, sc)])
        while q:
            (current_row_index, current_column_index) = q.popleft()
            seen_coordinates.add((current_row_index, current_column_index))
            if starting_node_value == image[current_row_index][current_column_index]:
                image[current_row_index][current_column_index] = color

                for (next_row_modifier, next_column_modifier) in [
                    (-1, 0),
                    (1, 0),
                    (0, -1),
                    (0, 1)
                ]:
                    next_row_index = current_row_index + next_row_modifier
                    next_column_index = current_column_index + next_column_modifier
                    if 0 <= next_row_index < row_count and 0 <= next_column_index < column_count and (
                    next_row_index, next_column_index) not in seen_coordinates:
                        q.append((next_row_index, next_column_index))
                        seen_coordinates.add((next_row_index, next_column_index))

        return image
