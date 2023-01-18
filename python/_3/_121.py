from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        max_profit_if_bought_previously, max_profit = -prices[0], 0

        for current_price in prices[1:]:
            max_profit = max(max_profit_if_bought_previously + current_price, max_profit)
            # If the current price is cheaper than the previously bought price, then the current price will lead to
            # strictly more profit for future sales
            max_profit_if_bought_previously = max(-current_price, max_profit_if_bought_previously)

        return max_profit