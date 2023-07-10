import pytest

from _1768 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["abc", "pqr"], "apbqcr"),
            (["ab", "pqrs"], "apbqrs"),
            (["", "pqrs"], "pqrs"),
            (["ab", ""], "ab"),
            (["abcd", "pq"], "apbqcd"),
        ])
    def test(self, inputs, expected):
        assert Solution().mergeAlternately(*inputs) == expected
