import pytest

from _23 import Solution, ListNode


class TestSolution:
    @pytest.mark.parametrize(
        "lists, expected",
        [
            ([
                ListNode(1, ListNode(4, ListNode(5))),
                ListNode(1, ListNode(3, ListNode(4))),
                ListNode(2, ListNode(6)),
            ],
            ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(4, ListNode(5, ListNode(6))))))))
            ),
            ([[]], None),
            ([], None),
        ])
    def test(self, lists, expected):
        assert Solution().mergeKLists(lists) == expected
