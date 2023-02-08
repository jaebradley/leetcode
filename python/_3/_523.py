"""
https://leetcode.com/problems/continuous-subarray-sum/
"""

from typing import List


class Solution:
    """
    Idea is to calculate the modulo of the running sum of values seen (so far).

    If the modulo has not been seen before (i.e. none of the previous sums of values have produced the modulo) the index
    associated with the modulo is the next index, and is stored in a Map (with the index as the key).

    If the Map contains the modulo, and the index associated with the modulo is less than the current index, then
    there exists some subarray (of at least two elements)

    Runtime is O(number of values) - all values may need to be introspected
    Memory is O(minimum of numbers or k). The map cannot contain more than k entries nor can it contain more entries
    than the number of values in the input array.
    """

    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        previous_indices_by_remainders = {0: 0}
        current_sum = 0
        for index, value in enumerate(nums):
            current_sum += value
            remainder = current_sum % k

            if remainder in previous_indices_by_remainders:
                if previous_indices_by_remainders[remainder] < index:
                    return True
            else:
                previous_indices_by_remainders[remainder] = index + 1

        return False
