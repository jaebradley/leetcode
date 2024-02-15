import itertools
from typing import List


class Solution:
    class UnionFind:
        def __init__(self, values: List[str]):
            self.parents_by_value = dict(map(lambda value: [value, value], values))
            self.parent_multiplier_by_value = dict(map(lambda value: [value, 1], values))

        def find_parent(self, value: str) -> str:
            parent = self.parents_by_value.get(value)
            if parent != value:
                parent = self.find_parent(parent)
                self.parents_by_value[value] = parent
            return parent

        def find_parent_and_augment_multiplier(self, value: str, multiplier: float) -> str:
            parent = self.parents_by_value.get(value)
            if parent != value:
                parent = self.find_parent_and_augment_multiplier(parent, multiplier)
                self.parents_by_value[value] = parent
                self.parent_multiplier_by_value[value] /= multiplier
            return parent

        def union(self, numerator: str, denominator: str, value: float):
            numerator_parent, denominator_parent = self.find_parent(numerator), self.find_parent(denominator)
            if numerator_parent != denominator_parent:
                self.parents_by_value[denominator_parent] = numerator_parent
                self.find_parent_and_augment_multiplier(denominator, value)

        def calculate_equation(self, numerator: str, denominator: str):
            numerator_parent, denominator_parent = self.find_parent(numerator), self.find_parent(denominator)
            if numerator_parent is None or denominator_parent is None or numerator_parent != denominator_parent:
                return -1

            return self.parent_multiplier_by_value[numerator] / self.parent_multiplier_by_value[denominator]

    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        result = []
        uf = Solution.UnionFind(set(itertools.chain.from_iterable(equations)))
        for index, equation in enumerate(equations):
            uf.union(numerator=equation[0], denominator=equation[1], value=values[index])
        for query in queries:
            result.append(uf.calculate_equation(numerator=query[0], denominator=query[1]))
        return result
