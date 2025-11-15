"""
Given an array of strings strs, group the anagrams together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]



Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
"""
import collections
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = collections.defaultdict(list)
        for value in strs:
            groups[tuple(sorted(value))].append(value)

        return list(groups.values())

    def groupAnagramsByCount(self, strs: List[str]) -> List[List[str]]:
        def calculate_character_counts(value: str) -> list[int]:
            counts = [0] * 26
            for character in value:
                counts[ord(character) - ord('a')] += 1
            return counts

        groups = collections.defaultdict(list)
        for value in strs:
            groups[tuple(calculate_character_counts(value))].append(value)

        return list(groups.values())
