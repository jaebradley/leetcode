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


class DPSolution:
    """
    Builds off the idea of a recursive solution - if the original string can be split into s1 and s2
    where s1 contains substrings that are in the dictionary and s2 contains substrings that are in the dictionary
    then the original string s is a valid word.

    Note that each of s1 and s2 can have the same solution / idea applied to them.


    """

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dictionary = set(wordDict)
        valid_prefix_ending_indices = [False] * (len(s) + 1)
        valid_prefix_ending_indices[0] = True

        for ending_index in range(1, len(s) + 1):
            for starting_index in range(ending_index):
                if valid_prefix_ending_indices[starting_index] and s[starting_index:ending_index] in dictionary:
                    valid_prefix_ending_indices[ending_index] = True

        return valid_prefix_ending_indices[len(s)]
