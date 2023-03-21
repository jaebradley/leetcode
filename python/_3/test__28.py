import pytest

from _28 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["sadbutsad", "sad"], 0),
            (["leetcode", "leeto"], -1),
            (["leetleetode", "leeto"], 4),
            (["eleetcode", "leet"], 1),
            (["ecodelee", "leet"], -1),
            (["", "foo"], -1),
            (["foo", "b"], -1),
            (["a", "a"], 0)
        ])
    def test(self, inputs, expected):
        assert expected == Solution().strStr(*inputs)
