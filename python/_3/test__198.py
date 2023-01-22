from unittest import TestCase

from _198 import Solution


class SolutionTest(TestCase):
    def test(self):
        self.assertEqual(4, Solution().rob([1, 2, 3, 1]))
        self.assertEqual(12, Solution().rob([2, 7, 9, 3, 1]))
