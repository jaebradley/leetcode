/**
 * For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence. The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence. If word is not a substring of sequence, word's maximum k-repeating value is 0.
 *
 * Given strings sequence and word, return the maximum k-repeating value of word in sequence.
 *
 * Example 1:
 * Input: sequence = "ababc", word = "ab"
 * Output: 2
 * Explanation: "abab" is a substring in "ababc".
 * Example 2:
 * Input: sequence = "ababc", word = "ba"
 * Output: 1
 * Explanation: "ba" is a substring in "ababc". "baba" is not a substring in "ababc".
 * Example 3:
 * Input: sequence = "ababc", word = "ac"
 * Output: 0
 * Explanation: "ac" is not a substring in "ababc".
 *
 * Constraints:
 *
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence and word contains only lowercase English letters.
 */

/**
 * Approach:
 * Iterate over string, starting from index 0.
 * If string matches the input word, store the starting index in a set.
 * After iterating over the string, for each index in the string, check how many times the word can be found consecutively
 * starting from that index using the set of starting indices.
 * Keep track of the maximum count found.
 * Runtime: O(length of input sequence). Each character in the string is evaluated once. While the input word is
 * evaluated multiple times, it is only evaluated when a match is found, so at worst case, the total word evaluation
 * length is O(length of input sequence).
 * Space complexity: O(1). No additional space is used that scales with input size.
 * @param {string} sequence
 * @param {string} word
 * @return {number}
 */
const maxRepeating = function(sequence, word) {
    let maxCount = 0;
    const startingIndices = new Set();
    let currentStartIndex = 0;
    let currentEndIndex = word.length - 1;
    while (currentEndIndex < sequence.length) {
        const currentCandidate = sequence.slice(currentStartIndex, currentEndIndex + 1);
        if (currentCandidate === word) {
            startingIndices.add(currentStartIndex);
        }
        currentStartIndex += 1;
        currentEndIndex += 1;
    }

    for (let potentialStartingIndex = 0; potentialStartingIndex < sequence.length; potentialStartingIndex += 1) {
        let currentCount = 0;
        let startingIndex = potentialStartingIndex;
        while (startingIndices.has(startingIndex)) {
            startingIndex += word.length;
            currentCount += 1;
        }
        maxCount = Math.max(maxCount, currentCount);
    }

    return maxCount;
};

export default maxRepeating;