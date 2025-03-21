import pytest

from _141 import Solution, ListNode

simple_cycle = ListNode(1, ListNode(2))
simple_cycle.next.next = simple_cycle


class TestSolution:
    @pytest.mark.parametrize(
        "head, expected",
        [
            (ListNode(1), False),
            (simple_cycle, True),
        ])
    def test(self, head, expected):
        assert Solution().hasCycle(head) == expected
