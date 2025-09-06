from collections import deque, defaultdict
from typing import List

"""
You are given a replacements mapping and a text string that may contain placeholders formatted as %var%, where each var 
corresponds to a key in the replacements mapping. Each replacement value may itself contain one or more such 
placeholders. Each placeholder is replaced by the value associated with its corresponding replacement key.

Return the fully substituted text string which does not contain any placeholders.
"""


class Solution:
    """
    Build mapping of input to replacement.

    Build graph of dependencies, where the key is the token, and the value is a set of dependencies extracted from the
    token's replacements. These dependencies are other replacement tokens.

    Add the tokens that do not have a dependency to a queue.

    While the queue is not empty, pop the current token (should be a token without any dependencies) from the queue.

    Get the replacement string for this token.

    Serialize the replacement string by replacing all tokens in the string with their value.

    Remove the current token from any dependencies in the graph. For any tokens that no longer have dependencies, add
    that token to the queue.

    Finally, after processing all token, serialize the input text by replacing all tokens in the input text with their
    "fully replaced" values.
    """

    def applySubstitutions(self, replacements: List[List[str]], text: str) -> str:
        replacement_by_token = {}
        dependencies_by_token = defaultdict(set)
        for token, replacement in replacements:
            replacement_by_token[token] = replacement

        for token, replacement in replacement_by_token.items():
            dependencies_by_token[token] = set([dependency for dependency in Solution.parse_dependencies(replacement) if
                                                dependency in replacement_by_token])

        q = deque(token for token, dependencies in dependencies_by_token.items() if not dependencies)
        while q:
            current_token = q.pop()
            replacement = replacement_by_token.get(current_token)
            replacement_by_token[current_token] = Solution.serialize(value=replacement,
                                                                     replacement_by_token=replacement_by_token)

            for token, dependencies in dependencies_by_token.items():
                if dependencies:
                    dependencies.discard(current_token)
                    if not dependencies:
                        q.appendleft(token)

        return Solution.serialize(value=text, replacement_by_token=replacement_by_token)

    @staticmethod
    def serialize(value: str, replacement_by_token) -> str:
        return "".join([
            replacement_by_token.get(part, part) if 1 == len(part) else part
            for part in Solution.parse_parts(value=value)
        ])

    @staticmethod
    def parse_parts(value: str) -> list[str]:
        return value.split("%")

    @staticmethod
    def parse_dependencies(value: str) -> set[str]:
        return set([
            v for v in Solution.parse_parts(value=value)
            if len(v) == 1
        ])
