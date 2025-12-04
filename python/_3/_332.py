from collections import defaultdict
from typing import List

"""
You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

Example 1:
Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]

Example 2:
Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 

Constraints:

1 <= tickets.length <= 300
tickets[i].length == 2
fromi.length == 3
toi.length == 3
fromi and toi consist of uppercase English letters.
fromi != toi
"""

class Solution:
    """
    Eulerian path: need to visit every edge exactly once.
    Sort destinations from a given airport in lexicographically descending order.
    Add an airport only after all its destinations have been visited
    Runtime is O(edges x log edges) (sorting)
    DFS traversal visits each edge exactly once, so the traversal is O(edges)
    """
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        destinations_by_airport = defaultdict(list)
        for departing_airport, arriving_airport in sorted(tickets, reverse=True):
            destinations_by_airport[departing_airport].append(arriving_airport)

        result = []
        traversal = ["JFK"]
        while traversal:
            while destinations_by_airport[traversal[-1]]:
                traversal.append(destinations_by_airport[traversal[-1]].pop())

            result.append(traversal.pop())

        return list(reversed(result))
