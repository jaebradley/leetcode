from typing import List


class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        combinations = []
        self.dfs(
            available_numbers=list(range(1, 10)),
            combinations_available=k,
            target_value=n,
            current_path=[],
            combinations=combinations
        )
        return combinations

    @staticmethod
    def dfs(
            available_numbers: List[int],
            combinations_available: int,
            target_value: int,
            current_path: List[int],
            combinations: List[List[int]]):
        if combinations_available < 0 or target_value < 0:
            return

        if combinations_available == 0 and target_value == 0:
            combinations.append(current_path)
        else:
            for index, next_available_number in enumerate(available_numbers):
                Solution.dfs(
                    available_numbers=available_numbers[index + 1:],
                    combinations_available=combinations_available - 1,
                    target_value=target_value - next_available_number,
                    current_path=current_path + [next_available_number],
                    combinations=combinations
                )
