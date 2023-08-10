import pytest

from _2130 import Solution, ListNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([ListNode(val=5, next=ListNode(4, next=ListNode(2, next=ListNode(1))))], 6),
            ([ListNode(val=4, next=ListNode(val=2, next=ListNode(val=2, next=ListNode(val=3))))], 7),
            ([ListNode(val=1, next=ListNode(100000))], 100001)
        ])
    def test(self, inputs, expected):
        assert Solution().pairSum(*inputs) == expected
