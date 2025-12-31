import heapq
from collections import defaultdict
from typing import List

"""
You are given an integer c representing c power stations, each with a unique identifier id from 1 to c (1‑based indexing).

These stations are interconnected via n bidirectional cables, represented by a 2D array connections, where each element connections[i] = [ui, vi] indicates a connection between station ui and station vi. Stations that are directly or indirectly connected form a power grid.

Initially, all stations are online (operational).

You are also given a 2D array queries, where each query is one of the following two types:

[1, x]: A maintenance check is requested for station x. If station x is online, it resolves the check by itself. If station x is offline, the check is resolved by the operational station with the smallest id in the same power grid as x. If no operational station exists in that grid, return -1.

[2, x]: Station x goes offline (i.e., it becomes non-operational).

Return an array of integers representing the results of each query of type [1, x] in the order they appear.

Note: The power grid preserves its structure; an offline (non‑operational) node remains part of its grid and taking it offline does not alter connectivity.

 

Example 1:

Input: c = 5, connections = [[1,2],[2,3],[3,4],[4,5]], queries = [[1,3],[2,1],[1,1],[2,2],[1,2]]

Output: [3,2,3]

Explanation:



Initially, all stations {1, 2, 3, 4, 5} are online and form a single power grid.
Query [1,3]: Station 3 is online, so the maintenance check is resolved by station 3.
Query [2,1]: Station 1 goes offline. The remaining online stations are {2, 3, 4, 5}.
Query [1,1]: Station 1 is offline, so the check is resolved by the operational station with the smallest id among {2, 3, 4, 5}, which is station 2.
Query [2,2]: Station 2 goes offline. The remaining online stations are {3, 4, 5}.
Query [1,2]: Station 2 is offline, so the check is resolved by the operational station with the smallest id among {3, 4, 5}, which is station 3.
Example 2:

Input: c = 3, connections = [], queries = [[1,1],[2,1],[1,1]]

Output: [1,-1]

Explanation:

There are no connections, so each station is its own isolated grid.
Query [1,1]: Station 1 is online in its isolated grid, so the maintenance check is resolved by station 1.
Query [2,1]: Station 1 goes offline.
Query [1,1]: Station 1 is offline and there are no other stations in its grid, so the result is -1.
 

Constraints:

1 <= c <= 105
0 <= n == connections.length <= min(105, c * (c - 1) / 2)
connections[i].length == 2
1 <= ui, vi <= c
ui != vi
1 <= queries.length <= 2 * 105
queries[i].length == 2
queries[i][0] is either 1 or 2.
1 <= queries[i][1] <= c
"""


class Solution:
    """
    Initialize each station as its parent.

    For each connection, union the two stations.

    After this step, we should have 1 or more power grids with fully operational stations.

    Each parent also has a set of offline stations, and a min heap of operational station IDs contained in the power
    grid.

    Processing 1 queries:
    * Get parent for station
    * Check that station is active in parent's set of offline stations
    * If active, return the station, else return the smallest operational station in the min heap.
    * If the min heap is empty, return -1. As part of this process, will involve popping off the min heap.

    Processing 2 queries:
    * Get parent for station
    * Add station to parent's set of offline stations

    Runtime: O(# of stations x log(# of stations))
    Space: O(# of stations)
    """
    def processQueries(self, c: int, connections: List[List[int]], queries: List[List[int]]) -> List[int]:
        parents_by_station = dict(map(lambda station: [station, station], range(1, c + 1)))
        stations_by_powergrid = dict(map(lambda station: [station, [station]], range(1, c + 1)))

        def find_parent(station):
            parent = parents_by_station[station]
            if parent != station:
                parents_by_station[station] = find_parent(parent)

            return parents_by_station[station]

        for first_station, second_station in connections:
            first_station_parent = find_parent(first_station)
            second_station_parent = find_parent(second_station)

            if first_station_parent != second_station_parent:
                first_station_size = len(stations_by_powergrid[first_station_parent])
                second_station_size = len(stations_by_powergrid[second_station_parent])

                if first_station_size > second_station_size:
                    parents_by_station[second_station_parent] = first_station_parent
                    stations_by_powergrid[first_station_parent].extend(stations_by_powergrid[second_station_parent])
                else:
                    parents_by_station[first_station_parent] = second_station_parent
                    stations_by_powergrid[second_station_parent].extend(stations_by_powergrid[first_station_parent])

        inactive_stations_by_parent = defaultdict(set)
        smallest_operational_stations_by_parent = defaultdict(list)

        for parent in set(parents_by_station.values()):
            powergrid = list(set(stations_by_powergrid[parent]))
            heapq.heapify(powergrid)
            smallest_operational_stations_by_parent[parent] = powergrid

        def find_smallest_station(s):
            p = find_parent(s)
            inactive_stations = inactive_stations_by_parent[p]
            if s in inactive_stations:
                candidates = smallest_operational_stations_by_parent[p]
                while candidates:
                    candidate = candidates[0]
                    if candidate in inactive_stations:
                        heapq.heappop(candidates)
                    else:
                        return candidate

                return -1
            else:
                return s

        results = []
        for query_type, station in queries:
            if query_type == 1:
                results.append(find_smallest_station(station))
            else:
                inactive_stations_by_parent[find_parent(station)].add(station)

        return results
