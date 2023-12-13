import sys
from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        current_subarray_sum, left_index, right_index, min_subarray_length = nums[0], 0, 0, sys.maxsize

        while right_index < len(nums):
            if current_subarray_sum >= target:
                min_subarray_length = min(min_subarray_length, (right_index - left_index + 1))
                if right_index > left_index:
                    current_subarray_sum -= nums[left_index]
                    left_index += 1
                else:
                    return min_subarray_length
            else:
                right_index += 1
                if right_index < len(nums):
                    current_subarray_sum += nums[right_index]

        return 0 if min_subarray_length == sys.maxsize else min_subarray_length
