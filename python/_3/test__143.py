import pytest

from _143 import Solution, ListNode


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            (
                    ListNode(1, ListNode(2, ListNode(3, ListNode(4)))),
                    ListNode(1, ListNode(4, ListNode(2, ListNode(3))))
            ),
            (
                    ListNode(1, ListNode(2, ListNode(3))),
                    ListNode(1, ListNode(3, ListNode(2)))
            ),
            (
                    ListNode(1),
                    ListNode(1)
            ),
            (
                    None,
                    None
            )
        ])
    def test(self, input, expected):
        assert Solution().reorderList(input) == expected
