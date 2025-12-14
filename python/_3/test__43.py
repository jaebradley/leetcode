import pytest

from _43 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (("12", "12"), "144"),
            (("19", "19"), "361"),
            (("2", "3"), "6"),
            (("1", "1"), "1"),
            (("6", "10"), "60"),
            (("10", "5"), "50"),
            (("100", "1000"), "100000"),
            (("123", "456"), "56088"),
            (("401716832807512840963", "167141802233061013023557397451289113296441069"),
             "67143675422804947379429215144664313370120390398055713625298709447"),
        ]
    )
    def test(self, inputs, expected):
        assert Solution().multiply(*inputs) == expected
