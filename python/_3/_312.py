from functools import lru_cache
from typing import List

"""
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 300
0 <= nums[i] <= 100
"""


class Solution:
    """
    Base case is an empty array = 0 coins
    Then consider splitting coins array into calculating max coins by combining
    1. max coins on the left side of one element in the array
    2. max coins from the right side of the array element
    3. product of coins from the array element x coins on the left side of the left side x coins on right side of the right side.
       This is because the recursive divide-and-conquer calls to dp lead to those intervals all being burst aka empty arrays.
    """

    def maxCoins(self, nums: List[int]) -> int:
        # Explicitly handle edge cases
        coins = [1] + nums + [1]

        @lru_cache(maxsize=None)
        def dp(left, right):
            if left > right:
                return 0

            maximum_coins = 0
            for last_balloon_index in range(left, right + 1):
                maximum_coins = max(maximum_coins,
                    dp(left, last_balloon_index - 1)
                    + dp(last_balloon_index + 1, right)
                    + (coins[left - 1] * coins[last_balloon_index] * coins[right + 1])
                )

            return maximum_coins

        return dp(1, len(coins) - 2)
