package problems;

import java.util.*;

/**
 * https://leetcode.com/problems/partition-labels/
 *
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible
 * so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 *
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 *
 * Approach:
 *
 * 1. Iterate through string and identify the furthest position of a character - for any given section, this is the "max"
 *    range of the section that includes the character
 * 2. Iterate through the string again - keep track of characters seen
 * 3. Once the current character index in the string matches the max character position of the identified characters
 *    a full "part" has been seen and time to reset discovery of next part
 */

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> maxCharacterPositions = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
           char c = S.charAt(i);
           maxCharacterPositions.put(c, i);
        }
        List<Integer> parts = new ArrayList<>();
        int partLength = 0;
        int maxCharacterIndex = 0;
        Set<Character> charactersInPart = new HashSet<>();
        for (int j = 0; j < S.length(); j++) {
            partLength++;
            char c = S.charAt(j);
            charactersInPart.add(c);

            maxCharacterIndex = Math.max(maxCharacterIndex, maxCharacterPositions.get(c));

            if (maxCharacterIndex == j) {
                parts.add(partLength);
                maxCharacterIndex = 0;
                partLength = 0;
            }
        }
        return parts;
    }
}
