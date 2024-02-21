import math
from typing import List


class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        result = []
        sorted_potions = sorted(potions)

        for spell in spells:
            result.append(self.helper(sorted_potions, spell, success))

        return result

    def helper(self, sorted_potions: List[int], current_spell: int, target: int):
        potion_count = len(sorted_potions)
        top_index = potion_count - 1
        bottom_index = 0

        while top_index >= bottom_index:
            midpoint_index = math.floor((top_index + bottom_index) / 2)
            midpoint_value = sorted_potions[midpoint_index] * current_spell

            if target > midpoint_value:
                bottom_index = midpoint_index + 1
            elif target <= midpoint_value:
                top_index = midpoint_index - 1

        return potion_count - (top_index + 1)
