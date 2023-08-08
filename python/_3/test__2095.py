import pytest

from _2095 import Solution, ListNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    [ListNode(val=1, next=ListNode(3, next=ListNode(4, next=ListNode(7, next=ListNode(1, next=ListNode(2, next=ListNode(6)))))))],
                    ListNode(val=1, next=ListNode(3, next=ListNode(4, next=ListNode(1, next=ListNode(2, next=ListNode(6))))))),
            ([ListNode(val=1, next=ListNode(2, next=ListNode(val=3, next=ListNode(4))))],
             ListNode(val=1, next=ListNode(2, next=ListNode(4)))),
            ([ListNode(val=2, next=ListNode(1))],
             ListNode(val=2))
        ])
    def test(self, inputs, expected):
        assert Solution().deleteMiddle(*inputs) == expected
