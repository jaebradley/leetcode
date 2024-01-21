from typing import List


class TwoPassSolution:
    """
    Initialize the starting result array as an array with length of the ratings but all 0s.

    From the start of the ratings array to the end, if the child to the direct left of the current child
    has a lower rating, assign the current child a result of 1 + the left child's result value.

    From the end of the ratings array to the start, if the child to the direct right of the current child
    has a lower rating, assign the current child a result of max(current rating, 1 + the right child's result value)
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
