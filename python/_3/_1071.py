"""
https://leetcode.com/problems/greatest-common-divisor-of-strings
"""


class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        shared_prefixes = list()
        shared_prefix_index = 0
        while shared_prefix_index < len(str1) \
                and shared_prefix_index < len(str2) \
                and str1[shared_prefix_index] == str2[shared_prefix_index]:
            shared_prefixes.append(str1[0:shared_prefix_index + 1])
            shared_prefix_index += 1

        longest_shared_prefix = ""
        for shared_prefix in shared_prefixes:
            if self.composed_of_prefix(shared_prefix, str1) and self.composed_of_prefix(shared_prefix, str2):
                longest_shared_prefix = shared_prefix

        return longest_shared_prefix

    def composed_of_prefix(self, prefix: str, value: str) -> bool:
        return all([
            True if prefix == value[starting_index: starting_index + len(prefix)] else False
            for starting_index in range(0, len(value), len(prefix))])
