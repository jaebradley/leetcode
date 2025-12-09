"""
https://leetcode.com/problems/ones-and-zeroes/
"""

from typing import List


class Solution:
    """
    For a given string / index, decision of using the string or not using the string (with the hope that a later string
    will produce a better result).
    """

    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        strings = []
        for s in strs:
            counts = {"ones": 0, "zeroes": 0}
            for c in s:
                if c == '1':
                    counts["ones"] += 1
                else:
                    counts["zeroes"] += 1
            strings.append(counts)
        dp = [[[-1 for _ in range(n + 1)] for _ in range(m + 1)] for _ in range(len(strs))]
        return self.helper(dp, strings, 0, m, n)

    def helper(self, stored_calculations, strings, current_index, number_of_remaining_zeroes, number_of_remaining_ones):
        # if at end of strings or no more 0s or 1s, return 0
        if current_index == len(strings) or (number_of_remaining_zeroes == 0 and number_of_remaining_ones == 0):
            return 0

        # if we have already calculated a value, return the calculated value
        current_stored_calculation = stored_calculations[current_index][number_of_remaining_zeroes][
            number_of_remaining_ones]
        if current_stored_calculation != -1:
            return current_stored_calculation

        current_string = strings[current_index]
        # If number of ones or zeroes in current string exceed the existing 1 / 0 limit(s), skip it
        if current_string["ones"] > number_of_remaining_ones or current_string["zeroes"] > number_of_remaining_zeroes:
            result_from_skipping = self.helper(stored_calculations, strings, current_index + 1,
                                               number_of_remaining_zeroes, number_of_remaining_ones)
            stored_calculations[current_index][number_of_remaining_zeroes][
                number_of_remaining_ones] = result_from_skipping
            return result_from_skipping

        # Keep the current string
        include_current_string = 1 + self.helper(stored_calculations, strings, current_index + 1,
                                                 number_of_remaining_zeroes - current_string["zeroes"],
                                                 number_of_remaining_ones - current_string["ones"])
        # Skip current string
        skip_current_string = self.helper(stored_calculations, strings, current_index + 1, number_of_remaining_zeroes,
                                          number_of_remaining_ones)
        result = max(include_current_string, skip_current_string)

        stored_calculations[current_index][number_of_remaining_zeroes][number_of_remaining_ones] = result
        return result
