import pytest

from _206 import Solution, ListNode


class TestSolution:
    @pytest.mark.parametrize(
        "head, expected",
        [
            (ListNode(1, ListNode(2, ListNode(3, ListNode(4)))),
             ListNode(4, ListNode(3, ListNode(2, ListNode(1))))),
            (ListNode(1, ListNode(2)),
             ListNode(2, ListNode(1))),
            (None, None)
        ])
    def test(self, head, expected):
        assert Solution().reverseList(head) == expected
