"""
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]


Constraints:

1 <= n <= 9
"""
from copy import deepcopy
from typing import List


class Solution:
    """
    Attempt to add queen to first column of first row.

    Rules:
    - No queen in the same row.
    - No queen in the same column.
    - No queen in the same diagonal increasing from left-to-right.
    - No queen in the same diagonal decreasing from left-to-right (calling this the anti-diagonal).

    Backtracking:
    - Check to see if done, if so, add state to result
    - Check all possible next steps, if possible
    - Continue execution down these next steps
    - Continue execution down all previous possible steps before this state (i.e. adding queen to second column of first row)

    - Done check is if the current value of n is 0
    - All possible next steps can be calculated given the previous columns that have a queen.
    - Given a queen on row index R and column index C, another queen cannot also be on index R + C (the anti-diagonal)
      and R - C (the diagonal).
    - Continuing execution means calling recursive function with a decremented n and the updated queen placement
      information.

    Runtime: n possible cells in the first row. For each of these cells, n cells in the second row will be considered.
    So in worst case this is O(n!).
    Space: Keeping track of n queens is O(n). Building the output board is O(n x n). Since O(n ^ 2) dominates O(n)
    space is O(n ^ 2).
    """

    def solveNQueens(self, n: int) -> List[List[str]]:
        results = []

        def backtrack(remaining_queens: int, ineligible_columns: set[int], ineligible_diagonals: set[int],
                      ineligible_anti_diagonals: set[int], current_result: List[str]) -> None:
            if remaining_queens == 0:
                results.append(deepcopy(current_result))
                return

            row_index = n - remaining_queens
            eligible_column_indices = set(range(n)) - ineligible_columns

            for current_column_index in eligible_column_indices:
                current_diagonal = row_index - current_column_index
                current_anti_diagonal = current_column_index + row_index

                if current_diagonal not in ineligible_diagonals and current_anti_diagonal not in ineligible_anti_diagonals:
                    current_row = ["."] * n
                    current_row[current_column_index] = "Q"

                    ineligible_columns.add(current_column_index)
                    ineligible_diagonals.add(current_diagonal)
                    ineligible_anti_diagonals.add(current_anti_diagonal)

                    current_result.append("".join(current_row))

                    backtrack(remaining_queens=remaining_queens - 1,
                              ineligible_columns=ineligible_columns,
                              ineligible_diagonals=ineligible_diagonals,
                              ineligible_anti_diagonals=ineligible_anti_diagonals,
                              current_result=current_result)

                    ineligible_columns.remove(current_column_index)
                    ineligible_diagonals.remove(current_diagonal)
                    ineligible_anti_diagonals.remove(current_anti_diagonal)

                    current_result.pop()

        backtrack(remaining_queens=n,
                  ineligible_columns=set(),
                  ineligible_diagonals=set(),
                  ineligible_anti_diagonals=set(),
                  current_result=[])

        return results
