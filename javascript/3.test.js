import test from "node:test";
import assert from "node:assert/strict";
import lengthOfLongestSubstring from "./3.js";

test('lengthOfLongestSubstring', () => {
    [
        [
            "abcabcbb",
            3
        ],
        [
            "bbbbb",
            1
        ],
        [
            "pwwkew",
            3
        ],
        [
            "",
            0
        ],
        [
            "j",
            1
        ],
        [
            "abcdefg",
            7
        ],
    ].forEach((testCase) => {
        assert.equal(lengthOfLongestSubstring(testCase[0]), testCase[1]);
    });
});

