import pytest

from _791 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["cba", "abdc"], "cbad"),
            (["cbafg", "abcd"], "cbad")
        ])
    def test(self, inputs, expected):
        assert Solution().customSortString(*inputs) == expected
