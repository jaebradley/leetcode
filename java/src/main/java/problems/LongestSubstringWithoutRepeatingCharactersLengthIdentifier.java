package problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharactersLengthIdentifier {
    public static int identify(String s) {
        int longestSubstringLength = 0;
        Set<Character> substringCharacterFilter = new HashSet<>();
        Deque<Character> characterWindow = new ArrayDeque<>();

        for (char currentCharacter : s.toCharArray()) {
            if (substringCharacterFilter.contains(currentCharacter)) {
                while (characterWindow.getFirst() != currentCharacter) {
                    substringCharacterFilter.remove(characterWindow.removeFirst());
                }

                characterWindow.removeFirst();
            } else {
                substringCharacterFilter.add(currentCharacter);
            }

            characterWindow.addLast(currentCharacter);

            if (longestSubstringLength < substringCharacterFilter.size()) {
                longestSubstringLength = substringCharacterFilter.size();
            }
        }

        return longestSubstringLength;
    }
}
