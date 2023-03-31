"""
https://leetcode.com/problems/excel-sheet-column-title/
"""
import math


class Solution:
    """
    Approach:

    Base-26 conversion (A-Z)
    101 is ASCII character code for A

    If input columnNumber is 0, return empty string
    Divide columnNumber by 26
    Keep track of result and remainder
    If result > 26, then set current character as Z
    Call convert to title with columnNumber - (26 * result)
    Append result to end of current character
    """

    def convertToTitle(self, columnNumber: int) -> str:
        if 0 >= columnNumber:
            return ""

        modulo = columnNumber % 26
        if 0 == modulo:
            current_character = 'Z'
        else:
            current_character = chr(64 + (columnNumber % 26))

        result = math.floor((columnNumber - 1) / 26)
        return self.convertToTitle(result) + current_character
