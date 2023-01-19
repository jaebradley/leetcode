"""
https://leetcode.com/problems/word-break/

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
"""

from collections import deque
from typing import List


class BFSSolution:
    """
    Recursive approach:

    * If the input string is in the word dictionary, return true
    * If it is not, build a "prefix" starting from index 0 of the input string
    * If the prefix is in the dictionary, call wordBreak on the suffix
    * Keep building the prefix until the suffix is breakable
    * If it's not breakable, return false
    * Worst-case performance is O(length of string ^ 3) - there are N starting indices / prefixes
    * For each prefix, there are N suffixes
    * The substring method is O(N) os the runtime is O(N^3)
    """

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        words = set(wordDict)
        q = deque()
        visited = set()
        q.append(0)

        while q:
            starting_index = q.popleft()
            if starting_index not in visited:
                for ending_index in range(starting_index + 1, len(s) + 1):
                    if s[starting_index:ending_index] in words:
                        q.append(ending_index)
                        if ending_index == len(s):
                            return True

            visited.add(starting_index)

        return False
