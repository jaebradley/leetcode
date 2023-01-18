package problems;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 *
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 *
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 *
 * Approach:
 * 1. One way to think about this is to find the longest common subsequence amongst the two strings and then take the
 *    difference in the length of the subsequence and the two specified words
 * 2. To get the longest common subsequence, build a two-dimensional grid where the x-axis indices represent the characters
 *    in the first word and the y-axis indices represent the characters in the second word
 * 3. Starting from 0,0 see if the two starting characters equal each other. If they do, set the value in the cell to 1.
 * 4. Continue this pattern, taking the maximum value in the cell "above" the current cell or to the "right" of the
 *    current cell unless the two characters match.
 *      A. If the two characters match, add 1 to the value captured in the diagonal that is up and to the left of the
 *         current cell. This cell represents the longest subsequence up to the previous x / y values. If some next
 *         x / y values match then increment the previous longest subsequence
 * 5. This should produce the length of the longest common subsequence
 */

public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        final int[][] counts = new int[word2.length() + 1][word1.length() + 1];
        for (int y = 1; y <= word2.length(); y++) {
            for (int x = 1; x <= word1.length(); x++) {
                if (word1.charAt(x - 1) == word2.charAt(y - 1)) {
                    counts[y][x] = counts[y - 1][x - 1] + 1;
                } else {
                    counts[y][x] = Math.max(counts[y - 1][x], counts[y][x - 1]);
                }
            }
        }
        final int longestCommonSubsequenceLength = counts[word2.length()][word1.length()];
        return word1.length() + word2.length() - (2 * longestCommonSubsequenceLength);
    }
}
