import pytest

from _30 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["barfoothefoobarman", ["foo", "bar"]], [0, 9]),
            (["wordgoodgoodgoodbestword", ["word", "good", "best", "word"]], []),
            (["barfoofoobarthefoobarman", ["bar", "foo", "the"]], [6, 9, 12]),
            (["aaaaa", ["a", "a", "a"]], [0, 1, 2]),
            (["wordgoodgoodgoodbestword", ["word","good","best","good"]], [8]),
        ])
    def test(self, inputs, expected):
        assert Solution().findSubstring(*inputs) == expected
