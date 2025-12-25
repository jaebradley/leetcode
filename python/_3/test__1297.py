import pytest

from _1297 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                ("aababcaab", 2, 3, 4),
                2
            ),
            (
                    ("aaaa", 1, 3, 3),
                    2
            ),
            (
                    ("abcdaaaaaa", 1, 6, 6),
                    1
            ),
        ])
    def test(self, inputs, expected):
        assert Solution().maxFreq(*inputs) == expected
