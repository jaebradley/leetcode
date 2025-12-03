from collections import defaultdict, deque, Counter
from typing import List, Optional, Tuple

"""
There is a new alien language that uses the English alphabet. However, the order of the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary. Now it is claimed that the strings in words are sorted lexicographically by the rules of this new language.

If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters, return "".

Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there are multiple solutions, return any of them.



Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
Example 2:

Input: words = ["z","x"]
Output: "zx"
Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of only lowercase English letters.
"""
class BFSSolution:
    """
    From words, find the first differing character between two adjacent words.
    These two characters will provide a relative lexicographical ordering.

    A directed edge between two characters means that the starting character is lexicographically smaller than the ending character.
    The character with zero indegrees is the lexicographically smallest character.
    Keep track of the zero indegree nodes in a queue.
    Remove nodes from the queue and remove the edges associated with the node from the graph.
    If any vertices that are impacted by the edge removal now have zero indegrees, add them to the queue.

    Runtime:
    Have to check every letter of every word: O(characters)
    BFS: O(vertices + edges)
    1 vertex for each unique character
    1 edge for each differing character between words - so at most, word count - 1 edges
    Also note that two characters can't have more than 1 edge - so can't have more edges than the number of unique characters, squared.
    Total runtime: O(characters + unique characters + min(unique characters squared, number of words))
    """
    def alienOrder(self, words: List[str]) -> str:
        def find_first_differing_characters(first: str, second: str) -> Optional[Tuple[str, str]]:
            for i in range(min(len(first), len(second))):
                first_word_character, second_word_character = first[i], second[i]
                if first_word_character != second_word_character:
                    return first_word_character, second_word_character

            return None

        indegrees_by_character = Counter({c: 0 for word in words for c in word})
        larger_characters_by_smaller_character = defaultdict(set)
        for i in range(1, len(words)):
            previous_word, current_word = words[i-1], words[i]
            potential_differing_characters = find_first_differing_characters(previous_word, current_word)
            if potential_differing_characters:
                smaller_character, larger_character = potential_differing_characters[0], potential_differing_characters[1]
                if larger_character not in larger_characters_by_smaller_character[smaller_character]:
                    indegrees_by_character[larger_character] += 1
                    larger_characters_by_smaller_character[smaller_character].add(larger_character)
            else:
                if len(current_word) < len(previous_word):
                    return ""

        result = []
        zero_indegree_characters = deque(list(map(lambda v: v[0], filter(lambda v: v[1] == 0, indegrees_by_character.items()))))
        while zero_indegree_characters:
            c = zero_indegree_characters.pop()
            result.append(c)

            for larger_character in larger_characters_by_smaller_character[c]:
                indegrees_by_character[larger_character] -= 1
                if 0 == indegrees_by_character[larger_character]:
                    zero_indegree_characters.appendleft(larger_character)

        if len(result) == len(indegrees_by_character):
            return "".join(result)

        return ""