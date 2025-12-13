"""
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
"""
import copy
from collections import deque
from typing import List


class Solution:
    """
    For all existing subsets, copy the subset and create a candidate subset by adding the current number to the subset.
    If the candidate subset has not already been seen, add it to the visited subsets and add it to the deque.

    Runtime is O(# of nums x log # of nums (sorting) + # of nums x 2 ^ # of nums (total number of possible subsets)).
    This results in O(# of nums x 2 ^ # of nums).
    Space is O(2 ^ # of nums). All possible subsets will be stored.
    """
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result = deque([[]])
        visited = set([])
        for num in nums:
            for _ in range(len(result)):
                subarray = result.pop()

                result.appendleft(subarray)

                subarray_copy = copy.deepcopy(subarray)
                subarray_copy.append(num)

                t = tuple(subarray_copy)

                if t not in visited:
                    visited.add(t)
                    result.appendleft(subarray_copy)

        return list(result)