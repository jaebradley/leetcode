from typing import List


class HashSolution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        columns = [[0] * len(grid) for _ in range(len(grid[0]))]
        row_hashes = {}
        for row_index, row in enumerate(grid):
            hashed_row = str(row)
            count = row_hashes.get(hashed_row, 0)
            row_hashes[hashed_row] = 1 + count
            for column_index, value in enumerate(row):
                columns[column_index][row_index] = value

        pair_counter = 0

        for column in columns:
            hashed_column = str(column)
            hashed_column_count = row_hashes.get(hashed_column, 0)
            pair_counter += hashed_column_count

        return pair_counter


class TrieSolution:
    class Trie:
        class Node:
            def __init__(self, value: int):
                self.value = value
                self.count = 0
                self.children = {}

            def add_child(self, value: int):
                child = self.children.get(value, TrieSolution.Trie.Node(value))
                child.count += 1
                self.children[value] = child
                return child

    def equalPairs(self, grid: List[List[int]]) -> int:
        head = TrieSolution.Trie.Node(None)
        columns = [[0] * len(grid) for _ in range(len(grid[0]))]
        for row_index, row in enumerate(grid):
            current_node = head
            for column_index, value in enumerate(row):
                current_node = current_node.add_child(value)
                columns[column_index][row_index] = value

        def calculate_pairs(column: List[int]):
            node = head.children.get(column[0])
            if node is not None:
                for v in column[1:]:
                    node = node.children.get(v)
                    if node is None:
                        return 0

                return node.count

            return 0

        pair_counter = 0

        for column in columns:
            pair_counter += calculate_pairs(column)

        return pair_counter
