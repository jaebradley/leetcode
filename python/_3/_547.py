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
