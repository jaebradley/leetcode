import bisect
from typing import List

"""
Given an integer array nums, return the length of the longest strictly increasing subsequence.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
"""


class LinearSearchSolution:
    """
    Base case: each index is its longest increasing subsequence (of length 1).
    Memoization: list of length of input numbers where the value at an index represents the longest increasing subsequence that ends at that index.
    Recurrence relation: for a given index, look at all previous indices for longest increasing subsequence. If current value > previous index value increment the previous indexes' LIS by 1 and use that sum as the max LIS.
    Runtime: O(len(nums) ^ 2)
    """

    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1] * len(nums)
        for index in range(1, len(nums)):
            current_num = nums[index]
            for previous_index in range(index):
                previous_num = nums[previous_index]
                if current_num > previous_num:
                    dp[index] = max(dp[index], dp[previous_index] + 1)
        return dp[len(nums) - 1]


class BinarySearchSolution:
    """
    The linear search approach considered all previous values.
    However, what we can do instead is replace the last element in the currently evaluated subsequence of values that
    is greater than the current element with the current element.

    If the current number is greater than any numbers in the subsequence, then append it to the end of the subsequence.
    Otherwise, replace the element that is equal to or greater than the current number with the current number.
    This replacement keeps the relative ordering of the subsequence while still leaving the opportunity for greater future
    values to "overwrite" the maximum seen values.
    [4, 10] (apply 4) -> [4, 10]
    [4, 10] (apply 3) -> [3, 10]
    [3, 10] (apply 8) -> [3, 8]
    [3, 8] (apply 9) -> [3, 8, 9]
    """
    def lengthOfLIS(self, nums: List[int]) -> int:
        subsequence = []
        for num in nums:
            index_of_element_greater_than_current_number = bisect.bisect_left(subsequence, num)
            if index_of_element_greater_than_current_number == len(subsequence):
                subsequence.append(num)
            else:
                subsequence[index_of_element_greater_than_current_number] = num
        return len(subsequence)
