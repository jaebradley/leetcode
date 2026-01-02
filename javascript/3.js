/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

/**
 * Approach:
 * Keep a set of seen characters.
 * Keep track of longest length. Initialize this value to 0.
 * Two pointers initialized to the start of the string.
 * While these pointers are less than the start of the string, execute the following loop. If the right pointer is
 * greater than the length of the string, return the longest length seen.
 * Loop:
 * For the current right index, check if the character has been seen.
 * If the character has been seen, remove the current left index character from the set, increment the left index
 * and execute the loop again.
 * If the character has not been seen, add the character to the set, and recalculate the longest length character
 * (right index - left index + 1). Increment the right index.
 *
 * Runtime: O(# of characters)
 * Space: O(# of characters)
 * @param {string} s
 * @return {number}
 */
const lengthOfLongestSubstring = function(s) {
    const uniqueCharacters = new Set();
    let longestLength = 0;
    let leftIndex = 0;
    let rightIndex = 0;

    while (rightIndex < s.length) {
        const currentCharacter = s[rightIndex];
        if (uniqueCharacters.has(currentCharacter)) {
            uniqueCharacters.delete(s[leftIndex]);
            leftIndex += 1;
        } else {
            uniqueCharacters.add(currentCharacter);
            longestLength = Math.max(longestLength, rightIndex - leftIndex + 1);
            rightIndex += 1;
        }
    }

    return longestLength;
};

export default lengthOfLongestSubstring;