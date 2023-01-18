package problems._140;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/
 *
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * Example 2:
 *
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 */

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        final List<String> sentences = new ArrayList<>();
        findWords(0, s, new LinkedList<>(), new HashSet<>(wordDict), sentences);
        return sentences;
    }

    public static void findWords(final int currentIndex, final String value, final LinkedList<String> currentSentence, final Set<String> validWords, final List<String> sentences) {
        if (currentIndex == value.length()) {
            sentences.add(String.join(" ", currentSentence));
        } else {
            for (int nextWordIndex = currentIndex + 1; nextWordIndex <= value.length(); nextWordIndex += 1) {
                final String substring = value.substring(currentIndex, nextWordIndex);
                if (validWords.contains(substring)) {
                    currentSentence.addLast(substring);
                    findWords(nextWordIndex, value, currentSentence, validWords, sentences);
                    currentSentence.removeLast();
                }
            }
        }
    }

}
