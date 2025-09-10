import sys
from typing import List

"""
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
"""

class Solution:
    """
    fewest number of coins(amount X) = min(fewest number of coins(amount X - coin 1), fewest number of coins(amount X - coin 2), etc)
    fewest number of coins initial state = [0] * amount
    For each coin, fewest number(coin value) = 1
    """
    def coinChange(self, coins: List[int], amount: int) -> int:
        fewest_number_of_coins = [sys.maxsize] * (amount + 1)
        fewest_number_of_coins[0] = 0
        for current_amount in range(amount + 1):
            current_fewest_coins = fewest_number_of_coins[current_amount]
            for coin in coins:
                previous_index = current_amount - coin
                if previous_index >= 0:
                    current_fewest_coins = min(current_fewest_coins, fewest_number_of_coins[previous_index] + 1)
            fewest_number_of_coins[current_amount] = current_fewest_coins

        result = fewest_number_of_coins[amount]
        return -1 if result == sys.maxsize else result


