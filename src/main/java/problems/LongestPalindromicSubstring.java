package problems;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * * algorithms
 * * Medium (25.46%)
 * * Total Accepted:    327.7K
 * * Total Submissions: 1.3M
 * * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 *
 * Example 2:
 *
 *
 * Input: "cbbd"
 * Output: "bb"
 */

public class LongestPalindromicSubstring {
    private int maximumPalindromeStartIndex = 0;
    private int maximumPalindromeEndIndex = 0;

    /**
     * The strategy is to iterate through the input and try to extend the palindrome, assuming that it has an odd length
     * or an even length.
     *
     * Start with a start index of 0 and an end index of 0 (for odd palindrome).
     * Start with a start index of 0 and an end index of 1 (for even palindrome).
     *
     * Loop through the string character indices (from 0 to end index - 1).
     * In each loop, evaluate character to left and right of start and end index. Increment and decrement the end and
     * start indices, respectively until start or end index is at start/end of string or characters at the respective
     * indices do not match.
     *
     * If the start and end index are greater than the maximum differences, then set those values to the start and end
     * indices.
     */

    public String longestPalindrome(String s) {
        maximumPalindromeStartIndex = 0;
        maximumPalindromeEndIndex = 0;

        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            // odd palindrome
            calculateLongestPalindromicSubstring(s, i, i);
            // even palindrome
            calculateLongestPalindromicSubstring(s, i, i + 1);
        }

        return s.substring(maximumPalindromeStartIndex, maximumPalindromeEndIndex + 1);
    }

    private void calculateLongestPalindromicSubstring(String s, int startIndex, int endIndex) {
        while (startIndex >= 0 && endIndex <= s.length() - 1 && s.charAt(startIndex) == s.charAt(endIndex)) {
            startIndex--;
            endIndex++;
        }

        startIndex++;
        endIndex--;

        if (endIndex - startIndex > maximumPalindromeEndIndex - maximumPalindromeStartIndex) {
            maximumPalindromeEndIndex = endIndex;
            maximumPalindromeStartIndex = startIndex;
        }
    }
}
