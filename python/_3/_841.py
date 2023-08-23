from typing import List


class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        return len(rooms) == len(self.dfs(0, rooms, set()))

    def dfs(self, current_room, adjacency_list, visited_rooms):
        if current_room not in visited_rooms:
            visited_rooms.add(current_room)

            for next_room in adjacency_list[current_room]:
                self.dfs(next_room, adjacency_list, visited_rooms)

        return visited_rooms
