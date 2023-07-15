"""
https://leetcode.com/problems/can-place-flowers/?
"""

from typing import List


class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        flowerbed.insert(0, 0)
        flowerbed.append(0)
        empty_beds = 0
        for ending_index in range(2, len(flowerbed)):
            starting_index = ending_index - 2
            middle_index = ending_index - 1

            if 0 == sum([flowerbed[starting_index], flowerbed[middle_index], flowerbed[ending_index]]):
                empty_beds += 1
                flowerbed[middle_index] = 1

        return empty_beds >= n
