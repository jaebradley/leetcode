"""
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
substring

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:

Input: s = ""
Output: 0

"""

class Solution:
    """
    For parentheses to be well-formed
    * the number of open parentheses need to match the number of closed parentheses
    * a closed parentheses must match with an "active" open parentheses
    * a single unmatched parentheses can't be between the closed and open parenthesis

    Approach was to keep track of all open parentheses using a stack.
    On a closed parenthesis match, mark the matching closed parenthesis index and the matching open parenthesis index
    as True.

    Count the max consecutive Trues.
    """
    def longestValidParentheses(self, s: str) -> int:
        max_count, current_valid_count, open_parentheses = 0, 0, []
        results = [False] * len(s)
        for index, c in enumerate(s):
            if c == "(":
                open_parentheses.append(index)
            elif len(open_parentheses) > 0:
                most_recent_open_parenthesis_index = open_parentheses.pop()
                results[index] = True
                results[most_recent_open_parenthesis_index] = True

        for result in results:
            if result:
                current_valid_count += 1
            else:
                max_count = max(max_count, current_valid_count)
                current_valid_count = 0

        return max(max_count, current_valid_count)