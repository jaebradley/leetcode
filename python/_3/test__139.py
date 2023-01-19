import pytest

from _139 import BFSSolution, DPSolution


class TestSolution:

    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["leetcode", ["leet", "code"]], True),
            (["applepenapple", ["apple", "pen"]], True),
            (["catsandog", ["cats", "dog", "sand", "and", "cat"]], False)
        ])
    def test(self, inputs, expected):
        for executor in [
            BFSSolution().wordBreak,
            DPSolution().wordBreak
        ]:
            assert expected == executor(*inputs)
