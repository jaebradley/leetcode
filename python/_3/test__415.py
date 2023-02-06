import pytest

from _415 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["11", "123"], "134"),
            (["456", "77"], "533"),
            (["0", "0"], "0")
        ])
    def test(self, inputs, expected):
        assert Solution().addStrings(*inputs) == expected
