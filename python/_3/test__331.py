import pytest

from _331 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            (
                    "9,3,4,#,#,1,#,#,2,#,6,#,#",
                    True
            ),
            (
                    "1,#",
                    False
            ),
            (
                    "9,#,#,1",
                    False
            ),
            (
                    "1,#,#,#,#",
                    False
            ),
            (
                    "#",
                    True
            ),
            (
                    "9,#,93,#,9,9,#,#,#",
                    True
            )
        ]
    )
    def test(self, input, expected):
        assert Solution().isValidSerialization(input) == expected
