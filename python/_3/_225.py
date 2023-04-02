"""
https://leetcode.com/problems/implement-stack-using-queues/description/
"""

"""
Approach:

On push, push the value to the empty queue.
From the non-empty queue, push all the elements from the front of the queue to the back of the single-element queue.
"""

from collections import deque


class MyStack:

    def __init__(self):
        self.queue_to_push_to = deque([])
        self.values_queue = deque([])

    def push(self, x: int) -> None:
        self.queue_to_push_to.append(x)
        while self.values_queue:
            self.queue_to_push_to.append(self.values_queue.popleft())

        self.values_queue = self.queue_to_push_to
        self.queue_to_push_to = deque([])

    def pop(self) -> int:
        return self.values_queue.popleft()

    def top(self) -> int:
        return self.values_queue[0]

    def empty(self) -> bool:
        return 0 >= len(self.values_queue)
