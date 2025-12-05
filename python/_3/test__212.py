import pytest

from _212 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    (
                            [["o", "a", "a", "n"], ["e", "t", "a", "e"], ["i", "h", "k", "r"], ["i", "f", "l", "v"]],
                            ["oath", "pea", "eat", "rain"]
                    ),
                    ["eat", "oath"],
            ),
            (
                    (
                            [["a", "b"], ["c", "d"]],
                            ["abcb"]
                    ),
                    [],
            ),
            (
                    (
                            [["a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"],
                             ["a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"],
                             ["a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"],
                             ["a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"],
                             ["a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"],
                             ["a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"],
                             ["a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"],
                             ["a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"],
                             ["a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"],
                             ["a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"],
                             ["a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"],
                             ["a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"]],
                            ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                             "aaaaaaaaaa"]
                    ),
                    ['aaaaaaaa',
                     'aa',
                     'aaaaaaa',
                     'aaaa',
                     'aaaaa',
                     'aaaaaa',
                     'aaaaaaaaa',
                     'aaaaaaaaaa',
                     'a',
                     'aaa']
            ),
            (
                (
                        [["a","b"],["c","d"]],
                        ["abcd"]
                ),
                []
            ),
            (
                (
                        [["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]],
                        ["oa","oaa"]
                ),
                ["oa","oaa"]
            ),
            (
                (
                        [["a","b"],["a","a"]],
                        ["aba","baa","bab","aaab","aaa","aaaa","aaba"]
                ),
                ["aba","aaa","aaab","baa","aaba"]
            )
        ])
    def test(self, inputs, expected):
        assert sorted(Solution().findWords(*inputs)) == sorted(expected)
