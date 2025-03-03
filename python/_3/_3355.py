from typing import List

"""
You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].

For each queries[i]:

    Select a 

    of indices within the range [li, ri] in nums.
    Decrement the values at the selected indices by 1.

A Zero Array is an array where all elements are equal to 0.

Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.

 

Example 1:

Input: nums = [1,0,1], queries = [[0,2]]

Output: true

Explanation:

    For i = 0:
        Select the subset of indices as [0, 2] and decrement the values at these indices by 1.
        The array will become [0, 0, 0], which is a Zero Array.

Example 2:

Input: nums = [4,3,2,1], queries = [[1,3],[0,2]]

Output: false

Explanation:

    For i = 0:
        Select the subset of indices as [1, 2, 3] and decrement the values at these indices by 1.
        The array will become [4, 2, 1, 0].
    For i = 1:
        Select the subset of indices as [0, 1, 2] and decrement the values at these indices by 1.
        The array will become [3, 1, 0, 0], which is not a Zero Array.


"""


class Solution:
    """
    Differences array and prefix sum array.
    calculated differences array that is length of nums.
    For each query, add a dictionary entry, key is length and sum is value
    
    """
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        decrements = [0] * len(nums)
        for query_starting_index, query_ending_index in queries:
            decrements[query_starting_index] += 1
            if (query_ending_index + 1) < len(nums):
                decrements[1 + query_ending_index] -= 1

        decrement = 0
        for index in range(len(nums)):
            current_number = nums[index]
            current_decrement = decrements[index]
            decrement = max(0, decrement + current_decrement)
            if current_number > decrement:
                return False

        return True
