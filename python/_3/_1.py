from collections import defaultdict
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        matching_values = defaultdict(int)
        nums_length = len(nums)
        for index in range(nums_length):
            current_value = nums[index]
            match = target - current_value
            matching_index = matching_values.get(match, None)
            if matching_index is not None:
                return [matching_index, index]
            else:
                matching_values[current_value] = index

        raise RuntimeError("matching index should always exist")