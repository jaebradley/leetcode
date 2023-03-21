"""
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
"""


class Solution:
    """
    Approach:

    Start with first index in needle and first index in haystack.
    Check if they are the same.
    If same, move to next index in needle and next index in haystack.
    If not the same, move back to first index in needle and next index in haystack.
    Continue this until next index in haystack is > last index in haystack OR all indices in needle match.
    If all indices match, return the first / starting index for the substring matching needle.
    """

    def strStr(self, haystack: str, needle: str) -> int:
        needle_length, haystack_length = len(needle), len(haystack)
        current_haystack_index, starting_haystack_index, max_haystack_index = 0, 0, haystack_length - needle_length

        while current_haystack_index <= max_haystack_index:
            found_match = True

            for needle_index in range(needle_length):
                if haystack[current_haystack_index + needle_index] != needle[needle_index]:
                    found_match = False
                    break

            if found_match:
                return current_haystack_index

            current_haystack_index += 1

        return -1
