# [Length of Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)

## Problem ([from Leetcode](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/))
> Given a string, find the length of the longest substring without repeating characters.

## Examples:
Given `abcabcbb`, the answer is `abc`, which the length is `3`.

`bbbbb`, the answer is `b`, with the length of `1`.

Given `pwwkew`, the answer is `wke`, with the length of `3`. Note that the answer must be a substring, `pwke` is a subsequence and not a substring.

## Discussion
The general strategy is the following

1. Keep track of the substring characters in a `Set`.
2. Keep track of the evaluated ("seen") characters in a `Queue`.
3. Iterate through the characters in the input `String`.
  * If the substring characters include the current character
    1. Iterate through the head of the seen characters `Queue` until you find a match in the `Queue`.
    2. For each non-matching character from the `Queue`, remove it from the `Queue` and remove it from the `Set`.
    3. Once you find a matching character, remove it from the head of the `Queue` and add it to the tail of the `Queue`.
  * Else
    * Add the current character to the `Set`
    * Add the current character to the tail of the `Queue`.
  4. If the `size` of the `Set` is greater than the current longest substring length, replace the current longest substring length with the `Set` `size`.

  Let's run through an example:

  `tmmzu`

  * Initial
    * Substring Characters: `[]`
    * Seen Characters: `[]`
    * Longest Substring Length: `0`
  * `t`
    * Substring Characters: `[t]`
    * Seen Characters: `[t]`
    * Longest Substring Length: `1`
  * `m`
    * Substring Characters: `[t, m]`
    * Seen Characters: `[t, m]`
    * Longest Substring Length: `2`
  * `m`
    * Substring Characters: `[m]`
    * Seen Characters: `[m]`
    * Longest Substring Length: `2`
  * `z`
    * Substring Characters: `[m, z]`
    * Seen Characters: `[m, z]`
    * Longest Substring Length: `2`
  * `u`
    * Substring Characters: `[m, z, u]`
    * Seen Characters: `[m, z, u]`
    * Longest Substring Length: `3`

* Naming sucks - open to a better name
  * There's gotta be something better than `LongestSubstringWithoutRepeatingCharactersLengthIdentifier`...right?

## Implementation

<!-- language: lang-java -->
    import java.util.HashSet;
    import java.util.Queue;
    import java.util.Set;
    import java.util.concurrent.LinkedBlockingQueue;

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
