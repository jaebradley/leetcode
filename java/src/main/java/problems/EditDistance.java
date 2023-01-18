package problems;

/**
 * https://leetcode.com/problems/edit-distance/
 * <p>
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * <p>
 * You have the following three operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * <p>
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 * <p>
 * Approach:
 * <p>
 * 1. Have a 2-D grid, i x j
 * 2. A value at grid[i][j] represents the number of edits for word1[i] == word2[j]
 * 3. Base case is if one word is an empty string - then the number of edits is the length of the word
 * 4. If the words are the same at grid[i][j] the number of edits should be the same at grid[i - 1][j - 1]
 * 5. If word1[i - 1] != word2[j - 1] then
 * * Consider replacing character at word1[i - 1] with character at word2[j - 1]. This value is grid[i - 1][j - 1] + 1
 * * Consider deleting character at word[i - 1]. This value is grid[i - 1][j] + 1
 * * Consider inserting character at word[i - 1] with character at word2[j - 1]. This value is grid[i][j - 1] + 1
 * * Find minimum of these three cases
 * 6. Minimum edit distance should be value in bottom "right" of grid
 */

public class EditDistance {
    public int minDistance(String word1, String word2) {
        final int[][] distances = new int[word1.length() + 1][word2.length() + 1];
        for (int x = 1; x <= word1.length(); x++) {
            distances[x][0] = x;
        }

        for (int y = 1; y <= word2.length(); y++) {
            distances[0][y] = y;
        }

        for (int x = 1; x <= word1.length(); x++) {
            for (int y = 1; y <= word2.length(); y++) {
                final int previousDistanceValue = distances[x - 1][y - 1];
                if (word1.charAt(x - 1) == word2.charAt(y - 1)) {
                    distances[x][y] = previousDistanceValue;
                } else {
                    final int replacingDistanceValue = previousDistanceValue + 1;
                    final int deletionDistanceValue = distances[x - 1][y] + 1;
                    final int insertionDistanceValue = distances[x][y - 1] + 1;
                    distances[x][y] = Math.min(replacingDistanceValue, Math.min(deletionDistanceValue, insertionDistanceValue));
                }
            }
        }

        return distances[word1.length()][word2.length()];
    }
}
