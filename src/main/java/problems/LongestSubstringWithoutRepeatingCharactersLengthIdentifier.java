package problems;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

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
        Set<Character> substringCharacters = new HashSet<>();
        Queue<Character> seenCharacters = new LinkedBlockingQueue<>();

        for (char currentCharacter : s.toCharArray()) {
            if (substringCharacters.contains(currentCharacter)) {
                while (seenCharacters.peek() != currentCharacter) {
                    substringCharacters.remove(seenCharacters.poll());
                }
                seenCharacters.poll();
            } else {
                substringCharacters.add(currentCharacter);
            }

            seenCharacters.add(currentCharacter);

            if (substringCharacters.size() > longestSubstringLength) {
                longestSubstringLength = substringCharacters.size();
            }
        }
        return longestSubstringLength;
    }
}
