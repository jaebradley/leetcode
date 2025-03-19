import pytest

from _21 import Solution, ListNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([
                 ListNode(1, ListNode(2, ListNode(4))),
                 ListNode(1, ListNode(3, ListNode(4)))],
             ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(4))))))
            ),
            ([None, None], None)
        ])
    def test(self, inputs, expected):
        assert Solution().mergeTwoLists(*inputs) == expected
