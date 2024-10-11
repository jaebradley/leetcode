from typing import List


class Solution:
    """
    Two numbers that are equal and the absolute value of the difference between their indices is <= some limit.

    Keep track of most recent index seen for number.
    If number already exists in map, and the index difference is <= k, return True.
    Else, replace the index in the map.
    Return False if no numbers match criteria.
    """

    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        index_by_number = {}

        for index, number in enumerate(nums):
            previous_index = index_by_number.get(number)
            if previous_index is not None and k >= (index - previous_index):
                return True

            index_by_number[number] = index

        return False
