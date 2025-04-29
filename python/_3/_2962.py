from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_element = max(nums)
        subarrays_count = left_index = current_max_element_count = 0
        for right_index in range(len(nums)):
            current_max_element_count += nums[right_index] == max_element
            while current_max_element_count >= k:
                current_max_element_count -= nums[left_index] == max_element
                left_index += 1

            subarrays_count += left_index

        return subarrays_count
