package problems;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * If there is no common subsequence, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 *
 * Approach:
 *
 * 1. Idea is to build an M x N matrix where each column is text 1's characters and each row is text 2's characters
 * 2. Each cell value initially starts as 0 - when a cell represents a matching character for the column / row combination
 *    increment the max value of the cell that is diagonally up to the left from existing cell. This represents the count
 *    when both characters have not been "added" yet
 * 3. The value at the last cell (i.e. the bottom-right-most cell) should indicate the longest subsequence
 * 4. As a trick to not worry about index out of bounds errors, make the counts matrix 1 row / column larger
 */

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] subsequenceCounts = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            char firstTextCharacter = text1.charAt(i - 1);

            for (int j = 1; j <= text2.length(); j++) {
                char secondTextCharacter = text2.charAt(j - 1);

                if (firstTextCharacter == secondTextCharacter) {
                    subsequenceCounts[i][j] = subsequenceCounts[i - 1][j - 1] + 1;
                } else {
                    subsequenceCounts[i][j] = Math.max(
                            subsequenceCounts[i - 1][j],
                            subsequenceCounts[i][j - 1]
                    );
                }
            }
        }

        return subsequenceCounts[text1.length()][text2.length()];
    }
}
