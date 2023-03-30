import pytest

from _168 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "column_number, expected",
        [
            (1, "A"),
            (2, "B"),
            (26, "Z"),
            (27, "AA"),
            (28, "AB"),
            (701, "ZY"),
            (702, "ZZ"),
        ])
    def test(self, column_number, expected):
        assert expected == Solution().convertToTitle(column_number)
