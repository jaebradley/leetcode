from typing import List


class DfsSolution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        visited = set()
        groups = 0

        for city in range(len(isConnected)):
            if city not in visited:
                groups += 1
                self.dfs(city, isConnected, visited)

        return groups

    def dfs(self, current_city, adjacency_matrix, visited):
        if current_city not in visited:
            visited.add(current_city)

            for connected_city, is_connected in enumerate(adjacency_matrix[current_city]):
                if is_connected:
                    self.dfs(connected_city, adjacency_matrix, visited)


class UnionFindSolution:
    class UnionFind:
        def __init__(self, cities_count: int):
            self.parents_by_cities = dict(map(lambda city: [city, city], range(cities_count)))
            self.count = cities_count

        def find_parent(self, city: int) -> int:
            current_parent = self.parents_by_cities.get(city)
            if current_parent != city:
                root_parent = self.find_parent(current_parent)
                self.parents_by_cities[city] = root_parent
            return self.parents_by_cities[city]

        def union(self, first_city: int, second_city: int) -> None:
            first_city_parent, second_city_parent = self.find_parent(first_city), self.find_parent(second_city)
            if first_city_parent != second_city_parent:
                self.parents_by_cities[second_city_parent] = first_city_parent
                self.count -= 1

    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        union_find = UnionFindSolution.UnionFind(len(isConnected))
        for current_city, connected_cities in enumerate(isConnected):
            for connected_city, is_connected in enumerate(connected_cities):
                if is_connected:
                    union_find.union(current_city, connected_city)

        return union_find.count
