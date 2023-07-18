import pytest

from _392 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["abc", "ahbgdc"], True),
            (["axc", "ahbgdc"], False),
        ])
    def test(self, inputs, expected):
        assert Solution().isSubsequence(*inputs) == expected
