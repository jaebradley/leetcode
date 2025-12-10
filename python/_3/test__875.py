import pytest

from _875 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (([3, 6, 7, 11], 8), 4),
            (([30, 11, 23, 4, 20], 5), 30),
            (([30, 11, 23, 4, 20], 6), 23),
            (([1, 2, 100], 3), 100),
            (([1, 2, 100], 52), 2),
            (([1, 2, 100], 103), 1),
            (([312884470], 312884469), 2)
        ])
    def test(self, inputs, expected):
        assert expected == Solution().minEatingSpeed(*inputs)
