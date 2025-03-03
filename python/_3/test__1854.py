import pytest

from _1854 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "logs, expected",
        [
            ([[1993, 1999], [2000, 2010]], 1993),
            ([[1950,1961],[1960,1971],[1970,1981]], 1960),
        ])
    def test(self, logs, expected):
        assert Solution().maximumPopulation(logs) == expected
