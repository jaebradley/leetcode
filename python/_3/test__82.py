import pytest

from _82 import Solution, ListNode


class TestSolution:
    @pytest.mark.parametrize(
        "list, expected",
        [
            (
                    ListNode(val=1,
                             next=ListNode(val=2,
                                           next=ListNode(val=3,
                                                         next=ListNode(val=3,
                                                                       next=ListNode(val=4,
                                                                                     next=ListNode(val=4,
                                                                                                   next=ListNode(
                                                                                                       val=5))))))),
                    ListNode(val=1, next=ListNode(val=2, next=ListNode(val=5)))
            ),
            (
                    ListNode(val=1,
                             next=ListNode(val=1,
                                           next=ListNode(val=1,
                                                         next=ListNode(val=2,
                                                                       next=ListNode(val=3))))),
                    ListNode(val=2, next=ListNode(val=3))
            ),
            (
                    ListNode(val=1,
                             next=ListNode(val=1,
                                           next=ListNode(val=1))),
                    None
            ),
            (
                    ListNode(val=1),
                    ListNode(val=1)
            ),
        ])
    def test(self, list, expected):
        assert Solution().deleteDuplicates(list) == expected
