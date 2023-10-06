class Trie:
    class Node:
        def __init__(self):
            self.nodes = [None] * 26
            self.is_leaf = False

        def insert(self, character):
            index = ord(character) - ord('a')
            if self.nodes[index] is None:
                self.nodes[index] = Trie.Node()

            return self.nodes[index]

    def __init__(self):
        self.head = Trie.Node()

    def insert(self, word: str) -> None:
        current_node = self.head
        for c in word:
            current_node = current_node.insert(c)

        current_node.is_leaf = True

    def search(self, word: str) -> bool:
        current_node = self.head
        character_index = 0
        while current_node is not None and character_index < len(word):
            current_node = current_node.nodes[ord(word[character_index]) - ord('a')]
            character_index += 1
        return current_node is not None and current_node.is_leaf is True and character_index == len(word)

    def startsWith(self, prefix: str) -> bool:
        current_node = self.head
        character_index = 0
        while current_node is not None and character_index < len(prefix):
            current_node = current_node.nodes[ord(prefix[character_index]) - ord('a')]
            character_index += 1
        return current_node is not None and character_index == len(prefix)
