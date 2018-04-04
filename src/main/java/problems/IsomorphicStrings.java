package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/isomorphic-strings/description/

 * algorithms
 * Easy (34.71%)
 * Total Accepted:    133.5K
 * Total Submissions: 384.6K
 * Testcase Example:  '"egg"\n"add"'

 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 */

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sCharacterCounts = new HashMap<>();
        Map<Character, Integer> tCharacterCounts = new HashMap<>();
        Map<Character, Character> characterMapping = new HashMap<>();

        for (int i = 0; i < s.length(); i ++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            Character sToT = characterMapping.get(sChar);

            if ((sToT == null && characterMapping.containsValue(tChar)) || (sToT != null && sToT != tChar)) {
                return false;
            }

            characterMapping.put(sChar, tChar);

            Integer sCharCount = sCharacterCounts.get(sChar);
            Integer tCharCount = tCharacterCounts.get(tChar);

            if (!Objects.equals(sCharCount, tCharCount)) {
                return false;
            }

            if (sCharCount == null) {
                sCharacterCounts.put(sChar, 1);
                tCharacterCounts.put(tChar, 1);
            } else {
                sCharacterCounts.put(sChar, sCharCount + 1);
                tCharacterCounts.put(tChar, tCharCount + 1);
            }
        }

        return true;
    }
}
