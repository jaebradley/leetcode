from _138 import Solution, Node, RecursiveSolution


class TestSolution:

    def test(self):
        head = Node(
            val=7,
            random=None,
            next=Node(
                val=13,
                next=Node(
                    val=11,
                    next=Node(
                        val=10,
                        next=Node(
                            val=1,
                            next=None
                        )
                    )
                )
            )
        )
        head.next.random = head
        head.next.next.random = head.next.next.next.next
        head.next.next.next.random = head.next.next

        for solution in (Solution(), RecursiveSolution()):
            result = solution.copyRandomList(head)
            assert result.val == 7
            assert result.random is None
            assert result.next.val == 13

        n2 = Node(2)
        n2.random = n2
        next_head = Node(
            val=1,
            next=n2,
            random=n2
        )

        for solution in (Solution(), RecursiveSolution()):
            result = solution.copyRandomList(next_head)
            assert result.val == 1
            assert result.next.val == 2
            assert result.next.next is None
            assert result.next.random == result.next
