"""
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true


Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.
"""


class DPSolution:
    """
    Two-dimensional array where dp[i][j] is true/false if the input string from index i to index j inclusive is valid (or not).

    * is the only single character that could be valid (a standalone "(" or ")" is not valid).

    Starting from the penultimate character in the string, check if the last two characters make a valid string.

    If they do, then dp[2nd to last][last] is True.

    Continuing this approach, checking if the first character and the last character are matching and whether
    the inner string is valid or not.

    Finally, check if dp[0][last index] is True or False.
    """

    def checkValidString(self, s: str) -> bool:
        valid_open_characters, valid_closed_characters = {'(', '*'}, {')', '*'}
        dp = [[False] * len(s) for _ in range(len(s))]

        for index, character in enumerate(s):
            dp[index][index] = character == '*'

        for left_index in range(len(s) - 2, -1, -1):
            for right_index in range(left_index + 1, len(s)):
                is_matching_pair = s[left_index] in valid_open_characters and s[
                    right_index] in valid_closed_characters and (
                                           (right_index - left_index) == 1 or dp[left_index + 1][right_index - 1]
                                   )

                dp[left_index][right_index] = is_matching_pair or (
                    any(dp[left_index][split_index] and dp[split_index + 1][right_index]
                        for split_index in range(left_index, right_index))
                )

        return dp[0][len(s) - 1]


class TwoPointerGreedySolution:
    """
    From left to right, count the asterisks as open parentheses and see if a valid string can be constructed. If more
    closed brackets are encountered than open parentheses or asterisks than it is not a valid string.

    Do the same from right to left, but for closed parentheses.

    Another way to intuitively think about this is to do two passes, treating all asterisks as open and then treating
    all asterisks as closed. Any extra asterisks can be "converted" into empty strings.
    """
    def checkValidString(self, s: str) -> bool:
        open_bracket_count, asterisk_count, closed_bracket_count = 0, 0, 0
        for index in range(len(s)):
            if s[index] == '(' or s[index] == '*':
                open_bracket_count += 1
            else:
                open_bracket_count -= 1

            if open_bracket_count < 0:
                return False

            right_index = len(s) - index - 1
            if s[right_index] == ')' or s[right_index] == '*':
                closed_bracket_count += 1
            else:
                closed_bracket_count -= 1

            if closed_bracket_count < 0:
                return False

        return True


