"""
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.


Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 2 dots in word for search queries.
At most 104 calls will be made to addWord and search.
"""
from collections import deque


class WordDictionary:
    """
    Naive implementation that keeps track of wildcarded letters in a queue. Max # of wildcarded letters is 2 per search word.
    Worst case is O(26^length of word)
    """

    class TrieNode:
        def __init__(self, child_nodes_by_character):
            self.child_nodes_by_character = child_nodes_by_character
            self.is_leaf = False

    def __init__(self):
        self.root = WordDictionary.TrieNode(child_nodes_by_character={})

    def addWord(self, word: str) -> None:
        current_node = self.root
        for c in word:
            if c not in current_node.child_nodes_by_character:
                current_node.child_nodes_by_character[c] = WordDictionary.TrieNode({})
            current_node = current_node.child_nodes_by_character[c]

        current_node.is_leaf = True

        return None

    def search(self, word: str) -> bool:
        current_nodes = deque([self.root])
        for index, c in enumerate(word):
            for _ in range(len(current_nodes)):
                current_node = current_nodes.pop()
                if c in current_node.child_nodes_by_character:
                    current_nodes.appendleft(current_node.child_nodes_by_character[c])
                elif c == ".":
                    for next_node in current_node.child_nodes_by_character.values():
                        current_nodes.appendleft(next_node)

        return any(map(lambda node: node.is_leaf, current_nodes))
