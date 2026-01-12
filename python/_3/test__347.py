import pytest

from _347 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    (
                            [1, 1, 1, 2, 2, 3],
                            2
                    ),
                    [1, 2]
            ),
            (
                    (
                            [1],
                            1
                    ),
                    [1]
            ),
            (
                    (
                            [1, 2, 1, 2, 1, 2, 3, 1, 3, 2],
                            2
                    ),
                    [1, 2]
            ),
        ])
    def test(self, inputs, expected):
        assert Solution().topKFrequent(*inputs) == expected
