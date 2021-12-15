package problems._1684;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        final int[] bitsByCharacterIndex = new int[26];

        for (int i = 0; i < 26; i += 1) {
            bitsByCharacterIndex[i] = (1 << i);
        }

        int allowedBitRepresentation = 0;
        for (final char c : allowed.toCharArray()) {
            allowedBitRepresentation = allowedBitRepresentation ^ bitsByCharacterIndex[c - 'a'];
        }

        int count = words.length;
        for (final String word : words) {
            for (final char c : word.toCharArray()) {
                final int bitRepresentation = bitsByCharacterIndex[c - 'a'];
                if ((bitRepresentation |  allowedBitRepresentation) != allowedBitRepresentation) {
                    count -= 1;
                    break;
                }
            }
        }

        return count;
    }

}
