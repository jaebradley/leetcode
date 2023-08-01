from typing import List


class Solution:
    """
    Can think of the problem as maximum number of 1s before seeing a second 0 (or end of list).
    If no first 0 is seen then take the count (length of input list) and subtract 1.

    """

    def longestSubarray(self, nums: List[int]) -> int:
        count_of_1s = []
        current_count = 0
        for num in nums:
            if 0 == num:
                count_of_1s.append(current_count)
                current_count = 0
            else:
                current_count += 1
        count_of_1s.append(current_count)

        if 1 == len(count_of_1s):
            return count_of_1s[0] - 1

        longest_subarray = 0
        for ending_index in range(1, len(count_of_1s)):
            longest_subarray = max(longest_subarray, count_of_1s[ending_index - 1] + count_of_1s[ending_index])

        return longest_subarray
