import pytest

from _91 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "value, expected",
        [
            ("12", 2),
            ("226", 3),
            ("06", 0),
            ("01", 0),
            ("10", 1),
            ("102", 1),
            ("0", 0),
            ("00", 0),
            ("27", 1),
        ])
    def test(self, value, expected):
        assert Solution().numDecodings(value) == expected
