package problems;

/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * Approach:
 *
 * 1. Create three 9 by 9 array-of-arrays. These represent the seen values for each of the rows, columns, and "squares".
 * 2. When iterating through all the values, if a value exists in a row at index i, the value should be marked as true
 *    for the array of booleans at index i.
 * 3. Same concept for columns and "squares" (of which there are 9 of in every sudoku)
 * 4. If a value is seen again in a row / column / square, the boolean value in the array at that index would be marked
 *    as true already. In such a case, have the function return false.
 * 5. If the entire grid is able to be iterated, return true.
 *
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        final boolean[][] seenRowValues = new boolean[9][9];
        final boolean[][] seenColumnValues = new boolean[9][9];
        final boolean[][] seenSquareValues = new boolean[9][9];

        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            final char[] row = board[rowIndex];
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                final char c = row[columnIndex];
                if ('.' != c) {
                    final int numericValue = Character.getNumericValue(c) - 1;
                    if (seenRowValues[rowIndex][numericValue]) {
                        return false;
                    }

                    if (seenColumnValues[columnIndex][numericValue]) {
                        return false;
                    }

                    final int squareIndex = 3 * (Math.floorDiv(rowIndex, 3)) + Math.floorDiv(columnIndex, 3);
                    if (seenSquareValues[squareIndex][numericValue]) {
                        return false;
                    }

                    seenRowValues[rowIndex][numericValue] = true;
                    seenColumnValues[columnIndex][numericValue] = true;
                    seenSquareValues[squareIndex][numericValue] = true;
                }
            }
        }

        return true;
    }
}
