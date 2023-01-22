"""
https://leetcode.com/problems/house-robber/

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
"""

from typing import List


class Solution:
    """
    Two decisions - rob current house or to not rob the current house.

    Keep track of max value when robbing previous house or skipping previous house.

    For the current house, the max value from robbing the current house is the max from skipping previous house + current house value OR
    max robbing previous house.

    The max value from skipping the current house is the max of robbing the previous house or the max from skipping the previous house.

    Runtime is O(n) since all the houses need to be iterated over and the space used is O(1) since there are a set number of variables

    The max value from robbing
    :param nums:
    :return:
    """
    def rob(self, nums: List[int]) -> int:
        max_robbing_previous_house, max_skipping_previous_house = 0, 0
        for num in nums:
            robbing_current_house = max_skipping_previous_house + num
            max_robbing_current_house = max(robbing_current_house, max_robbing_previous_house)
            max_skipping_current_house = max(max_robbing_previous_house, max_skipping_previous_house)
            max_robbing_previous_house = max_robbing_current_house
            max_skipping_previous_house = max_skipping_current_house

        return max(max_robbing_previous_house, max_skipping_previous_house)
