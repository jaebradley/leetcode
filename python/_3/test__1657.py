import pytest

from _1657 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["abc", "bca"], True),
            (["a", "aa"], False),
            (["cabbba", "abbccc"], True),
        ])
    def test(self, inputs, expected):
        assert Solution().closeStrings(*inputs) == expected
