import test from "node:test";
import assert from "node:assert/strict";
import minWindow from "./76.js";

test('minWindow', () => {
    [
        [
            ["ADOBECODEBANC", "ABC"],
            "BANC"
        ],
        [
            ["a", "a"],
            "a"
        ],
        [
            ["a", "aa"],
            ""
        ],
        [
            ["abc", "cba"],
            "abc"
        ],
    ].forEach((testCase) => {
        assert.equal(minWindow(...testCase[0]), testCase[1]);
    });
});

