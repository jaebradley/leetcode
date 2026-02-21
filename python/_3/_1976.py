"""
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections.
The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel.
You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 10^9 + 7.

Example 1:
Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6

Example 2:
Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.

Constraints:
* 1 <= n <= 200
* n - 1 <= roads.length <= n * (n - 1) / 2
* roads[i].length == 3
* 0 <= ui, vi <= n - 1
* 1 <= timei <= 10^9
* ui != vi
* There is at most one road connecting any two intersections.
* You can reach any intersection from any other intersection.
"""
import heapq
from collections import defaultdict
from typing import List


class Solution:
    """
    Approach:
    Min priority queue of (current trip duration, last intersection).
    Adjacency list of intersection to neighboring intersections.
    Keep hash map of intersection to smallest cost to reach intersection.
    (or keep separate visited set? a solution with a cycle should never lead to the min cost?)
    Once n - 1th intersection is popped off the priority queue, the smallest amount of time to go from
    intersection 0 to intersection n - 1 has been identified.
    The only other possible values are queue elements with the same trip duration. These elements should be at the
    front of the queue.
    """

    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        modifier = 10**9 + 7

        adjacency_list = defaultdict(set)

        for start, end, time in roads:
            adjacency_list[start].add((end, time))
            adjacency_list[end].add((start, time))

        minimum_distances_by_node = defaultdict(lambda: float("inf"))
        minimum_pathways_by_node = defaultdict(lambda: 0)

        minimum_distances_by_node[0] = 0
        minimum_pathways_by_node[0] = 1

        q = [(0, 0)]
        while q:
            current_time, current_intersection = heapq.heappop(q)
            current_minimum_distance = minimum_distances_by_node[current_intersection]

            if current_time <= current_minimum_distance:
                for next_intersection, travel_time in adjacency_list[current_intersection]:
                    next_travel_time = current_minimum_distance + travel_time
                    current_minimum_next_distance = minimum_distances_by_node[next_intersection]
                    if next_travel_time < current_minimum_next_distance:
                        minimum_distances_by_node[next_intersection] = next_travel_time
                        minimum_pathways_by_node[next_intersection] = minimum_pathways_by_node[current_intersection]
                        heapq.heappush(q, (next_travel_time, next_intersection))
                    elif next_travel_time == current_minimum_next_distance:
                        minimum_pathways_by_node[next_intersection] = (minimum_pathways_by_node[next_intersection] + minimum_pathways_by_node[current_intersection]) % modifier

        return minimum_pathways_by_node[n - 1]
