from _211 import WordDictionary


class TestSolution:
    def test(self):
        dictionary = WordDictionary()
        dictionary.addWord("bad")
        assert dictionary.search(".ad") == True

        dictionary.addWord("dad")
        dictionary.addWord("mad")
        assert dictionary.search("pad") == False
        assert dictionary.search("bad") == True
        assert dictionary.search(".ad") == True
        assert dictionary.search("b..") == True
        assert dictionary.search("b") == False
        assert dictionary.search(".") == False
        assert dictionary.search("b.d") == True
        assert dictionary.search("...") == True

        dictionary2 = WordDictionary()
        dictionary2.addWord("at")
        dictionary2.addWord("and")
        dictionary2.addWord("an")
        dictionary2.addWord("add")
        assert dictionary2.search("a") == False
        assert dictionary2.search(".at") == False
        dictionary2.addWord("bat")
        assert dictionary2.search(".at") == True
        assert dictionary2.search("an.") == True
        assert dictionary2.search("a.d.") == False
        assert dictionary2.search("b.") == False
        assert dictionary2.search("a.d") == True
        assert dictionary2.search(".") == False

        dictionary3 = WordDictionary()
        dictionary3.addWord("a")
        dictionary3.addWord("ab")
        assert dictionary3.search("a") == True
