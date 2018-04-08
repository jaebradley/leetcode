package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/

 * algorithms
 * Medium (35.74%)
 * Total Accepted:    24.6K
 * Total Submissions: 69K
 * Testcase Example:  '"aaabb"\n3'


 Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.


 Example 1:

 Input:
 s = "aaabb", k = 3

 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.



 Example 2:

 Input:
 s = "ababbc", k = 2

 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {
        return longestSubstringWithIntervals(s, k, 0, s.length());
    }

    private static int longestSubstringWithIntervals(String s, int k, int start, int end) {
        if (end - start < k) {
            return 0;
        }

        Map<Character, Integer> characterCounts = new HashMap<>();

        for (int i = start; i < end; i++) {
            characterCounts.merge(s.charAt(i), 1, (a, b) -> a + b);
        }

        for (int i = start; i < end; i++) {
            if (characterCounts.get(s.charAt(i)) < k) {
                for (int j = i; j < end; j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        int leftLength = longestSubstringWithIntervals(s, k, start, j);
                        int rightLength = longestSubstringWithIntervals(s, k, j + 1, end);
                        return Math.max(leftLength, rightLength);
                    }
                }
            }
        }

        return end - start;
    }
}
