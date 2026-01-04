"""
There are n types of units indexed from 0 to n - 1. You are given a 2D integer array conversions of length n - 1, where
conversions[i] = [sourceUniti, targetUniti, conversionFactori]. This indicates that a single unit of type sourceUniti
is equivalent to conversionFactori units of type targetUniti.

Return an array baseUnitConversion of length n, where baseUnitConversion[i] is the number of units of type i equivalent
to a single unit of type 0. Since the answer may be large, return each baseUnitConversion[i] modulo 109 + 7.

Example 1:
Input: conversions = [[0,1,2],[1,2,3]]
Output: [1,2,6]
Explanation:
Convert a single unit of type 0 into 2 units of type 1 using conversions[0].
Convert a single unit of type 0 into 6 units of type 2 using conversions[0], then conversions[1].

Example 2:
Input: conversions = [[0,1,2],[0,2,3],[1,3,4],[1,4,5],[2,5,2],[4,6,3],[5,7,4]]
Output: [1,2,3,8,10,6,30,24]
Explanation:
Convert a single unit of type 0 into 2 units of type 1 using conversions[0].
Convert a single unit of type 0 into 3 units of type 2 using conversions[1].
Convert a single unit of type 0 into 8 units of type 3 using conversions[0], then conversions[2].
Convert a single unit of type 0 into 10 units of type 4 using conversions[0], then conversions[3].
Convert a single unit of type 0 into 6 units of type 5 using conversions[1], then conversions[4].
Convert a single unit of type 0 into 30 units of type 6 using conversions[0], conversions[3], then conversions[5].
Convert a single unit of type 0 into 24 units of type 7 using conversions[1], conversions[4], then conversions[6].


Constraints:
2 <= n <= 105
conversions.length == n - 1
0 <= sourceUniti, targetUniti < n
1 <= conversionFactori <= 109
It is guaranteed that unit 0 can be converted into any other unit through a unique combination of conversions without
using any conversions in the opposite direction.
"""
from collections import namedtuple, defaultdict, deque
from typing import List


class UnionFindSolution:
    """
    Conversions are a graph problem.
    Each conversion represents a directed edge from unit 1 to unit 2.
    Parent of unit 2 is unit 1 and there is a mapping of conversion factors to unit 1.
    Keep sizes of each parent.
    At the end, create a function like the find function that calculates the conversion at each step.
    Don't forget to modulo.
    Runtime: O(# of conversions x log # of conversions) due to the Union Find "find" function
    Space: O(# of conversions)
    """

    def baseUnitConversions(self, conversions: List[List[int]]) -> List[int]:
        Node = namedtuple("Node", ["conversion_factor", "value"])
        parents_by_node = {0: Node(conversion_factor=1, value=0)}

        def find(node_value: int):
            parent_node = parents_by_node[node_value]
            if parent_node.value != node_value:
                root = find(parent_node.value)
                updated_node = Node(value=root.value,
                                    conversion_factor=parent_node.conversion_factor * root.conversion_factor)
                parents_by_node[node_value] = updated_node
            return parents_by_node[node_value]

        for source_unit, target_unit, conversion_factor in conversions:
            parents_by_node[target_unit] = Node(value=source_unit, conversion_factor=conversion_factor)

        results = [0] * (len(conversions) + 1)
        for node_value in range(len(conversions) + 1):
            results[node_value] = find(node_value).conversion_factor % (10 ** 9 + 7)

        return results


class BFSSolution:
    """
    Each conversion represents a directed edge from unit 1 to unit 2.
    Adjacency list of source unit to target unit and conversion factor.
    Starting with the source unit 0, add all source unit adjacency items to a queue.
    Each item contains the current unit and the current conversion factor.
    If item has not been visited, add its conversion factor to the results and add its adjacency items to the queue.
    Don't forget to modulo.
    Return the results.
    """

    def baseUnitConversions(self, conversions: List[List[int]]) -> List[int]:
        Item = namedtuple("Item", ["conversion_factor", "value"])
        results = [None] * (len(conversions) + 1)
        adjacency_list = defaultdict(set)
        for source_unit, target_unit, conversion_factor in conversions:
            adjacency_list[source_unit].add(Item(value=target_unit, conversion_factor=conversion_factor))

        queue = deque([0])
        results[0] = 1
        while queue:
            current_item = queue.popleft()
            for neighbor in adjacency_list[current_item]:
                if results[neighbor.value] is None:
                    results[neighbor.value] = (results[current_item] * neighbor.conversion_factor) % (10 ** 9 + 7)
                    queue.append(neighbor.value)

        return results