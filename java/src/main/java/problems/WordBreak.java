package problems;

import java.util.List;

/**
 * https://leetcode.com/problems/word-break/description/
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not
 * contain duplicate words.
 */

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] wordExistence = new boolean[s.length() + 1];
        wordExistence[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordExistence[j] && wordDict.contains(s.substring(j, i))) {
                    wordExistence[i] = true;
                    break;
                }
            }
        }

        return wordExistence[s.length()];
    }
}
