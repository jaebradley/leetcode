import sys
from typing import List


class Solution:
    """
    Two states:
    1. Bought previously (and must sell at current day's price + fee or skip)
    2. Have not bought previously (and must buy, at current day's price or skip)

    max profit[i] = has bought & max profit[i - 1], can buy & max profit[i - 1]
    """

    def maxProfit(self, prices: List[int], fee: int) -> int:
        buying_profit, selling_profit = -sys.maxsize, 0

        for price in prices:
            selling_profit = max(selling_profit, buying_profit + price - fee)
            buying_profit = max(buying_profit, selling_profit - price)

        return selling_profit
