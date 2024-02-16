from collections import deque
from typing import List


class UnionFindSolution:
    class UnionFind:
        def __init__(self, equations: List[List[str]], values: List[float]):
            self.parents_by_value = {}
            self.parent_multiplier_by_value = {}
            for i in range(len(equations)):
                (current_numerator, current_denominator) = equations[i]
                current_value = values[i]

                current_numerator_parent = self.find(current_numerator)
                current_denominator_parent = self.find(current_denominator)

                self.parents_by_value[current_numerator_parent] = current_denominator_parent
                self.parent_multiplier_by_value[current_numerator_parent] = \
                    self.parent_multiplier_by_value[current_denominator] * current_value \
                    / self.parent_multiplier_by_value[current_numerator]

        def find(self, value: str):
            if value in self.parents_by_value:
                initial_parent = self.parents_by_value[value]

                if value != initial_parent:
                    parent = self.find(value=initial_parent)
                    self.parents_by_value[value] = parent
                    self.parent_multiplier_by_value[value] = self.parent_multiplier_by_value[value] * \
                                                             self.parent_multiplier_by_value[initial_parent]
                else:
                    parent = initial_parent
            else:
                self.parents_by_value[value] = value
                self.parent_multiplier_by_value[value] = 1.0

                parent = value

            return parent

        def union(self, numerator: str, denominator: str) -> float:
            if numerator in self.parents_by_value and denominator in self.parents_by_value:
                numerator_parent = self.find(value=numerator)
                denominator_parent = self.find(value=denominator)

                if numerator_parent == denominator_parent:
                    return self.parent_multiplier_by_value[numerator] / self.parent_multiplier_by_value[denominator]

            return -1.0

    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        uf = UnionFindSolution.UnionFind(equations=equations, values=values)
        return [uf.union(numerator=query[0], denominator=query[1]) for query in queries]


class BfsSolution:
    """
    TLE due to lack of path "compression", but this BFS solution will work as expected.
    """

    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        graph = {}
        for (numerator, denominator), value in zip(equations, values):
            values = graph.get(numerator, {})
            values[denominator] = value
            graph[numerator] = values

            values = graph.get(denominator, {})
            values[numerator] = 1 / value
            graph[denominator] = values

        def bfs(query, graph):
            start, end = query

            if start in graph and end in graph:
                q = deque([(start, 1.0)])
                seen = {start}

                while q:
                    current_node, current_product = q.popleft()

                    if current_node == end:
                        return current_product

                    for neighbor, value in graph.get(current_node, {}).items():
                        if neighbor not in seen:
                            q.append((neighbor, current_product * value))

            return -1.0

        return [bfs(query, graph) for query in queries]
