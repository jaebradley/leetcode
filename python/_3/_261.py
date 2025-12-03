import collections
import sys
from typing import List


class DFSSolution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        def dfs(parent_node, node, adjacency_list, visited):
            if node in visited:
                return False

            visited.add(node)
            for next_node in adjacency_list.get(node, set()):
                # Undirected graphs will have both vertices in the edge map to each other
                if next_node != parent_node:
                    if not dfs(node, next_node, adjacency_list, visited):
                        return False
            return True

        adjacency_list = collections.defaultdict(set)
        for first_vertex, second_vertex in edges:
            adjacency_list[first_vertex].add(second_vertex)
            adjacency_list[second_vertex].add(first_vertex)
        visited_nodes = set()
        return dfs(-sys.maxsize, 0, adjacency_list, visited_nodes) and len(visited_nodes) == n

class BFSSolution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        adjacency_list = collections.defaultdict(set)
        for first_vertex, second_vertex in edges:
            adjacency_list[first_vertex].add(second_vertex)
            adjacency_list[second_vertex].add(first_vertex)
        visited_nodes = set()
        q = collections.deque([(0, -sys.maxsize)])
        while q:
            node, parent_node = q.pop()
            if node in visited_nodes:
                return False

            visited_nodes.add(node)
            for next_node in adjacency_list.get(node, set()):
                if parent_node != next_node:
                    q.appendleft((next_node, node))
        return len(visited_nodes) == n
