from unittest import TestCase

from _139 import BFSSolution


class TestSolution(TestCase):
    def test_word_break(self):
        self.assertTrue(BFSSolution().wordBreak("leetcode", ["leet", "code"]))
        self.assertTrue(BFSSolution().wordBreak("applepenapple", ["apple", "pen"]))
        self.assertFalse(BFSSolution().wordBreak("catsandog", ["cats", "dog", "sand", "and", "cat"]))
