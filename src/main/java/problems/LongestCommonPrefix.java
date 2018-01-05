package problems;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            String prefix = first.substring(0, i + 1);
            for (String s : strs) {
                if (s.length() < prefix.length() || !s.substring(0, i + 1).equals(prefix)) {
                    return first.substring(0, i);
                }
            }
        }

        if (strs.length > 1 && !strs[1].startsWith(first)) {
            return "";
        }

        return first;
    }
}
