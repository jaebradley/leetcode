import pytest

from _92 import Solution, ListNode


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([
                 ListNode(val=1,
                          next=ListNode(val=2, next=ListNode(val=3, next=ListNode(val=4, next=ListNode(val=5))))),
                 2,
                 4],
             ListNode(val=1, next=ListNode(val=4, next=ListNode(val=3, next=ListNode(val=2, next=ListNode(val=5)))))),
            ([
                 ListNode(val=5),
                 1,
                 1],
             ListNode(val=5)),
            ([
                 ListNode(val=3, next=ListNode(5)),
                 1,
                 2],
             ListNode(val=5, next=ListNode(val=3))),
        ])
    def test(self, arguments, expected):
        assert Solution().reverseBetween(*arguments) == expected
