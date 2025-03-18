from typing import List
from collections import deque

"""
Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the 
absolute difference between any two elements of this subarray is less than or equal to limit.
"""


class Solution:
    """
    Two dequeue solution + sliding window
    One dequeue contains elements in monotonically increasing order for elements seen in the current window.
    One dequeue contains elements in monotonically decreasing order for elements seen in the current window.
    Check the "heads" of both dequeues.
    One "head" should point to the maximum value seen and the other head should point to the minimum value seen for the
    current window.

    If the difference is greater than the limit, need to tighten the window.
    If the maximum number is equal to the current left side of the window, remove the maximum number.
    Same for the minimum number.
    Increment the left side of the window.
    Update the max length based on the right side of the window - left side of the window + 1
    """
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        increasing_dequeue, decreasing_dequeue, max_length, left_index = deque([]), deque([]), 0, 0

        for right_index in range(len(nums)):
            current_right_number = nums[right_index]
            while increasing_dequeue and increasing_dequeue[0] < current_right_number:
                increasing_dequeue.popleft()
            increasing_dequeue.appendleft(current_right_number)

            while decreasing_dequeue and decreasing_dequeue[0] > current_right_number:
                decreasing_dequeue.popleft()
            decreasing_dequeue.appendleft(current_right_number)

            while abs(increasing_dequeue[-1] - decreasing_dequeue[-1]) > limit:
                current_left_number = nums[left_index]
                if increasing_dequeue[-1] == current_left_number:
                    increasing_dequeue.pop()
                if decreasing_dequeue[-1] == current_left_number:
                    decreasing_dequeue.pop()
                left_index += 1

            max_length = max(max_length, right_index - left_index + 1)


        return max_length
