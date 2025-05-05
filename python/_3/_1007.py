from typing import List


class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        value_count = len(tops)

        def helper(target):
            top_rotations, bottom_rotations = 0, 0
            for current_index in range(value_count):
                top_value, bottom_value = tops[current_index], bottoms[current_index]
                if top_value != target and bottom_value != target:
                    return -1

                if top_value != target:
                    top_rotations += 1
                elif bottom_value != target:
                    bottom_rotations += 1

            return min(top_rotations, bottom_rotations)

        rotations = helper(tops[0])
        if rotations != -1:
            return rotations

        return helper(bottoms[0])
