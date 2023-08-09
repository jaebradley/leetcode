import pytest

from _328 import Solution, ListNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    [ListNode(val=1, next=ListNode(2, next=ListNode(3, next=ListNode(4, next=ListNode(5)))))],
                    ListNode(val=1, next=ListNode(3, next=ListNode(5, next=ListNode(2, next=ListNode(4)))))),
            ([ListNode(val=1)], ListNode(val=1)),
            ([ListNode(val=1, next=ListNode(2))], ListNode(val=1, next=ListNode(2)))
        ])
    def test(self, inputs, expected):
        assert Solution().oddEvenList(*inputs) == expected
