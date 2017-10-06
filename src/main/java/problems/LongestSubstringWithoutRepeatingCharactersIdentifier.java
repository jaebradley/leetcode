package problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersIdentifier {
    public static String identify(String s) {
        int startIndex = 0;
        int currentIndex = 0;
        int longestSubstringStart = 0;
        int longestSubstringEnd = 0;
        Map<Character, Integer> characterIndices = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (currentIndex > longestSubstringEnd - longestSubstringStart) {
                longestSubstringEnd = currentIndex;
                longestSubstringStart = startIndex;
            }
            Character currentCharacter = s.charAt(i);
            Integer characterIndex = characterIndices.get(currentCharacter);
            if (characterIndex == null) {
                characterIndices.put(currentCharacter, currentIndex);
            } else {
                if (characterIndex >= startIndex) {
                    startIndex = currentIndex + 1;
                }
                characterIndices.put(currentCharacter, currentIndex);
            }
            currentIndex++;
        }
        return s.substring(longestSubstringStart, longestSubstringEnd);
    }
}
