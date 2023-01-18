from unittest import TestCase

from _128 import Solution


class TestSolution(TestCase):
    def test_longest_consecutive(self):
        self.assertEqual(4, Solution().longestConsecutive([1, 2, 3, 4]))
        self.assertEqual(4, Solution().longestConsecutive([100, 4, 200, 1, 3, 2]))
        self.assertEqual(9, Solution().longestConsecutive([0, 3, 7, 2, 5, 8, 4, 6, 0, 1]))
