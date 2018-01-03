package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * For an input string, find the index of the first non-repeating character. If no character exists, return -1
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */

public class FirstUniqueCharacterIndexIdentifier {
    public static int identify(String value) {
        Set<Character> uniqueCharacters = new HashSet<>();
        Set<Character> duplicateCharacters = new HashSet<>();

        for (char c : value.toCharArray()) {
            if (uniqueCharacters.contains(c)) {
                uniqueCharacters.remove(c);
                duplicateCharacters.add(c);
            } else if (!duplicateCharacters.contains(c)) {
                uniqueCharacters.add(c);
            }
        }

        for (int i = 0; i < value.length(); i++) {
            if (uniqueCharacters.contains(value.charAt(i))) {
                return i;
            }
        }

        return -1;
    }

    public static int identify1(String value) {
        int[] counts = new int[256];
        for (char c : value.toCharArray()) {
            counts[c]++;
        }
        for (int i = 0; i < value.length(); i++) {
            if (counts[value.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
