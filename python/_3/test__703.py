import pytest

from _703 import KthLargest


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    ([3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]),
                    [None, 4, 5, 5, 8, 8]

            ),
            (
                    ([4, [7, 7, 7, 7, 8, 3]], [2], [10], [9], [9]),
                    [None, 7, 7, 7, 8]

            ),
            (
                ([1,[]],[-3],[-2],[-4],[0],[4]),
                [None, -3, -2, -2, 0, 4]
            ),
        ])
    def test(self, inputs, expected):
        constructor_arguments = inputs[0]
        instance = KthLargest(*constructor_arguments)
        for index in range(1, len(inputs)):
            assert instance.add(*inputs[index]) == expected[index]
