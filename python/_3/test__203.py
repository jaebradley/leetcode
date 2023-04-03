import pytest

from _203 import Solution, ListNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([None, 1], None),
            ([
                 ListNode(7, ListNode(7, ListNode(7, ListNode(7)))),
                 7
             ], None),
            ([
                 ListNode(7, ListNode(6, ListNode(5, ListNode(4)))),
                 7
             ], ListNode(6, ListNode(5, ListNode(4)))),
            ([
                 ListNode(6, ListNode(5, ListNode(4, ListNode(7)))),
                 7
             ], ListNode(6, ListNode(5, ListNode(4)))),
            ([
                 ListNode(6, ListNode(6, ListNode(6, ListNode(6)))),
                 7
             ], ListNode(6, ListNode(6, ListNode(6, ListNode(6))))),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().removeElements(*inputs)
