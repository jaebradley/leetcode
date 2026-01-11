/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
 * every character in t (including duplicates) is included in the window.
 *
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 * Constraints:
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 */

/**
 * Approach:
 * Starting from the first index of s, expand the window by moving the right pointer to the right until all characters
 * from t are included in the window.
 * Then, move the left pointer to the right to try and minimize the window while still including all characters from t.
 * Once the window becomes invalid, move the right pointer to the right again to revalidate the window.
 * Keep track of the minimum window found during this process.
 * A "windowMatches" counter is used to track how many unique characters from the target substring have met their
 * required counts. This is to avoid iterating over the window character counts map each time.
 *
 * Runtime: O(m + n), where m is the length of s and n is the length of t. Each character in s and t is processed at most twice.
 * Space complexity: O(n + m). This can be considered O(1) since the character set is limited to uppercase and
 * lowercase English letters.
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
const minWindow = function (s, t) {
    let minimumWindowLength = Number.MAX_SAFE_INTEGER;
    let minimumWindow = "";
    let startIndex = 0;
    let endIndex = 0;
    const countsByTargetCharacter = new Map();

    for (let character of t) {
        countsByTargetCharacter.set(
            character,
            (countsByTargetCharacter.get(character) || 0) + 1
        );
    }

    let windowMatches = 0;
    const charactersInWindow = new Map();

    while (endIndex < s.length) {
        const character = s.charAt(endIndex);
        charactersInWindow.set(character, (charactersInWindow.get(character) || 0) + 1);

        const targetCounts = countsByTargetCharacter.get(character);
        const matchingCounts = charactersInWindow.get(character);
        if (matchingCounts !== undefined && matchingCounts === targetCounts) {
            windowMatches += 1;
        }

        while (startIndex <= endIndex && windowMatches === countsByTargetCharacter.size) {
            const currentWindowLength = endIndex - startIndex + 1;
            if (currentWindowLength < minimumWindowLength) {
                minimumWindowLength = currentWindowLength;
                minimumWindow = s.slice(startIndex, endIndex + 1);
            }

            const startCharacter = s.charAt(startIndex);
            charactersInWindow.set(startCharacter, charactersInWindow.get(startCharacter) - 1);
            if (countsByTargetCharacter.has(startCharacter) && charactersInWindow.get(startCharacter) < countsByTargetCharacter.get(startCharacter)) {
                windowMatches -= 1;
            }

            startIndex += 1;
        }

        endIndex += 1;
    }

    return minimumWindow;
};

export default minWindow;