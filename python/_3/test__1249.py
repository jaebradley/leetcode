import pytest

from _1249 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ("lee(t(c)o)de)", "lee(t(c)o)de"),
            ("a)b(c)d", "ab(c)d"),
            ("))((", "")
        ])
    def test(self, input, expected):
        assert Solution().minRemoveToMakeValid(input) == expected
