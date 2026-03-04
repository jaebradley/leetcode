"""
You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

 Example 1:
Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.

Example 2:
Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000

Example 3:
Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.

Constraints:
2 <= n <= 10^4
0 <= start, end < n
start != end
0 <= a, b < n
a != b
0 <= succProb.length == edges.length <= 2*10^4
0 <= succProb[i] <= 1
There is at most one edge between every two nodes.
"""
import heapq
from collections import defaultdict
from typing import List


class Solution:
    """
    Edges are undirected so adjacency list needs to be built in both directions.
    Use Dijkstra i.e a priority queue.
    Since we're trying to maximize the probability value, the priority queue is best represented as a max heap.
    Keep track of already seen weights for a given node - initialize these weights to 0 in a mapping of weights by node.
    Initialize the priority queue with (1, starting node)
    While the priority queue is non-empty:
      Heap pop the top element off of the queue.
      Insert the max of the current node weight or the element's weight.
      For all connected elements, calculate the next probability for each element.
        If the calculated next probability is greater than the current stored probability, enqueue the next
        probability and the next element

    When the priority queue is exhausted, return weights by node for the end node.

    Time: O((# of nodes + # of edges) x log(# of nodes))

    Space: O(# of nodes + # of edges)
    * Adjacency list contains data for all edges
    * Probabilities by node contain data for each node
    """
    def maxProbability(self,
                       n: int,
                       edges: List[List[int]],
                       succProb: List[float],
                       start_node: int,
                       end_node: int) -> float:
        adjacency_list = defaultdict(set)
        for index, (first_node, second_node) in enumerate(edges):
            probability = succProb[index]
            adjacency_list[first_node].add((second_node, probability))
            adjacency_list[second_node].add((first_node, probability))

        probabilities_by_node = defaultdict(lambda: 0)
        probabilities_by_node[start_node] = 1
        pq = [(-1, start_node)]
        while pq:
            current_probability, current_node = heapq.heappop(pq)
            probabilities_by_node[current_node] = max(-current_probability, probabilities_by_node[current_node])

            for neighbor, neighbor_probability in adjacency_list[current_node]:
                next_probability = current_probability * neighbor_probability
                if -next_probability > probabilities_by_node[neighbor]:
                    heapq.heappush(pq, (next_probability, neighbor))

            # Optimization that increases Leetcode runtime. Guarantees that each node is processed at most once.
            # Since probabilities will always be at least equal to the current largest probability, we can safely
            # not process the same node again.
            del adjacency_list[current_node]

        return probabilities_by_node[end_node]
