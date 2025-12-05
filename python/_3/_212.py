from collections import defaultdict
from typing import List, Tuple

"""
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 
Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
"""

class Solution:

    class Trie:
        class Node:
            def __init__(self):
                self.nodes = {}
                self.is_leaf = False
                self.word = None

            def insert(self, character):
                index = ord(character) - ord('a')
                if index not in self.nodes:
                    self.nodes[index] = Solution.Trie.Node()

                return self.nodes[index]

            def remove(self, character):
                index = ord(character) - ord('a')
                if self.nodes[index].is_leaf and len(self.nodes[index].nodes) == 0:
                    del self.nodes[index]
                self.is_leaf = len(self.nodes) == 0

        def __init__(self):
            self.head = Solution.Trie.Node()

        def insert(self, word: str) -> None:
            current_node = self.head
            for c in word:
                current_node = current_node.insert(character=c)

            current_node.is_leaf = True
            current_node.word = word

        def startsWith(self, prefix: str) -> Tuple[bool, bool]:
            current_node = self.head
            character_index = 0
            while current_node is not None and character_index < len(prefix):
                current_node = current_node.nodes[ord(prefix[character_index]) - ord('a')]
                character_index += 1
            return current_node is not None and character_index == len(prefix), current_node is not None and current_node.is_leaf

    """
    No more than once in a word = need to know visited nodes.
    Build Trie from words to help identify prefixes when identifying words from the board. O(# of total characters in words)

    For each square on the board, check if the square has been visited before.
    If not, add the square to the current candidate word.
    Add the square to the set of visited squares.
    If the candidate word is a valid prefix, recursively process the surrounding squares.
    Remove the square from the set of visited squares.

    Visit every square on the board at most once: O(# total number of squares).
    In worst case, every square leads to a valid word that is the size of the board.
    So total runtime is O(# total number of squares ^ 2) + O(# of total characters in words).
    
    Optimization is to remove a word from the trie once it's been identified.
    """
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Solution.Trie()
        for word in words:
            trie.insert(word)

        result = set()
        visited_squares = set()

        def dfs(row_index, column_index, parent_trie_node):
            cell = board[row_index][column_index]
            visited_squares.add((row_index, column_index))

            current_trie_node = parent_trie_node.nodes.get(ord(cell) - ord('a'), None)

            if current_trie_node:
                if current_trie_node.is_leaf and current_trie_node.word:
                    parent_trie_node.remove(cell)
                    result.add(current_trie_node.word)

                for row_modifier, column_modifier in [[-1, 0], [0, -1], [1, 0], [0, 1]]:
                    next_row_index = row_index + row_modifier
                    next_column_index = column_index + column_modifier

                    if 0 <= next_row_index < len(board) and 0 <= next_column_index < len(board[next_row_index]) and (next_row_index, next_column_index) not in visited_squares:
                        dfs(next_row_index, next_column_index, parent_trie_node=current_trie_node)

            visited_squares.remove((row_index, column_index))

        for row_index in range(len(board)):
            row = board[row_index]

            for column_index in range(len(row)):
                dfs(row_index, column_index, parent_trie_node=trie.head)

        return list(result)