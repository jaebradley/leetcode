package problems;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/

 * algorithms
 * Medium (39.09%)
 * Total Accepted:    106.7K
 * Total Submissions: 273.1K
 * Testcase Example:  '[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n5'

 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:



 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.




 For example,

 Consider the following matrix:


 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]


 Given target = 5, return true.
 Given target = 20, return false.
 */

public class SearchA2DMatrix2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rowIndex = 0;
        int columnIndex = matrix[0].length - 1;

        while (columnIndex >= 0 && rowIndex <= matrix.length - 1) {
            int value = matrix[rowIndex][columnIndex];
            if (target < value) {
                columnIndex--;
            } else if (target > value) {
                rowIndex++;
            } else {
                return true;
            }
        }

        return false;
    }
}
