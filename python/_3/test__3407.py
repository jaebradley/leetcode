import pytest

from _3407 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    (
                            "leetcode",
                            "ee*e"
                    ),
                    True
            ),
            (
                    (
                            "car",
                            "c*v"
                    ),
                    False
            ),
            (
                    (
                            "luck",
                            "u*"
                    ),
                    True
            ),
            (
                    (
                            "a",
                            "a*"
                    ),
                    True
            ),
            (
                    (
                            "a",
                            "*a"
                    ),
                    True
            ),
            (
                    (
                            "a",
                            "*b"
                    ),
                    False
            ),
            (
                    (
                            "tokk",
                            "t*t"
                    ),
                    False
            ),
            (
                    (
                            "nrnrs",
                            "*nn"
                    ),
                    False
            ),
            (
                    (
                            "nrnrs",
                            "*"
                    ),
                    True
            ),
            (
                    (
                            "gggg",
                            "y*k"
                    ),
                    False
            ),

        ])
    def test(self, inputs, expected):
        assert Solution().hasMatch(*inputs) == expected
