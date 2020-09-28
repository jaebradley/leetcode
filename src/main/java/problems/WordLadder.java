package problems;

/**
 * https://leetcode.com/problems/word-ladder/
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * Approach:
 *
 * 1. BFS by capturing all possible next transformations for each word state
 * 2. For each character of each word, iterate through all lower-case alphabetical characters and check if they exist
 *    in the dictionary.
 * 3. If they do, push them to queue of next set of words and evaluate this next set of words
 * 4. When evaluating each set of words, increment the distance
 */

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int distance = 1;
        Set<String> distinctWords = new HashSet<>(wordList);
        Set<String> visitedWords = new HashSet<>();
        Queue<String> nextWords = new LinkedList<>();

        nextWords.add(beginWord);

        while (!nextWords.isEmpty()) {
            Queue<String> nextNextWords = new LinkedList<>();

            for (String nextWord : nextWords) {
                if (nextWord.equals(endWord)) {
                    return distance;
                }

                visitedWords.add(nextWord);

                for (int i = 0; i < nextWord.length(); i++) {
                    char c = nextWord.charAt(i);
                    for (char nextLetter = 'a'; nextLetter <= 'z'; nextLetter++) {
                        if (nextLetter != c) {
                            StringBuilder potentialWordBuilder = new StringBuilder(nextWord);
                            potentialWordBuilder.setCharAt(i, nextLetter);
                            String potentialWord = potentialWordBuilder.toString();
                            if (!visitedWords.contains(potentialWord) && distinctWords.contains(potentialWord)) {
                                nextNextWords.add(potentialWord);
                            }
                        }
                    }
                }
            }

            distance++;
            nextWords = nextNextWords;
        }

        return 0;
    }
}
