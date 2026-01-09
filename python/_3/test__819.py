import pytest

from _819 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                (
                    "Bob hit a ball, the hit BALL flew far after it was hit.",
                    ["hit"]
                ),
                "ball"
            ),
            (
                (
                    "a.",
                    []
                ),
                "a"
            )
        ])
    def test(self, inputs, expected):
        assert Solution().mostCommonWord(*inputs) == expected
