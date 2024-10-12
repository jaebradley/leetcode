import pytest

from _1668 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["ba", "ab"], 0),
            (["ababc", "ba"], 1),
            (["ababc", "ac"], 0),
            (["a", "a"], 1),
            (["aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"], 5),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().maxRepeating(*inputs)
