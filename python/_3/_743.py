import heapq
import sys
from collections import defaultdict
from typing import List

"""
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 
Constraints:
1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
"""


class Solution:
    """
    Only impossible if nodes are in different connected components.
    Build adjacency list from directed edges.
    BFS from starting node using a priority queue of (time, destination node)
    Keep track of the maximum time seen for each node while BFSing in a map.
    Calculate next times for all connected nodes.
    Only add connected node if calculated next time is < current maximum time seen for that node
    Repeat the above while the queue is non-empty.
    When the queue is empty, return the maximum value seen (the mapping).
    If this value is the initialized value, then return -1, else return the value.

    Runtime: O(# of nodes + # of edges x log # of nodes). # of edges, can be, worst case, # of nodes x (# of nodes - 1).
             O(log # of edges) = O(log # of nodes x # of nodes) = O(2 log # of nodes) = O(log # of nodes).
    Memory: O(# of nodes + # of edges)
    """

    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        destination_nodes_by_starting_node = defaultdict(set)
        maximum_time_by_node = dict(map(lambda key: (key, sys.maxsize), range(1, n + 1)))
        for source_node, target_node, time in times:
            destination_nodes_by_starting_node[source_node].add((target_node, time))

        pq = [(0, k)]
        while pq:
            time_to_destination, destination_node = heapq.heappop(pq)
            maximum_time_by_node[destination_node] = min(time_to_destination, maximum_time_by_node[destination_node])

            for next_destination_node, next_destination_cost in destination_nodes_by_starting_node[destination_node]:
                next_destination_time = time_to_destination + next_destination_cost
                if next_destination_time < maximum_time_by_node[next_destination_node]:
                    heapq.heappush(pq, (next_destination_time, next_destination_node))

        maximum_time = max(maximum_time_by_node.values())
        return -1 if maximum_time == sys.maxsize else maximum_time
