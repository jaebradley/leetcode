from typing import List


class Solution:
    """
    Keep track of a "score" at each index.
    If the value of an index is greater than 8 increase the score.
    Otherwise, decrease the score.

    If the current score is greater than 0, then the longest strictly positive "streak" is from the start of array to
    the current index, i.e. index + 1 in length.

    If the current score is less than 0, we want to find the first index seen with a score of current score - 1.
    The interval from the index with score of current score - 1 to our current score, should be an interval where the
    "score" value was increasing.
    """

    def longestWPI(self, hours: List[int]) -> int:
        max_length = current_score = 0
        scores = {}

        for ending_index in range(len(hours)):
            if hours[ending_index] > 8:
                current_score += 1
            else:
                current_score -= 1

            if current_score > 0:
                max_length = ending_index + 1
            else:
                if current_score not in scores:
                    scores[current_score] = ending_index

                last_seen_score_complement_index = scores.get(current_score - 1)
                if last_seen_score_complement_index is not None:
                    max_length = max(max_length, ending_index - last_seen_score_complement_index)

        return max_length
