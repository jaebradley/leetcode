"""
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
"""


class Solution:
    """
    (()() -> ()() (1 removal)
    (()() -> (()) (1 removal)
    )()( -> () (2 removals)

    Find number of unmatched parentheses?

    Open parentheses stack, add open parentheses
    When an open parentheses is seen, add it to the open parentheses stack
    When a closed parentheses is seen, if no open parentheses exists, skip over character
    If open parentheses exists, pop parentheses off stack
    return count
    runtime: O(n) - must iterate over all characters in string
    memory: O(n) - all string elements could be open parentheses
    """

    def minRemoveToMakeValid(self, s: str) -> str:
        open_parentheses = []
        invalid_indices = set([])

        for index, c in enumerate(s):
            if c == "(":
                open_parentheses.append(index)
            elif c == ")":
                if 0 == len(open_parentheses):
                    invalid_indices.add(index)
                else:
                    open_parentheses.pop()

        invalid_indices |= set(open_parentheses)

        valid_characters = []
        for index, c in enumerate(s):
            if index not in invalid_indices:
                valid_characters.append(c)

        return "".join(valid_characters)
