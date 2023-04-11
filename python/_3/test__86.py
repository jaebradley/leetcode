import pytest

from _86 import Solution, ListNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([
                 ListNode(1, ListNode(4, ListNode(3, ListNode(2, ListNode(5, ListNode(2)))))),
                 3
             ],
             ListNode(1, ListNode(2, ListNode(2, ListNode(4, ListNode(3, ListNode(5))))))),
            ([
                 ListNode(2, ListNode(1)),
                 2
             ],
             ListNode(1, ListNode(2))),
            ([
                 ListNode(10, ListNode(9, ListNode(8, ListNode(7, ListNode(6, ListNode(5)))))),
                 5
             ],
             ListNode(10, ListNode(9, ListNode(8, ListNode(7, ListNode(6, ListNode(5))))))),
            ([
                 ListNode(10, ListNode(9, ListNode(8, ListNode(7, ListNode(6, ListNode(5)))))),
                 4
             ],
             ListNode(10, ListNode(9, ListNode(8, ListNode(7, ListNode(6, ListNode(5))))))),
            ([
                 ListNode(10, ListNode(9, ListNode(8, ListNode(7, ListNode(6, ListNode(5)))))),
                 6
             ],
             ListNode(5, ListNode(10, ListNode(9, ListNode(8, ListNode(7, ListNode(6))))))),
        ])
    def test(self, inputs, expected):
        assert expected == Solution().partition(*inputs)
