from collections import deque
from typing import List


class Solution:
    """
    Topological sort to get the richest people to the least rich.

    Can think of each pair of values in the "richer" array as a directed graph node edge, where the
    first value is the starting node and the second value is the ending node.

    Topologically sorted list will look something like
    [[richest], [person 1 with 2nd richest level, person 2 with 2nd richest level],...,[poorest]].

    We want a result array where the ith entry represents the least quiet (loudest) person that
    has the same richness level as the ith person.

    As one iterates over each element in the topologically sorted list, keep track of the seen elements (people), and
    the loudest person seen so far. If the person to add is louder than the loudest person, then update the loudest
    person, and add loudest person seen so-far to output array (this should also be the people that are as rich, or
    richer than the currently evaluated person).

    The output of the previous calculation should be an array of values where the value at each index represents the
    loudest person at that level of wealth.

    Combine this (again) with the topologically sorted list, and for each element / person in the topologically-sorted
    list, for that person's index in the output list, use the person's loudest person seen value at the corresponding
    index. Can also do this "in-time" when calculating the loudest person seen.
    """

    def loudAndRich(self, richer: List[List[int]], quiet: List[int]) -> List[int]:
        output = list(range(len(quiet)))
        destination_nodes_by_starting_node = {}
        indegrees_by_nodes = dict(map(lambda x: [x, 0], range(len(quiet))))
        for (starting_node, destination_node) in richer:
            destination_nodes = destination_nodes_by_starting_node.get(starting_node, set())
            destination_nodes.add(destination_node)
            destination_nodes_by_starting_node[starting_node] = destination_nodes

            destination_node_indegree = indegrees_by_nodes.get(destination_node, 0)
            indegrees_by_nodes[destination_node] = 1 + destination_node_indegree

        zero_indegree_nodes = deque(map(lambda e: e[0],
                                        filter(lambda e: 0 == e[1],
                                               indegrees_by_nodes.items())))

        while zero_indegree_nodes:
            node = zero_indegree_nodes.popleft()

            for destination_node in destination_nodes_by_starting_node.get(node, set()):
                loudest_for_node = quiet[output[node]]
                loudest_for_destination_node = quiet[output[destination_node]]

                if loudest_for_node < loudest_for_destination_node:
                    output[destination_node] = output[node]

                indegrees_by_nodes[destination_node] -= 1
                if 0 == indegrees_by_nodes[destination_node]:
                    zero_indegree_nodes.append(destination_node)

        return output

    """
    Map all starting nodes to destination nodes.
    Count all indegrees for each node.
    Identify all nodes with an indegree of 0 and add them to a list.
    
    While indegree of 0 list is not empty
    Add all elements in list to output list as a set of people with the same richness level.
    For each of the people that are added, find all destination nodes, and decrement the indegrees for those 
    destination nodes.
    Remove the added people from the indegree count mapping.
    Iterate over all the remaining indegree counts, and add all the nodes that have an indegree count of 0 to the 
    indegree of 0 list.
    """

    def topologically_sort(self, richer: List[List[int]], people_count: int) -> List[int]:
        destination_nodes_by_starting_node = {}
        indegrees_by_nodes = dict(map(lambda x: [x, 0], range(people_count)))
        for (starting_node, destination_node) in richer:
            destination_nodes = destination_nodes_by_starting_node.get(starting_node, set())
            destination_nodes.add(destination_node)
            destination_nodes_by_starting_node[starting_node] = destination_nodes

            destination_node_indegree = indegrees_by_nodes.get(destination_node, 0)
            indegrees_by_nodes[destination_node] = 1 + destination_node_indegree

        zero_indegree_nodes = set(map(lambda e: e[0],
                                      filter(lambda e: 0 == e[1],
                                             indegrees_by_nodes.items())))

        output = []
        while 0 < len(zero_indegree_nodes):
            output.append(zero_indegree_nodes)

            for node in zero_indegree_nodes:
                for destination_node in destination_nodes_by_starting_node.get(node, set()):
                    indegrees_by_nodes[destination_node] -= 1

                del indegrees_by_nodes[node]

            zero_indegree_nodes = set(map(lambda e: e[0],
                                          filter(lambda e: 0 == e[1],
                                                 indegrees_by_nodes.items())))

        return output
