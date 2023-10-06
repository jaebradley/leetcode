from _208 import Trie


class TestSolution:
    def test(self):
        trie = Trie()
        trie.insert("apple")
        assert trie.search("apple") is True
        assert trie.search("app") is False
        assert trie.startsWith("app") is True
        trie.insert("app")
        assert trie.search("app") is True

    def test2(self):
        trie = Trie()
        trie.insert("app")
        trie.insert("apple")
        trie.insert("beer")
        trie.insert("add")
        trie.insert("jam")
        trie.insert("rental")
        assert trie.search("apps") is False
        assert trie.search("app") is True
