from unittest import TestCase

from _121 import Solution


class TestSolution(TestCase):
    def test_max_profit(self):
        self.assertEqual(5, Solution().maxProfit(prices=[1, 2, 3, 4, 5, 6]))
        self.assertEqual(0, Solution().maxProfit(prices=[6, 5, 4, 3, 2, 1]))
        self.assertEqual(0, Solution().maxProfit(prices=[1, 1, 1, 1, 1, 1]))
        self.assertEqual(0, Solution().maxProfit(prices=[20, 10]))
        self.assertEqual(3, Solution().maxProfit(prices=[1, 2, 3, 4, 3, 2, 1]))
