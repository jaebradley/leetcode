"""
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Example 1:
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

Constraints:
2 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
"""
import sys
from collections import defaultdict, deque
from copy import copy
from typing import List


class BFSSolution:
    """
    Approach:
    Use BFS to traverse the graph level by level, where each level represents the number of stops made.
    Keep track of current cost to arrive at a given city.
    For each element in a given level, do the following:
    Update the cost for the current city if the current cost is lower than the previously recorded cost.
    Otherwise, explore all the neighboring cities (i.e., cities that can be reached directly from the current city).
    Only explore a neighboring city if the cost to reach that city through the current city is lower than the previously recorded cost for that neighboring city.
    Update the cost of the neighboring city and add it to the queue for further exploration.
    """
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adjacency_list = defaultdict(set)
        for start_city, end_city, price in flights:
            adjacency_list[start_city].add((end_city, price))

        cost_by_city = defaultdict(lambda: sys.maxsize)
        q = deque([(src, 0)])
        current_level = 0
        while q and current_level <= k:
            for _ in range(len(q)):
                current_city, current_cost = q.popleft()

                for neighbor, price in adjacency_list[current_city]:
                    next_price = current_cost + price
                    if next_price < cost_by_city[neighbor]:
                        cost_by_city[neighbor] = next_price
                        q.append((neighbor, next_price))

            current_level += 1

        return -1 if cost_by_city[dst] == sys.maxsize else cost_by_city[dst]


class BellmanFordSolution:
    """
    Approach:
    Keep track of cost by city.
    Iterate k + 1 times (to account for 0 stops).
    For each flight, check to see if the cost to reach the destination city through the starting city is cheaper than the previously recorded cost for the destination city.
    If so, update the cost for the destination city.
    At the end, return the cost for the destination city, or -1 if it is still set to sys.maxsize.
    """
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        cost_by_city = defaultdict(lambda: sys.maxsize)
        cost_by_city[src] = 0

        for _ in range(k + 1):
            current_level_cost_by_city = copy(cost_by_city)

            for start_city, end_city, price in flights:
                current_level_cost_by_city[end_city] = min(cost_by_city[start_city] + price, current_level_cost_by_city[end_city])

            cost_by_city = current_level_cost_by_city

        return -1 if cost_by_city[dst] == sys.maxsize else cost_by_city[dst]
