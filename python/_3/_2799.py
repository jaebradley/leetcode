from collections import defaultdict
from typing import List


class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        complete_subarrays_count = 0
        if nums:
            distinct_values = set(nums)
            distinct_values_count = len(distinct_values)
            left_index, right_index, current_subarray_counts_by_value = 0, 0, defaultdict(int)
            while right_index < len(nums):
                current_subarray_counts_by_value[nums[right_index]] += 1
                while len(current_subarray_counts_by_value) == distinct_values_count and left_index <= right_index:
                    complete_subarrays_count += (len(nums) - right_index)
                    current_subarray_counts_by_value[nums[left_index]] -= 1
                    if 0 >= current_subarray_counts_by_value[nums[left_index]]:
                        del current_subarray_counts_by_value[nums[left_index]]
                    left_index += 1

                right_index += 1

        return complete_subarrays_count
