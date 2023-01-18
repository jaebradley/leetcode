package problems._1525;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numSplits(String s) {
        final char[] chars = s.toCharArray();
        final Set<Character> uniqueLeftToRightCharacters = new HashSet<>();
        final Set<Character> uniqueRightToLeftCharacters = new HashSet<>();
        final int[] leftToRightUniqueCharacterCount = new int[chars.length];
        final int[] rightToLeftUniqueCharacterCount = new int[chars.length];

        for (int i = 0; i < chars.length; i += 1) {
            uniqueLeftToRightCharacters.add(chars[i]);
            uniqueRightToLeftCharacters.add(chars[chars.length - 1 - i]);
            leftToRightUniqueCharacterCount[i] = uniqueLeftToRightCharacters.size();
            rightToLeftUniqueCharacterCount[chars.length - 1 - i] = uniqueRightToLeftCharacters.size();
        }

        int count = 0;
        for (int i = 1; i < chars.length; i += 1) {
            if (leftToRightUniqueCharacterCount[i - 1] == rightToLeftUniqueCharacterCount[i]) {
                count += 1;
            }
        }

        return count;
    }
}
