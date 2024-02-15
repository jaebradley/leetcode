import math
from typing import List


class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        result = []
        sorted_minimum_acceptable_spell_for_potion = sorted(list(map(lambda potion: potion / success, potions)))

        for spell in spells:
            result.append(1 + self.helper(sorted_minimum_acceptable_spell_for_potion, spell))

        return result

    def helper(self, minimum_acceptable_spells: List[int], target: int):
        top_index = len(minimum_acceptable_spells) - 1
        bottom_index = 0

        while top_index > bottom_index:
            midpoint_index = math.floor((top_index + bottom_index) / 2)
            midpoint_value = minimum_acceptable_spells[midpoint_index]
            if target == midpoint_value:
                while midpoint_index > 0 and midpoint_value >= target:
                    midpoint_index -= 1
                    midpoint_value = minimum_acceptable_spells[midpoint_index]

                return midpoint_index if midpoint_value < target else -1

            if target > midpoint_value:
                bottom_index = midpoint_index + 1
            elif target < midpoint_value:
                top_index = midpoint_index - 1

        return top_index
