import pytest

from _19 import Solution, ListNode


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([
                 ListNode(val=1,
                          next=ListNode(val=2, next=ListNode(val=3, next=ListNode(val=4, next=ListNode(val=5))))),
                 2],
             ListNode(val=1, next=ListNode(val=2, next=ListNode(val=3, next=ListNode(val=5))))
            ),
            ([
                 ListNode(val=1),
                 1],
             None),
            ([
                 ListNode(val=1, next=ListNode(2)),
                 1],
             ListNode(val=1))
        ])
    def test(self, arguments, expected):
        assert Solution().removeNthFromEnd(*arguments) == expected
