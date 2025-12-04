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

class Solution:
    """
    When a * is seen, there are three possibilities
    * Treat it as an open or closing parenthesis
    * OR treat it as an empty string / ignore it

    Add open parentheses and *s to stack.
    Keep track of number of *s.
    If closed parentheses is seen
    * If no open parentheses or * in stack then return false
    * Otherwise pop off the top of the stack
    * If a star keep track that it was used

    Is valid if len(stack) is zero or len(stack) / 2 === total * count - * used
    """
    def checkValidString(self, s: str) -> bool:
        potential_open_parentheses, stars_seen, stars_used = [], 0, 0
        for c in s:
            if c == '(':
                potential_open_parentheses.append(c)
            if c == '*':
                potential_open_parentheses.append(c)
                stars_seen += 1
            if c == ')':
                stars_used += 1
                if not potential_open_parentheses:
                    return False