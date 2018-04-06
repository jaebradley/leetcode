package problems;

/**
 * https://leetcode.com/problems/palindromic-substrings/description/

 * algorithms
 * Medium (54.87%)
 * Total Accepted:    36.6K
 * Total Submissions: 66.7K
 * Testcase Example:  '"abc"'


 Given a string, your task is to count how many palindromic substrings in this string.



 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.


 Example 1:

 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".



 Example 2:

 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".



 Note:

 The input string length won't exceed 1000.
 */

public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() && i < s.length() - 1 - i; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
