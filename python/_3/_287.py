from typing import List


class BinarySearchSolution:
    """
    Idea is that if there's a duplicate value in a list of values from 1-n, then the number of values <= x will be
    greater than x.

    Consider [1, 1, 2, 3, 4, 5].
    There are 6 values, with the range of values [1, 5] inclusive
    Since there are 6 values <= 5, we know that it contains duplicate values (obviously).
    If we take the subrange [1, 3] inclusive, we count that there are 4 values <= 3 in the entire list.
    This means that the duplicate value is <= 3.
    We can continue binary searching across this space until we find the actual duplicate value.
    """
    def findDuplicate(self, nums: List[int]) -> int:
        min_value, max_value = 1, len(nums) - 1
        while min_value < max_value:
            target_value = (min_value + max_value) // 2
            count_of_numbers_less_than_or_equal_target = sum(num <= target_value for num in nums)
            if count_of_numbers_less_than_or_equal_target > target_value:
                duplicate = target_value
                max_value = target_value - 1
            else:
                min_value = target_value + 1

        return duplicate

class LinkedListCycleSolution:
    """
    Idea is that the input list can be thought of as a linked list where each node is the list element value.
    There is a duplicate value, so there's a cycle in the linked list where the list comes back to a previously seen value.
    """
    def findDuplicate(self, nums: List[int]) -> int:
        slow, fast = nums[0], nums[0]
        while True:
            fast = nums[nums[fast]]
            slow = nums[slow]

            # intersection point
            if slow == fast:
                break

        # reset slow pointer to start of list to find start of cycle
        slow = nums[0]
        while slow != fast:
            fast = nums[nums[fast]]
            slow = nums[slow]

        return slow

