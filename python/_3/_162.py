"""
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.


Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
"""
import sys
from typing import List


class Solution:
    """
    Approach:
    Two consecutive elements are never equal.
    From the problem description, target logarithmic runtime implies binary searching.
    A value is a peak if the element to it's left and right are less than it.

    1. Imagine having the start and end values of search array
    2. Pick the middle value between the start and the end
    3. If the middle value is a peak value, return it
    4. If the middle value is less than its left neighbor and greater than its right neighbor, then the peak value is
       to its left (i.e. the middle value is on a descending slope)
    5. If the middle value is greater than its left neighbor and less than its right neighbor, then the peak value is
       to its right (i.e. the middle values is on an ascending slope)
    6. Continue this algorithm for the next search array window
    """
    def findPeakElement(self, nums: List[int]) -> int:
        def search(start_index: int, end_index: int) -> int:
            middle_index = (end_index + start_index) // 2
            middle_value = nums[middle_index]

            left_value = -sys.maxsize if middle_index == 0 else nums[middle_index - 1]
            right_value = -sys.maxsize if middle_index == (len(nums) - 1) else nums[middle_index + 1]

            if middle_value > left_value and middle_value > right_value:
                return middle_index

            if left_value > middle_value:
                return search(start_index, middle_index - 1)

            if right_value > middle_value:
                return search(middle_index + 1, end_index)

            raise ValueError("Should not end up here")

        return search(0, len(nums) - 1)