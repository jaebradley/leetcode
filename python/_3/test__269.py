import pytest

from _269 import BFSSolution


class TestSolution:
    @pytest.mark.parametrize(
        "words, expected",
        [
            (["wrt","wrf","er","ett","rftt"], "wertf"),
            (["z","x"], "zx"),
            (["a", "ab","abc"], "cba"),
            (["z","x","z"], ""),
            (["z","z"], "z"),
        ])
    def test(self, words, expected):
        assert BFSSolution().alienOrder(words) == expected
