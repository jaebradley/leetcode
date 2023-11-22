import sys
from typing import List


class Solution:
    # max when holding one share = max(bought yesterday and holding, sold yesterday and buying)
    # max when not holding any shares = max(not holding shares, bought yesterday and selling today)
    def maxProfit(self, prices: List[int]) -> int:
        bought, sold = -sys.maxsize, 0

        for price in prices:
            bought = max(bought, sold - price)
            sold = max(sold, bought + price)

        return sold
