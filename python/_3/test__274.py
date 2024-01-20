import pytest

from _274 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "citations, result",
        [
            ([3, 0, 6, 1, 5], 3),
            ([1, 3, 1], 1),
        ])
    def test(self, citations, result):
        assert Solution().hIndex(citations) == result
