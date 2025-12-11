"""
You are given a 2D integer array intervals, where intervals[i] = [lefti, righti] describes the ith interval starting at lefti and ending at righti (inclusive). The size of an interval is defined as the number of integers it contains, or more formally righti - lefti + 1.

You are also given an integer array queries. The answer to the jth query is the size of the smallest interval i such that lefti <= queries[j] <= righti. If no such interval exists, the answer is -1.

Return an array containing the answers to the queries.



Example 1:

Input: intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
Output: [3,3,1,4]
Explanation: The queries are processed as follows:
- Query = 2: The interval [2,4] is the smallest interval containing 2. The answer is 4 - 2 + 1 = 3.
- Query = 3: The interval [2,4] is the smallest interval containing 3. The answer is 4 - 2 + 1 = 3.
- Query = 4: The interval [4,4] is the smallest interval containing 4. The answer is 4 - 4 + 1 = 1.
- Query = 5: The interval [3,6] is the smallest interval containing 5. The answer is 6 - 3 + 1 = 4.
Example 2:

Input: intervals = [[2,3],[2,5],[1,8],[20,25]], queries = [2,19,5,22]
Output: [2,-1,4,6]
Explanation: The queries are processed as follows:
- Query = 2: The interval [2,3] is the smallest interval containing 2. The answer is 3 - 2 + 1 = 2.
- Query = 19: None of the intervals contain 19. The answer is -1.
- Query = 5: The interval [2,5] is the smallest interval containing 5. The answer is 5 - 2 + 1 = 4.
- Query = 22: The interval [20,25] is the smallest interval containing 22. The answer is 25 - 20 + 1 = 6.


Constraints:

1 <= intervals.length <= 105
1 <= queries.length <= 105
intervals[i].length == 2
1 <= lefti <= righti <= 107
1 <= queries[j] <= 107
"""
import heapq
from typing import List


class Solution:
    """
    Sort intervals and queries.
    Sort intervals in descending starting index order to help with the runtime of pop later.
    Sort queries in ascending order, keeping the query index via enumerate.
    Iterate over the sorted queries and remove any intervals that are no longer "active" (i.e. the interval end is before the start of the query).
    These intervals should no longer be valid anymore since all remaining queries will be greater than the current query.
    If the last element of the sorted intervals (since it was descending order, this is the interval with the smallest starting index) has a valid starting index, pop it off the array.
    This also means that it won't be in the sorted intervals array anymore, so it won't undergo additional iteration.
    If the interval is valid for the current query add it to the heap.
    """

    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        sorted_intervals = sorted(intervals, key=lambda interval: interval[0], reverse=True)
        sorted_queries = sorted(enumerate(queries), key=lambda query: query[1])
        result = [-1] * len(queries)
        active_intervals = []
        for query_index, query in sorted_queries:
            while active_intervals and query > active_intervals[0][1]:
                heapq.heappop(active_intervals)

            while sorted_intervals and query >= sorted_intervals[-1][0]:
                interval_start, interval_end = sorted_intervals.pop()
                if query <= interval_end:
                    heapq.heappush(active_intervals, (interval_end - interval_start + 1, interval_end))

            if active_intervals:
                result[query_index] = active_intervals[0][0]

        return result
