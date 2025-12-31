import pytest

from _997 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    (
                            2,
                            [[1, 2]]
                    ),
                    2
            ),
            (
                    (
                            3,
                            [[1, 3], [2, 3]]
                    ),
                    3
            ),
            (
                    (
                            3,
                            [[1, 3], [2, 3], [3, 1]]
                    ),
                    -1
            ),
        ])
    def test(self, inputs, expected):
        assert Solution().findJudge(*inputs) == expected
