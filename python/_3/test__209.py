import pytest

from _209 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([7, [2, 3, 1, 2, 4, 3]], 2),
            ([4, [1, 4, 4]], 1),
            ([11, [1, 1, 1, 1, 1, 1, 1, 1]], 0),
        ])
    def test(self, arguments, expected):
        assert Solution().minSubArrayLen(*arguments) == expected
