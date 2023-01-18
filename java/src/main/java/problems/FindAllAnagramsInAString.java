package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

 * algorithms
 * Easy (33.91%)
 * Total Accepted:    59.7K
 * Total Submissions: 176.1K
 * Testcase Example:  '"cbaebabacd"\n"abc"'

 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".



 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> matchingStartIndices = new ArrayList<>();
        Map<Character, Integer> matchingCharacterCounts = new HashMap<>();

        for (char c : p.toCharArray()) {
            matchingCharacterCounts.merge(c, 1, (a, b) -> a + b);
        }

        Map<Character, Integer> potentialMatchingCharacterCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            potentialMatchingCharacterCounts.merge(c, 1, (a, b) -> a + b);

            if (i >= p.length() - 1) {
                int startIndex = i - p.length() + 1;
                if (potentialMatchingCharacterCounts.equals(matchingCharacterCounts)) {
                    matchingStartIndices.add(startIndex);
                }
                Integer startingCharacterCount = potentialMatchingCharacterCounts.get(s.charAt(startIndex));
                if (startingCharacterCount > 1) {
                    potentialMatchingCharacterCounts.put(s.charAt(startIndex), startingCharacterCount - 1);
                } else {
                    potentialMatchingCharacterCounts.remove(s.charAt(startIndex));
                }
            }
        }

        return matchingStartIndices;
    }
}
