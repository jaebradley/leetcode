from functools import lru_cache
from typing import List, Optional, Mapping, Counter

"""
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000
 

Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?
"""

class TopDownSolution:
    """
    Sub-problems are something like
    nums, target = original target - 1 (2, 3)
    If target is None, then recurse down sub-problem.
    And then this breaks down into further sub-problems, until the base case is reached where a target is <= 0.
    If a target is equal to 0, then increment the target value by 1.
    """
    def combinationSum4(self, nums: List[int], target: int) -> int:
        @lru_cache(maxsize=None)
        def helper(target: int) -> int:
            if target == 0:
                return 1

            result = 0
            for num in nums:
                next_target = target - num
                if next_target >= 0:
                    result += helper(next_target)

            return result

        return helper(target)

class BottomUpSolution:
    """
    Bottom-up solution starts from 0, 1, 2, 3, etc until the target value.
    Uses previous calculations when incrementing to the next value in the range of values.
    """
    def combinationSum4(self, nums: List[int], target: int) -> int:
        results = [0] * (target + 1)
        results[0] = 1
        for value in range(1, target + 1):
            current_sum = 0
            for num in nums:
                previous_target = value - num
                if previous_target >= 0:
                    current_sum += results[previous_target]
            results[value] = current_sum

        return results[target]
