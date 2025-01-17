"""
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
"""


class Solution:
    """
    Number of places = number of rows + floor(number of rows / 2)
    Example: 4 -> 6, 3 -> 4
    First row: 1, 1 + 6, previous even + , 3 x number of places - 2, etc
    Second row: 2, previous number + (2 x (number of rows - row count)), 2 + # of places,
    """
    def convert(self, s: str, numRows: int) -> str:
        increment = True
        max_exclusive_character_index = len(s)
        row_index = 0
        rows = [[] for _ in range(numRows)]
        for current_character_index in range(max_exclusive_character_index):
            rows[row_index].append(s[current_character_index])
            if increment:
                row_index = min(row_index + 1, numRows - 1)
            else:
                row_index = max(0, row_index - 1)

            if 0 == row_index:
                increment = True
            elif numRows - 1 == row_index:
                increment = False

        return "".join(map(lambda x: "".join(x), rows))
