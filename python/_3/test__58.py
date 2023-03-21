import pytest

from _58 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["Hello World"], 5),
            (["   fly me   to   the moon  "], 4),
            (["a"], 1),
            ([" a"], 1),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().lengthOfLastWord(*inputs)
