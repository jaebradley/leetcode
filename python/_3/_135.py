from typing import List


class TwoPassSolution:
    """
    Initialize the starting result array as an array with length of the ratings but all 0s.

    From the start of the ratings array to the end, if the child to the direct left of the current child
    has a lower rating, assign the current child a result of 1 + the left child's result value.

    From the end of the ratings array to the start, if the child to the direct right of the current child
    has a lower rating, assign the current child a result of max(current rating, 1 + the right child's result value).

    This is a greedy method with O(n) time complexity as we make two passes through the array, and O(n) space complexity
    as the number of entries in the "result" array is the same size as the input ratings array.

    For my own notes: a greedy algorithm makes choices that seem optimal at the moment.
    """

    def candy(self, ratings: List[int]) -> int:
        results = [1] * len(ratings)

        for index, rating in enumerate(ratings[1:]):
            # 0th index is 1th index in ratings since enumerating over list ignoring first element
            if rating > ratings[index]:
                results[1 + index] = 1 + results[index]

        for index in range(len(ratings) - 2, -1, -1):
            current_rating = ratings[index]
            right_rating = ratings[index + 1]

            if current_rating > right_rating:
                results[index] = max(results[index], 1 + results[index + 1])

        return sum(results)

class OnePassSolution:
    """
    This one-pass greedy approach uses three variables - up, down, and peak.

    Up counts the number of children that have increasing ratings from the last child.
    Down counts the number of children that have decreasing ratings from the last child.
    Peak counts the last highest point in an increasing sequence.

    Algorithm:
    * Initialize current candy count to 1
    * Initialize up, down, and peak to 0
    * For each pair of adjacent children:
    * If rating increases, add 1 to up and peak. Set down to 0. Add 1 + up to the current candy count as the current
    child must have one more candy than the previous child
    * If the rating is the same, set up, down, and peak to 0. Add 1 to the current candy count because the current child
    must have at least one candy.
    * If the rating decreases, set up to 0. Increment down by 1. Add the down value to the current candy count (since
    we need to add candy for the current child, and previous child, if decreasing sequence).

    If the peak value is less than the down value, we need to increase
    the current candy count by 1. This is because the peak child should get additional candies if the decrease sequence
    is longer than the previous increasing sequence.
    """
    def candy(self, ratings: List[int]) -> int:
        if not ratings:
            return 0

        count, up, down, peak = 1, 0, 0, 0

        for current_child_index in range(len(ratings) - 1):
            next_child_index = 1 + current_child_index
            current_child_rating, next_child_rating = ratings[current_child_index], ratings[next_child_index]

            if current_child_rating < next_child_rating:
                up += 1
                peak = up
                down = 0

                count += 1 + up

            elif current_child_rating == next_child_rating:
                up, down, peak = 0, 0, 0
                count += 1

            else:
                up = 0
                down += 1
                count += down

                if peak < down:
                    count += 1

        return count




